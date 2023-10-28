package com.example.api.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.api.base.BaseFragment
import com.example.api.databinding.FragmentDetailedBinding

class DetailedFragment : BaseFragment<FragmentDetailedBinding>(
    FragmentDetailedBinding::inflate
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = requireArguments().getInt("id")
    }
}