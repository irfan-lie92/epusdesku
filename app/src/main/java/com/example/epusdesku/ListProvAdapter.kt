package com.example.epusdesku

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListPerpusAdapter(private val listPerpus: List<Perpus>) : RecyclerView.Adapter<ListPerpusAdapter.ListViewHolder>() {
    private val list: List<Perpus> = listPerpus

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_perpus, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val perpus = listPerpus[position]

        holder.picture.setImageResource(perpus.photo)
        holder.name.text = perpus.name
        holder.pemustaka.text = perpus.pemustaka
        holder.description.text = perpus.description

        holder.itemView.setOnClickListener {
            val passItem = Intent(holder.itemView.context, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_NAME, perpus.name)
                putExtra(DetailActivity.EXTRA_DESA, perpus.desa)
                putExtra(DetailActivity.EXTRA_TAHUN, perpus.tahun)
                putExtra(DetailActivity.EXTRA_PEMUSTAKA, perpus.pemustaka)
                putExtra(DetailActivity.EXTRA_DESCRIPTION, perpus.description)
                putExtra(DetailActivity.EXTRA_IMAGE, perpus.photo)
            }
            holder.itemView.context.startActivity(passItem)
        }
    }

    override fun getItemCount(): Int {
        return listPerpus.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_item_name)
        var pemustaka: TextView = itemView.findViewById(R.id.tv_item_pemustaka)
        var description: TextView = itemView.findViewById(R.id.tv_item_description)
        var picture: ImageView = itemView.findViewById(R.id.img_item_photo)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val perpus = list[position]
                    val intent = Intent(itemView.context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.EXTRA_NAME, perpus.name)
                        putExtra(DetailActivity.EXTRA_DESA, perpus.desa)
                        putExtra(DetailActivity.EXTRA_TAHUN, perpus.tahun)
                        putExtra(DetailActivity.EXTRA_PEMUSTAKA, perpus.pemustaka)

                        putExtra(DetailActivity.EXTRA_DESCRIPTION, perpus.description)
                        putExtra(DetailActivity.EXTRA_IMAGE, perpus.photo)
                    }
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}