package com.tamil.assignment.di.module

import androidx.lifecycle.ViewModelProvider
import com.tamil.assignment.di.utils.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelInjectionModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}