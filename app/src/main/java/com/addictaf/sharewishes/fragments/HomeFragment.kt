package com.addictaf.sharewishes.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.addictaf.sharewishes.R
import com.addictaf.sharewishes.addapter.HomeAdapter
import com.addictaf.sharewishes.models.HomeModel
import kotlinx.android.synthetic.main.include_recyclerview.*

class HomeFragment : Fragment() {

    lateinit var homeAdapter: HomeAdapter
    lateinit var homeData: MutableList<HomeModel>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_homefragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_contents.layoutManager=LinearLayoutManager(context)
        homeData = mutableListOf()
        homeAdapter= HomeAdapter(homeData)
        rv_contents.adapter = homeAdapter
        addDummyData()
    }

    private fun addDummyData() {
        val homeModel1 = HomeModel(HomeAdapter.TEXT)
        val homeModel2 = HomeModel(HomeAdapter.IMAGE)
        val homeModel3 = HomeModel(HomeAdapter.VIDEO)
        val homeModel4 = HomeModel(HomeAdapter.IMAGE)
        val homeModel5 = HomeModel(HomeAdapter.TEXT)
        val homeModel6 = HomeModel(HomeAdapter.IMAGE)

        homeData.add(homeModel1)
        homeData.add(homeModel2)
        homeData.add(homeModel3)
        homeData.add(homeModel4)
        homeData.add(homeModel5)
        homeData.add(homeModel6)
        homeAdapter.notifyDataSetChanged()
    }
}