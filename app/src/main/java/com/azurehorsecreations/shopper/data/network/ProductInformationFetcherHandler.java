package com.azurehorsecreations.shopper.data.network;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.utils.CallbackReceiver;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by pattycase on 8/28/17.
 */

public class ProductInformationFetcherHandler {
    private static final String TAG = "ProductInfFetHandler";
    private static final String API_KEY = "e0a4274f-45b6-405b-839e-1096222be4fc";
    private static final String BASE_URL = "https://walmartlabs-test.appspot.com/_ah/api/walmart/v1";
    private static final String WALMART_PRODUCTS = "walmartproducts";
    private static final String PAGE_SIZE = "30";
    private int mPageNumber;
    private ProgressBar progressBar;
    private Handler progressBarHandler = new Handler();
    private CallbackReceiver mCallbackReceiver;

    public ProductInformationFetcherHandler(CallbackReceiver callbackReceiver) {
        mPageNumber = 1;
        mCallbackReceiver = callbackReceiver;
    }

    public ProductInformationFetcherHandler(CallbackReceiver callbackReceiver, int pageNumber) {
        mPageNumber = pageNumber;
        mCallbackReceiver = callbackReceiver;
    }

    public void execute() {

        // Background thread: Get product information
        new Thread() {
            public void run() {
                final List<Product> productList = getProductInformation();
                Message message = new Message();
                message.obj = productList;
                messageHandler.sendMessage(message);
            }
        }.start();

    }

    public List<Product> getProductInformation() {
        HttpsURLConnection urlConnection = null;
        BufferedReader reader = null;
        String productJsonStr = null;

        try {
            URL url = new URL(BASE_URL + "/" + WALMART_PRODUCTS + "/" + API_KEY + "/" + mPageNumber + "/" + PAGE_SIZE);
            urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            int responseCode = urlConnection.getResponseCode();

            if (responseCode != HttpsURLConnection.HTTP_OK) {
                throw new IOException("HTTP error code: " + responseCode);
            }

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                return null;
            }
            productJsonStr = buffer.toString();
            List<Product> productList = parseResultData(productJsonStr);
            inputStream.close();

            for (Product product : productList) {
                try {
                    InputStream in = new java.net.URL(product.getProductImageUrl()).openStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(in);
                    product.setProductImageBitmap(bitmap);
                } catch (Exception e) {
                    Log.e(TAG + ":" + "Error", e.getMessage());
                    e.printStackTrace();
                }
            }

            return productList;
        } catch (IOException e) {
            Log.e(TAG, "Error ", e);
            return null;
        } finally{
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e(TAG, "Error closing stream", e);
                }
            }
        }
    }

    public Handler messageHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<Product> productList = (List<Product>) msg.obj;
            mCallbackReceiver.handleResultData(productList);
        }
    };

    private List<Product> parseResultData(String result) {
        List<Product> productList = new ArrayList<>();
        try {
            JSONObject jObject = new JSONObject(result);
            JSONArray jArray = jObject.getJSONArray("products");
            for (int i=0; i < jArray.length(); i++) {
                try {
                    Product product = new Product();
                    JSONObject item = jArray.getJSONObject(i);
                    if (item.has("productId")) {
                        product.setProductId(item.getString("productId"));
                    }
                    if (item.has("productName")) {
                        product.setProductName(item.getString("productName"));
                    }
                    if (item.has("shortDescription")) {
                        product.setShortDescription(item.getString("shortDescription"));
                    }
                    if (item.has("longDescription")) {
                        product.setLongDescription(item.getString("longDescription"));
                    }
                    if (item.has("price")) {
                        product.setPrice(item.getString("price"));
                    }
                    if (item.has("productImage")) {
                        product.setProductImageUrl(item.getString("productImage"));
                    }
                    if (item.has("reviewRating")) {
                        product.setReviewRating(item.getDouble("reviewRating"));
                    }
                    if (item.has("reviewCount")) {
                        product.setReviewCount(item.getInt("reviewCount"));
                    }
                    if (item.has("inStock")) {
                        product.setInStock(item.getBoolean("inStock"));
                    }
                    productList.add(product);
                } catch (JSONException e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return productList;
    }
}
