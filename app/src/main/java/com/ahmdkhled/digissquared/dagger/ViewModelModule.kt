package com.ahmdkhled.digissquared.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahmdkhled.digissquared.viewModel.MainActivityVM
import com.ahmdkhled.digissquared.viewModel.MainActivityVMFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @MainActivityVMFactory.ViewModelKey(MainActivityVM::class)
    abstract fun bindScoreViewModel(mainActivityVM: MainActivityVM): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: MainActivityVMFactory): ViewModelProvider.Factory
}