package com.example.hw_product_recycleview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw_product_recycleview.adapter.ProductAdapter
import com.example.hw_product_recycleview.databinding.FragmentPhoneListBinding


class PhoneListFragment : Fragment() {

    private var _binding: FragmentPhoneListBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPhoneListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gridRecyclerView.adapter = ProductAdapter(this.context)
        binding.gridRecyclerView.setHasFixedSize(true)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}