package com.addictaf.sharewishes.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

object Utils {
    fun openFragment(fragmentManager: FragmentManager, className: Class<out Fragment>, frameLayoutId: Int){
        when {
            !isFragmentAlreadyAdded(fragmentManager, className) -> {
                val visibleFragment = visibleFragment(fragmentManager)
                val fragmentTransaction = fragmentManager.beginTransaction()
                if (visibleFragment != null)
                    fragmentTransaction.hide(visibleFragment)
                val replacedFragment = className.newInstance()
                fragmentTransaction.add(frameLayoutId, replacedFragment, className::class.java.simpleName)
                fragmentTransaction.commit()
            }
            else -> showFragment(fragmentManager, className)
        }
    }

    private fun showFragment(fragmentManager: FragmentManager, className: Class<out Fragment>){
        val fragnentList = fragmentManager.fragments
        val fragmentTransaction = fragmentManager.beginTransaction()
        for (fragment in fragnentList) {
            fragment.let {
                if (fragment.javaClass.simpleName == className.simpleName)
                    fragmentTransaction.show(fragment)
                else
                    fragmentTransaction.hide(fragment)
            }

        }
        fragmentTransaction.commit()
    }

    private fun isFragmentAlreadyAdded(fragmentManager: FragmentManager, className: Class<out Fragment>): Boolean{
        val fragnentList = fragmentManager.fragments
        fragnentList.forEach { fragment ->
            if (fragment != null && fragment.javaClass.simpleName == className.simpleName)
                return true
        }
        return false
    }

    private fun visibleFragment(fragmentManager: FragmentManager): Fragment? {
        val fragmentList = fragmentManager.fragments
        return fragmentList.firstOrNull { it !=null && it.isVisible }
    }
}
