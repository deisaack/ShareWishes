package com.addictaf.sharewishes.addapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.addictaf.sharewishes.R
import com.addictaf.sharewishes.models.HomeModel

class HomeAdapter(val data: List<HomeModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        val TEXT = 1;
        val IMAGE = 2;
        val VIDEO = 3;
    }


    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        when(viewType){
            TEXT -> return TextViewHolder(layoutInflater.inflate(R.layout.row_homeadapter_text, parent, false))
            IMAGE -> return ImageViewHolder(layoutInflater.inflate(R.layout.row_homeadapter_image, parent, false))
            VIDEO -> return VideoViewHolder(layoutInflater.inflate(R.layout.row_homeadapter_video, parent, false))
        }
        return object : RecyclerView.ViewHolder(View(parent.context)){}
    }

    override fun getItemCount() = data.size


    override fun getItemViewType(position: Int): Int {
        return data[position].viewType
    }

    class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    class VideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}