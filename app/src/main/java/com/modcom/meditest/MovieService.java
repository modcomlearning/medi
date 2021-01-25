package com.modcom.meditest;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieService {
    @GET("Oclemy/SampleJSON/338d9585/spacecrafts.json")
    Call<List<Movie>> getMovies();
}