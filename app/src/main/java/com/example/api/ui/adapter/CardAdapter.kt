package com.example.api.ui.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api.data.model.remote.UserModel

class CardAdapter(
    private val userList: ArrayList<UserModel>,
    private val navigateToScreen: (Int) -> Unit
) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = userList[position]
        holder.bindUser(item, navigateToScreen)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<UserModel>) {
        userList.clear()
        userList.addAll(newList)
        notifyDataSetChanged()
    }
}
