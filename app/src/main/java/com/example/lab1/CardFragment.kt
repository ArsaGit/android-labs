package com.example.lab1

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab1.databinding.FragmentItemListBinding
import com.google.android.material.appbar.MaterialToolbar

class CardFragment : Fragment() {
    private lateinit var binding: FragmentItemListBinding
    private lateinit var itemAdapter: CardListAdapter
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
        itemAdapter = CardListAdapter()
        //привязываю
        binding.recycleViewer.apply {
            //тип layouta
            layoutManager = LinearLayoutManager(this@CardFragment.activity)
            adapter = itemAdapter   //присваиваю adapter
        }
        //добавляю декаротор, т.к. карточки слиплись
        binding.recycleViewer.addItemDecoration(
            CardListDecorator(resources.getDimensionPixelSize(R.dimen.item_space))
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

        //регистрирую наблюдателей
        registerObservers()

        //получаю данные
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