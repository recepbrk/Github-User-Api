package com.example.retrofitlearnproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
/*
Retrofit Kulanımı için Gereken Adımlar
1- Dependency -> Retrofit Ve Gson implementetion
2- Model -> Data class   Json to Data class
3- İnterface
4- Layout İşlemleri
5- Adapter
6 -Retrofit Code

 */



class MainActivity : AppCompatActivity() {

    lateinit var rvMain:RecyclerView
    lateinit var myAdapter: MyAdapter
    var BASE_URL = "https://api.github.com"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain= findViewById<RecyclerView>(R.id.recycler_view)

        rvMain.layoutManager=LinearLayoutManager(this)


        getAllData()



    }

    private fun getAllData() {

        var userApi = RetrofitFM.getRetro()
            .create(ApiInterface::class.java)




        userApi.getData().enqueue(object :Callback<List<UsersItem>> {
            override fun onResponse(
                call: Call<List<UsersItem>>,
                response: Response<List<UsersItem>>
            ) {
                val data = response.body()!!
                myAdapter =MyAdapter(baseContext,data)
                rvMain.adapter=myAdapter
                Log.d("data", data.toString())
            }

            override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"HATA VAR VERİLER GELMEDİ",Toast.LENGTH_SHORT).show()
            }

        })
    }
}