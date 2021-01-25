package com.modcom.meditest

import retrofit2.Call
import retrofit2.http.GET
interface ApiInterface {
    @GET("user/services")
    fun getPhotos(): Call < List < recyclerresponse >>
}