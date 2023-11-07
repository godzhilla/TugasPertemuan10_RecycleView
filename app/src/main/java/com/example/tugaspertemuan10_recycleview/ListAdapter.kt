package com.example.tugaspertemuan10_recycleview

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspertemuan10_recycleview.databinding.ItemListBinding

typealias OnClickList = (ListModel) -> Unit

class ListAdapter(private val listListModel : List<ListModel>, private val onClickList : OnClickList) : RecyclerView.Adapter<ListAdapter.ItemListModelViewHolder>() {
    inner class ItemListModelViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ListModel) {
            with(binding){
                ivList.setImageResource(data.foto)
                txtNamaMhs.text = data.nama
                txtNim.text = data.nim
                txtIpk.text = data.ipk.toString()

                if (data.ipk >= 3.5) {
                    txtIpk.setTextColor(Color.parseColor("#00C036"))
                }
                else if (data.ipk < 3.5 && data.ipk >= 3.0) {
                    txtIpk.setTextColor(Color.parseColor("#C0B800"))
                }
                else {
                    txtIpk.setTextColor(Color.parseColor("#C00000"))
                }

                itemView.setOnClickListener{
                    onClickList(data)
                }

            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListModelViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemListModelViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listListModel.size
    }

    override fun onBindViewHolder(holder: ItemListModelViewHolder, position: Int) {
        holder.bind(listListModel[position])
    }

}