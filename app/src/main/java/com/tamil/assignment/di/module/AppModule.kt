package com.tamil.assignment.di.module

import com.tamil.assignment.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [AppLayerModule::class])
object AppModule {

}

@Module
abstract class AppLayerModule {

    @ContributesAndroidInjector()
    abstract fun bindMainActivity(): MainActivity
}