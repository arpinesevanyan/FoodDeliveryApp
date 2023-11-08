package com.arpinesevanyan.fooddeliveryapp.view.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arpinesevanyan.fooddeliveryapp.R
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController

class AccountFragment : Fragment() {

    private lateinit var nameEditText: AppCompatEditText
    private lateinit var surNameEditText: AppCompatEditText
    private lateinit var numberEditText: AppCompatEditText
    private lateinit var emailEditText: AppCompatEditText
    private lateinit var addressEditText: AppCompatEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_account, container, false)

        nameEditText = rootView.findViewById(R.id.nameEditText)
        surNameEditText = rootView.findViewById(R.id.surNameEditText)
        numberEditText = rootView.findViewById(R.id.numberEditText)
        emailEditText = rootView.findViewById(R.id.emailEditText)
        addressEditText = rootView.findViewById(R.id.addressEditText)

        val toolbar = rootView.findViewById<Toolbar>(R.id.toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)

        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        val registerButton = rootView.findViewById<AppCompatButton>(R.id.registerButton)
        registerButton.setOnClickListener {
            findNavController().navigate(R.id.menuFragment)
        }

        return rootView
    }
}
