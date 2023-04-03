package com.example.lab1

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab1.databinding.FragmentItemListBinding
import com.google.android.material.appbar.MaterialToolbar

class ItemListFragment : Fragment() {
    private lateinit var binding: FragmentItemListBinding
    private lateinit var itemAdapter: ItemListAdapter
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        binding = FragmentItemListBinding.inflate(inflater, container, false)


        itemAdapter = ItemListAdapter()
        binding.recycleViewer.apply {
            layoutManager = LinearLayoutManager(this@ItemListFragment.activity)
            adapter = itemAdapter
        }

        binding.recycleViewer.addItemDecoration(
            ItemDecorator(resources.getDimensionPixelSize(R.dimen.item_space))
        )

        val topBar = activity?.findViewById<MaterialToolbar>(R.id.top_app_bar)

        topBar?.title = "Product"
        topBar?.isTitleCentered = true
        topBar?.setNavigationIcon(R.drawable.baseline_menu_24)


        var items = listOf(Item(13),Item(2), Item(3), Item(4), Item(5), Item(6))
        itemAdapter.submitList(items)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {


        menu.getItem(R.id.account).isVisible = true
        menu.getItem(R.id.more).isVisible = false
    }
}