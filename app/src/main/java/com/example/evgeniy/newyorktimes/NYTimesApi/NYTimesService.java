package com.example.evgeniy.newyorktimes.NYTimesApi;


import com.example.evgeniy.newyorktimes.data.model.ArticleList;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NYTimesService {

   @GET("{type}/{section}/{time-period}.json")
   Call<ArticleList> getArticles(@Path("type") String type, @Path("section") String section,
                                       @Path("time-period") int timePeriod, @Query("api-key") String apiKey);
}
