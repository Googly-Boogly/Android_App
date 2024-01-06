package com.example.jarvis_app_v_real.ui.home

import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.jarvis_app_v_real.MainActivity
import com.example.jarvis_app_v_real.R
import com.example.jarvis_app_v_real.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        val button: Button = binding.homeBtn

        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        // Set OnClickListener for the button
        button.setOnClickListener {
            println("BTN CLICKED")
            (activity as? MainActivity)?.createNotification("TestTitle", "TestDesc")
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
