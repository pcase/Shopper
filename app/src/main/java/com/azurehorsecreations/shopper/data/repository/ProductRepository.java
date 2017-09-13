package com.azurehorsecreations.shopper.data.repository;

import android.util.Log;

import com.azurehorsecreations.shopper.data.network.ProductAPIService;
import com.azurehorsecreations.shopper.data.network.RestClient;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.ProductList;
import com.azurehorsecreations.shopper.domain.model.Question;
import com.azurehorsecreations.shopper.domain.model.QuestionList;
import com.azurehorsecreations.shopper.domain.repository.IProductRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pattycase on 9/9/17.
 */

public class ProductRepository implements IProductRepository {

    private ProductAPIService apiService;
    private List<Product> productList;
    private List<Question> questionList;

//    @Override
//    public List<Product> getProducts() {
//        Log.d("", "ProductRepository.getProducts()");
//        apiService = RestClient.getClient().create(ProductAPIService.class);
//        fetchProductList();
//        return productList;
//    }

    @Override
    public List<Question> getQuestions() {
        Log.d("", "ProductRepository.getQuestions()");
        apiService = RestClient.getClient().create(ProductAPIService.class);
        fetchQuetionList();
        return questionList;
    }

//    private void fetchProductList() {
//        Log.d("", "ProductRepository.fetchProductList()");
//        Call<ProductList> call = apiService.fetchProducts();
//        call.enqueue(new Callback<ProductList>() {
//            @Override
//            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
//                Log.d("", "Total number of products fetched : " + response.body().getProducts().size());
//                productList = response.body().getProducts();
//            }
//
//            @Override
//            public void onFailure(Call<ProductList> call, Throwable t) {
//                Log.e("", "Got error : " + t.getLocalizedMessage());
//            }
//        });
//    }

    private void fetchQuetionList() {
        Call<QuestionList> call = apiService.fetchQuestions();
        call.enqueue(new Callback<QuestionList>() {
            @Override
            public void onResponse(Call<QuestionList> call, Response<QuestionList> response) {
                Log.d("", "Total number of questions fetched : " + response.body().getQuestions().size());
                questionList = response.body().getQuestions();
            }

            @Override
            public void onFailure(Call<QuestionList> call, Throwable t) {
                Log.e("", "Got error : " + t.getLocalizedMessage());
            }
        });
    }

}
