package com.example.lab2_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var nextBtn = view.findViewById<Button>(R.id.nextBtn2)
        nextBtn.setOnClickListener {
            parentFragmentManager.commit {
                replace<ThirdFragment>(R.id.fragment_container_view)
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }
    }


}