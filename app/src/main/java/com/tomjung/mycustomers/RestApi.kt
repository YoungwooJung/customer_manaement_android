package com.tomjung.mycustomers

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RestApi {
    @GET("customer/{id}")
    fun requestCustomerDetail(@Path("id") id: String): Call<Customer>
}