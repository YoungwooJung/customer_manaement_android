package com.tomjung.mycustomers

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestApi {
    @GET("customer/{id}")
    fun requestCustomerDetail(@Path("id") id: String): Call<Customer>

    @GET("customers")
    fun searchCustomers(@Query("nameFilter") nameFilter: String): Call<List<Customer>>
}