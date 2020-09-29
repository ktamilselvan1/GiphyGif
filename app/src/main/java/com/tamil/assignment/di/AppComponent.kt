package com.tamil.assignment.di

import android.app.Application
import com.tamil.assignment.AssignmentApplication
import com.tamil.assignment.di.module.ApiModule
import com.tamil.assignment.di.module.AppModule
import com.tamil.assignment.di.module.ProductModule
import com.tamil.assignment.di.module.ViewModelInjectionModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        ViewModelInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ProductModule::class]
)
interface AppComponent : AndroidInjector<AssignmentApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}