package com.example.lab1.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab1.ui.CardsViewModel
import dagger.Module
import dagger.Provides

@Module
object ViewModelModule {
    @Provides
    @JvmStatic
    fun provideViewModelFactory(viewModel: CardsViewModel): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(CardsViewModel::class.java)) {
                    return viewModel as T
                }
                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        }
    }
}