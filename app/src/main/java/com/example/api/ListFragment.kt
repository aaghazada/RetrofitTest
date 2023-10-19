package com.example.api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api.data.model.remote.UserModel
import com.example.api.databinding.FragmentListBinding
import com.example.api.helper.RetrofitHelper
import com.example.api.ui.adapter.CardAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    lateinit var userRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userRecyclerView = binding.recyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val cardAdapter = CardAdapter(arrayListOf()) {
            navigate(it)
        }
        userRecyclerView.adapter = cardAdapter

        val apiService = RetrofitHelper.apiService

        apiService.getUsers().enqueue(object : Callback<List<UserModel>> {
            override fun onResponse(
                call: Call<List<UserModel>>,
                response: Response<List<UserModel>>
            ) {
                if (response.isSuccessful) {
                    val userList = response.body()
                    userList?.let { cardAdapter.updateList(it) } // error may be here
                } else {
                    // Handle the error
                }
            }

            override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
                t.printStackTrace()
            }
        })

    }

    private fun navigate(id: Int) {
        val navController = findNavController()
        navController.navigate(R.id.action_listFragment_to_detailedFragment, bundleOf("id" to id))
    }
}
