package com.techsultan.contactappzuritask.contact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.techsultan.contactappzuritask.R

class ContactAdapter() : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {


    private var contacts = mutableListOf<ContactModel>()


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nameTv : TextView = itemView.findViewById(R.id.contactTv)
        var numberTv : TextView = itemView.findViewById(R.id.numberTv)

    }

    fun setDataList(contact : List<ContactModel> ) {

        this.contacts.addAll(contact)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var contact = contacts[position]

        holder.nameTv.text = contact.name
        holder.numberTv.text = contact.number
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}