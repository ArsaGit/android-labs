package com.example.lab1.di

import com.example.lab1.data.repo.CardRepository
import com.example.lab1.data.repo.CardRepositoryImpl
import com.example.lab1.data.useCase.GetCardsUseCase
import com.example.lab1.data.useCase.GetCardsUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {
    @Binds
    abstract fun provideCardsRepository(cardRepositoryImpl: CardRepositoryImpl) : CardRepository
    @Binds
    abstract fun provideGetCardsUseCase(getCardsUseCaseImpl: GetCardsUseCaseImpl) : GetCardsUseCase
}