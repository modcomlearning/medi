package com.modcom.meditest

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.akiniyalocts.pagingrecycler.PagingAdapter
import com.bumptech.glide.Glide

class DataAdpter(private var dataList: List < recyclerresponse > , private val context: Context): RecyclerView.Adapter < DataAdpter.ViewHolder > () , Filterable  {
           override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.listcard, parent, false))
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList.get(position)
        holder.titleTextView.text = dataModel.title
        holder.title.text = dataModel.url

        Glide.with(context).load("https://www.modcom.co.ke/pics/image1.png").centerCrop().into(holder.imageView)

        Toast.makeText(
            context, "You CLicked " + dataModel.thumbnailUrl,
            Toast.LENGTH_SHORT
        ).show()
    }
    class ViewHolder(itemLayoutView: View): RecyclerView.ViewHolder(itemLayoutView) {
        lateinit
        var titleTextView: TextView
        lateinit
        var title: TextView
        var imageView: ImageView
        init {
            imageView = itemLayoutView.findViewById<ImageView>(R.id.imageView)
            titleTextView = itemLayoutView.findViewById(R.id.tvTitle)
            title = itemLayoutView.findViewById(R.id.tvDescription)
        }
    }
    fun filterList(filteredNames: ArrayList < recyclerresponse > ) {
        Log.e("list", filteredNames.toString())
        Log.e("list", filteredNames.size.toString())
        // this.dataList.clear()
        this.dataList = filteredNames
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }
}
