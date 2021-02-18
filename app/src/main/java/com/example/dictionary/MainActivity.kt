package com.example.dictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        find_button.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val call = retrofit.create(ApiService::class.java).getDefinition("apple", Constants.KEY)
            call.enqueue(object:Callback<List<AppShortdef>> {
                override fun onFailure(call: Call<List<AppShortdef>>, t: Throwable) {
                    Log.d("LOGG", "error")
                }

                override fun onResponse(call: Call<List<AppShortdef>>, response: Response<List<AppShortdef>>) {
                    if (response.isSuccessful) {
                        Log.d("LOGG", "yaaay")
                        var resp = response.body()
                        var temp = resp.toString()
                        var t = temp
                    } else {
                        Log.d("LOGG", "huooo")
                    }
                }

            })
        }
    }
}