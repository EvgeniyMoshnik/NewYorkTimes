package com.example.evgeniy.newyorktimes.NYTimesApi;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NYTimesClient {

    public static final String API_BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/";

    private static Retrofit sRetrofit;
    private static NYTimesService sNYTimesService;

    public static NYTimesService getClient() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            sNYTimesService = sRetrofit.create(NYTimesService.class);
        }

        return sNYTimesService;
    }
}
