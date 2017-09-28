package com.azurehorsecreations.photoalbum.data.network;

import android.util.Log;

import com.azurehorsecreations.photoalbum.contants.PhotoConstants;
import com.azurehorsecreations.photoalbum.domain.model.PhotoMetadata;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by pattycase on 9/18/17.
 */

public class RestClientSingleton {
    private static RestClientSingleton instance;
    private IPhotoAPIService apiService;

    private RestClientSingleton() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PhotoConstants.PHOTO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(IPhotoAPIService.class);
    }

    public static RestClientSingleton getInstance() {
        if (instance == null) {
            instance = new RestClientSingleton();
        }
        return instance;
    }

    public Observable<List<PhotoMetadata>> getPhotoMetadata() {
        return apiService.fetchPhotoMetadata();
    }
}
