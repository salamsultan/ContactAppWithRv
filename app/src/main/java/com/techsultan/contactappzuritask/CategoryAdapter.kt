package com.techsultan.contactappzuritask


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.techsultan.contactappzuritask.databinding.CategoryListBinding

class CategoryAdapter(

    private val listener: OnItemClickListener

    ) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var dataList = emptyList<CategoryModel>()


    internal fun setDataList(dataList : List<CategoryModel>) {

        this.dataList = dataList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

            var textView : TextView = itemView.findViewById(R.id.categoryTv)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }



    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.category_list, parent,
        false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = dataList[position]


        holder.textView.text = data.Category
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


}


