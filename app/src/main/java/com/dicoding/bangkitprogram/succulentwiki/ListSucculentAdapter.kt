package com.dicoding.bangkitprogram.succulentwiki

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class ListSucculentAdapter(private val listSucculent: ArrayList<Succulent>) :
    RecyclerView.Adapter<ListSucculentAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_subname)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var clickSeeDetail: LinearLayout = itemView.findViewById(R.id.clickToDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_suc, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSucculent.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val succulent = listSucculent[position]
        var finalposition = position
        Glide.with(holder.itemView.context)
            .load(succulent.picture)
            .apply(RequestOptions().override(150, 150))
            .into(holder.imgPhoto)
        holder.tvName.text = succulent.name
        holder.tvDetail.text = succulent.common_name
        holder.clickSeeDetail.setOnClickListener {
            val context= holder.clickSeeDetail.context
            val SucculentDetailActivity = Intent(context, Detailed::class.java)
            SucculentDetailActivity.putExtra(Detailed.DATA_NAME, succulent.name)
            SucculentDetailActivity.putExtra(Detailed.DATA_COMMNAME, succulent.common_name)
            SucculentDetailActivity.putExtra(Detailed.DATA_PICT, succulent.picture)
            SucculentDetailActivity.putExtra(Detailed.DATA_DETAIL, succulent.detail)
            SucculentDetailActivity.putExtra(Detailed.DATA_SUN, succulent.sun)
            SucculentDetailActivity.putExtra(Detailed.DATA_GROW, succulent.grow)
            SucculentDetailActivity.putExtra(Detailed.DATA_WATER,succulent.water)
            SucculentDetailActivity.putExtra(Detailed.DATA_TEMP, succulent.temp)
            SucculentDetailActivity.putExtra(Detailed.DATA_PROP, succulent.propagation)
            SucculentDetailActivity.putExtra(Detailed.DATA_TOX, succulent.toxic)
            SucculentDetailActivity.putExtra(Detailed.DATA_DOR, succulent.dormant)

            context.startActivity(SucculentDetailActivity)
        }

    }



}