package com.pertamina.spbucare.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pertamina.spbucare.R
import com.pertamina.spbucare.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false).apply {
            cancleCard.setOnClickListener {
                val action = DashboardFragmentDirections.actionShowCancle()
                findNavController().navigate(action)
            }

            depositCard.setOnClickListener {
                val action = DashboardFragmentDirections.actionShowDeposit()
                findNavController().navigate(action)
            }

            additionCard.setOnClickListener {
                val action = DashboardFragmentDirections.actionShowAddition()
                findNavController().navigate(action)
            }
        }
        return binding.root
    }


}
