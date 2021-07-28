package com.tomjung.mycustomers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG = "MyCustomers"
    }

    lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTextView = findViewById(R.id.rest_result_text_view)

        findViewById<Button>(R.id.get_customer_btn).setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.219.102:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val restApi = retrofit.create(RestApi::class.java)
            restApi.requestCustomerDetail("1").enqueue(object : Callback<Customer> {
                override fun onResponse(call: Call<Customer>, response: Response<Customer>) {
                    val res = response.body() as Customer
                    val result = res.id.toString() + res.name
                    resultTextView.text = result
                }

                override fun onFailure(call: Call<Customer>, t: Throwable) {
                    Log.e(TAG, "$t")
                }

            })
        }
    }
}