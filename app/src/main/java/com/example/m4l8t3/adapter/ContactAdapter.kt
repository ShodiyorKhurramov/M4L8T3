package com.example.m4l8t3.adapter



import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m4l8t3.R
import com.example.m4l8t3.model.Contact


class ContactAdapter(
    private val contacts: List<Contact>,
    private val listener: ItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact_list, parent, false)
        return ItemContactViewHolder(view)
    }

    class ItemContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photo: ImageView = view.findViewById(R.id.iv_item_contact_photo)
        val name: TextView = view.findViewById(R.id.tv_item_contact_name)
        val number: TextView = view.findViewById(R.id.tv_item_contact_number)
        val item: LinearLayout = view.findViewById(R.id.main_item)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val person = contacts[position]

        if (holder is ItemContactViewHolder) {
            holder.apply {
                photo.setImageResource(person.photo)
                name.text = person.name
                number.text = person.number
                item.setOnClickListener {
                    listener.itemClick(person)
                }
            }
        }

    }

    class ItemClickListener(val itemClick: (contact: Contact) -> Unit)

    override fun getItemCount() = contacts.size

}