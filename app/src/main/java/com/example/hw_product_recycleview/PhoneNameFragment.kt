package com.example.hw_product_recycleview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw_product_recycleview.databinding.FragmentPhoneNameBinding


class PhoneNameFragment : Fragment() {

    private var _binding: FragmentPhoneNameBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPhoneNameBinding.inflate(
            inflater, container, false
        )
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let{
           binding.phoneName.text=it.getString("name")
            binding.phonePrice.text=it.getString("price")

        }
    }


}