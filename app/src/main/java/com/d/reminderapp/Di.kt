package com.d.reminderapp

import com.d.reminderapp.network.ApiCall
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import org.koin.androidx.viewmodel.dsl.viewModel
import retrofit2.converter.moshi.MoshiConverterFactory



val apiModule = module {
    single{

         Moshi.Builder()
             .add(NullToEmptyStringAdapter)
            .add(KotlinJsonAdapterFactory())
            .build()
    }
    single {

        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl("https://38rhabtq01.execute-api.ap-south-1.amazonaws.com")
            .client(OkHttpClient())
            .build()
    }
    single { get<Retrofit>().create(ApiCall::class.java) }

}

val viewDI = module {
    viewModel {
        MainActivityViewModel(api = get())
    }

}
object NullToEmptyStringAdapter{
    @FromJson
    fun fromJson(reader: JsonReader): String{
        if(reader.peek()!= JsonReader.Token.NULL){
            return reader.nextString()
        }
        reader.nextNull<Unit>()
        return ""

    }
}


