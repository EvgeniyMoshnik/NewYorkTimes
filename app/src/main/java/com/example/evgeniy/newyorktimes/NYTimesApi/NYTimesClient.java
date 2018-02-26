package com.example.evgeniy.newyorktimes.NYTimesApi;


import com.example.evgeniy.newyorktimes.data.model.MediaList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

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
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .build();

            sNYTimesService = sRetrofit.create(NYTimesService.class);
        }

        return sNYTimesService;
    }

    static Gson getGson() {
        return new GsonBuilder().registerTypeAdapter(MediaList.class, new JsonDeserializer<MediaList>() {
            @Override
            public MediaList deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                if (json.isJsonArray()) {
                    Gson gson = new Gson();
                    return gson.fromJson(json, MediaList.class);
                }
                return null;
            }
        }).create();
    }
}
