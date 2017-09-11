package com.azurehorsecreations.shopper.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pattycase on 9/9/17.
 */

public class RestClient {
    private static final String API_KEY = "e0a4274f-45b6-405b-839e-1096222be4fc";
    private static final String BASE_URL = "https://walmartlabs-test.appspot.com/_ah/api/walmart/v1";
    private static final String WALMART_PRODUCTS = "walmartproducts";
    private static final String PAGE_SIZE = "30";
    private static Retrofit retrofit = null;
    private static int mPageNumber = 1;

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://walmartlabs-test.appspot.com/_ah/api/walmart/v1")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
