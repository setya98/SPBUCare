package com.pertamina.spbucare


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pertamina.spbucare.databinding.FragmentComplaintBinding


class ComplaintFragment : Fragment() {
    private lateinit var binding: FragmentComplaintBinding
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComplaintBinding.inflate(inflater, container, false).apply {

        }
        return binding.root
    }
}