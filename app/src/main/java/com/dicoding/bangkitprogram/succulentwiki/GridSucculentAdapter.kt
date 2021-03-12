package com.dicoding.bangkitprogram.succulentwiki

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridSucculentAdapter(val listSuc: ArrayList<Succulent>) : RecyclerView.Adapter<GridSucculentAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid_suc, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listSuc[position].picture)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.imgPhoto.setOnClickListener {
            val context= holder.imgPhoto.context
            val SucculentDetailActivity = Intent(context, Detailed::class.java)
            SucculentDetailActivity.putExtra(Detailed.DATA_NAME, listSuc[position].name)
            SucculentDetailActivity.putExtra(Detailed.DATA_COMMNAME, listSuc[position].common_name)
            SucculentDetailActivity.putExtra(Detailed.DATA_PICT, listSuc[position].picture)
            SucculentDetailActivity.putExtra(Detailed.DATA_DETAIL, listSuc[position].detail)
            SucculentDetailActivity.putExtra(Detailed.DATA_SUN, listSuc[position].sun)
            SucculentDetailActivity.putExtra(Detailed.DATA_GROW, listSuc[position].grow)
            SucculentDetailActivity.putExtra(Detailed.DATA_WATER,listSuc[position].water)
            SucculentDetailActivity.putExtra(Detailed.DATA_TEMP, listSuc[position].temp)
            SucculentDetailActivity.putExtra(Detailed.DATA_PROP, listSuc[position].propagation)
            SucculentDetailActivity.putExtra(Detailed.DATA_TOX, listSuc[position].toxic)
            SucculentDetailActivity.putExtra(Detailed.DATA_DOR, listSuc[position].dormant)

            context.startActivity(SucculentDetailActivity)
        }
    }

    override fun getItemCount(): Int {
        return listSuc.size
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}