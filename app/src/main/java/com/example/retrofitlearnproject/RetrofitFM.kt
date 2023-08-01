package com.example.retrofitlearnproject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFM {

    const val BASE_URL = "https://api.github.com/"

        fun getRetro() =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

}