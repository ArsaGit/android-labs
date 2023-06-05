package com.example.lab1.component

import com.example.lab1.CardFragment
import com.example.lab1.viewModel.CardsViewModel
import com.example.lab1.viewModel.ViewModelModule
import com.example.lab1.api.CardRepository
import com.example.lab1.api.NetworkModule
import dagger.Component

@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(cardRepository: CardRepository)
    fun inject(viewModel: CardsViewModel)
    fun inject(fragment: CardFragment)
}