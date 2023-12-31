package com.example.api.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api.data.model.remote.UserModel
import com.example.api.databinding.CardViewUserBinding

class ViewHolder(
    parent: ViewGroup,
    private val binding: CardViewUserBinding = CardViewUserBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )
) : RecyclerView.ViewHolder(binding.root) {
    fun bindUser(
        userModel: UserModel,
        navigateFunction: (title: Int) -> Unit
    ) {
        binding.name.text = userModel.name
        binding.phone.text = userModel.phone

        binding.cardViewClick.setOnClickListener {
            navigateFunction(userModel.id)
        }

    }
}