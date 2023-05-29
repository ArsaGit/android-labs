package com.example.lab1

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab1.databinding.FragmentItemListBinding
import com.example.lab1.model.SealedCard
import com.google.android.material.appbar.MaterialToolbar

class ItemListFragment : Fragment() {
    private lateinit var binding: FragmentItemListBinding
    private lateinit var itemAdapter: ItemListAdapter
    private lateinit var navController: NavController
    private lateinit var cardsViewModel: CardsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        //инициализирую binding
        binding = FragmentItemListBinding.inflate(inflater, container, false)

        cardsViewModel = ViewModelProvider(this)[CardsViewModel::class.java]

        //создаю adapter
        itemAdapter = ItemListAdapter()
        //привязываю
        binding.recycleViewer.apply {
            //тип layouta
            layoutManager = LinearLayoutManager(this@ItemListFragment.activity)
            adapter = itemAdapter   //присваиваю adapter
        }
        //добавляю декаротор, т.к. карточки слиплись
        binding.recycleViewer.addItemDecoration(
            ItemDecorator(resources.getDimensionPixelSize(R.dimen.item_space))
        )

        //достаю и изменяю toolbar
        val topBar = activity?.findViewById<MaterialToolbar>(R.id.top_app_bar)
        topBar?.title = "Product"
        topBar?.isTitleCentered = true
        topBar?.setNavigationIcon(R.drawable.baseline_menu_24)

//        создаю лист и сабмитю
//        var items = listOf(
//            SealedCard.CardInfo("https://develtop.ru/study/1.jpg", "Mytitle", "sub",
//            null, null)
//        )
//        itemAdapter.submitList(items)

        registerObservers()

        cardsViewModel.getCards()

        //sealed class
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        //изменяю меню
        menu.getItem(R.id.account).isVisible = true
        menu.getItem(R.id.more).isVisible = false
    }

    private fun registerObservers() {
        cardsViewModel.cardLiveDataSuccess.observe(viewLifecycleOwner, Observer {
            cardList -> cardList?.let {
                itemAdapter.submitList(cardList)
        }
        })
    }
}