package com.example.wiri.ui.Home_screem

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.wiri.R
import com.example.wiri.Login
import com.example.wiri.databinding.FragmentHomeScreenBinding

class Home_screen : Fragment() {
    private var binding: FragmentHomeScreenBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeScreenBinding.inflate(
            inflater,
            container,
            false
        )
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setval()
    }

    fun setval() {
        val t = view!!.findViewById<TextView>(R.id.namedisp)
        t.text = Login.s
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}