package com.example.lab1.di

import com.example.lab1.ui.CardFragment
import com.example.lab1.ui.CardsViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class, DataModule::class])
interface ApplicationComponent {
    fun inject(viewModel: CardsViewModel)
    fun inject(fragment: CardFragment)
}