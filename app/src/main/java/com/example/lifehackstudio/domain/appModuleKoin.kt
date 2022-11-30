package com.example.lifehackstudio.domain

import com.example.lifehackstudio.data.web.CompanyAPI
import com.example.lifehackstudio.data.web.RetrofitRequestImpl
import com.example.lifehackstudio.domain.model.RepositoryCompany
import com.example.lifehackstudio.ui.detail.DetailViewModel
import com.example.lifehackstudio.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val appModuleKoin = module {

    val apiUrl = "https://lifehack.studio/test_task/"
    single<RepositoryCompany> { RetrofitRequestImpl(get()) }
    single<CompanyAPI> { get<Retrofit>().create(CompanyAPI::class.java) }

    single {
        Retrofit.Builder()
            .baseUrl(apiUrl)
            .addCallAdapterFactory(get())
            .addConverterFactory(get())
            .build()
    }

    factory<Converter.Factory> { GsonConverterFactory.create() }
    factory<CallAdapter.Factory> { RxJava3CallAdapterFactory.create() }

    viewModel { MainViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}