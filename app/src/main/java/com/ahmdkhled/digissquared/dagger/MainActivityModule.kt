package com.ahmdkhled.digissquared.dagger

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ahmdkhled.digissquared.model.Res
import com.ahmdkhled.digissquared.model.SignalResponse
import com.ahmdkhled.digissquared.viewModel.MainActivityVM
import com.ahmdkhled.digissquared.viewModel.MainActivityVMFactory
import com.ahmdkhled.digissquared.viewModel.MainActivityVMFactory.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
 class MainActivityModule {

    @Provides
     fun provideSignalLiveData(): MutableLiveData<Res<SignalResponse>> {
        return MutableLiveData()
    }


}