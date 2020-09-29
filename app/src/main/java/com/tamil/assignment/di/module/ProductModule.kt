package com.tamil.assignment.di.module

import androidx.lifecycle.ViewModel
import com.tamil.assignment.data.network.ApiHelper
import com.tamil.assignment.data.repo.gifs.GifRepository
import com.tamil.assignment.data.repo.gifs.GifRepositoryImpl
import com.tamil.assignment.di.utils.ViewModelKey
import com.tamil.assignment.features.products.ProductDetailFragment
import com.tamil.assignment.features.products.ProductsListFragment
import com.tamil.assignment.features.products.viewmodel.ProductsViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(includes = [ProductLayerModule::class])
object ProductModule {
    
    @Provides
    fun provideProductsRepository(apiHelper: ApiHelper): GifRepository {
        return GifRepositoryImpl(apiHelper)
    }
}

@Module
abstract class ProductLayerModule {

    @ContributesAndroidInjector
    abstract fun bindProductsListFragment(): ProductsListFragment


    @ContributesAndroidInjector
    abstract fun bindProductDetailFragment(): ProductDetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(ProductsViewModel::class)
    abstract fun bindProductsViewModel(viewModel: ProductsViewModel): ViewModel
}