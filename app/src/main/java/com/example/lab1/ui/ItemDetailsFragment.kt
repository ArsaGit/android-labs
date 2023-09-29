package com.example.lab1.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.lab1.R
import com.example.lab1.databinding.FragmentItemDetailsBinding
import com.google.android.material.appbar.MaterialToolbar

class ItemDetailsFragment : Fragment() {
    private lateinit var binding: FragmentItemDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentItemDetailsBinding.inflate(inflater, container, false)

        binding.buttonWithId.text = "Кнопка с id: " + arguments?.getInt("itemId").toString()

        val topBar = activity?.findViewById<MaterialToolbar>(R.id.top_app_bar)

        topBar?.title = "Title"
        topBar?.isTitleCentered = false
        topBar?.setNavigationIcon(R.drawable.baseline_arrow_back_24)

        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            binding.itemSwitch.isChecked = true

        binding.itemSwitch.setOnClickListener(View.OnClickListener {
            if(binding.itemSwitch.isChecked)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        menu.getItem(R.id.account).isVisible = false
        menu.getItem(R.id.more).isVisible = true
    }


}