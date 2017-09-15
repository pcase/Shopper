package com.azurehorsecreations.shopper.presentation.ui.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.azurehorsecreations.shopper.R;

import com.azurehorsecreations.shopper.domain.model.Product;

import java.io.InputStream;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
 * ProductDetailFragment is a fragment for the product detail page
 */

public class ProductDetailFragment extends Fragment {
    private static final String TAG = "ProductDetFrag";
    private Product product;
    @Bind(R.id.product_Id)
    TextView productId;

    @Bind(R.id.product_name)
    TextView productName;

    @Bind(R.id.short_description)
    TextView shortDescription;

    @Bind(R.id.long_description)
    TextView longDescription;

    @Bind(R.id.price)
    TextView price;

    @Bind(R.id.review_rating)
    TextView reviewRating;

    @Bind(R.id.review_count)
    TextView reviewCount;

    @Bind(R.id.in_stock)
    TextView inStock;

    @Bind(R.id.product_image)
    ImageView productImage;

    @Bind(R.id.progressbar)
    ProgressBar progressBar;

    public static ProductDetailFragment newInstance(Product product) {
        ProductDetailFragment fragmentFirst = new ProductDetailFragment();
        Bundle args = new Bundle();
        args.putString("productId", product.getProductId());
        args.putString("productName", product.getProductName());
        args.putString("shortDescription", product.getShortDescription());
        args.putString("longDescription", product.getLongDescription());
        args.putString("price", product.getPrice());
        args.putString("productImage", product.getProductImage());
        args.putDouble("reviewRating", product.getReviewRating());
        args.putInt("reviewCount", product.getReviewCount());
        args.putInt("inStock", product.isInStock() ? 1 : 0);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        product = new Product();
        product.setProductId(getArguments().getString("productId", ""));
        product.setProductName(getArguments().getString("productName", ""));
        product.setShortDescription(getArguments().getString("shortDescription", ""));
        product.setLongDescription(getArguments().getString("longDescription", ""));
        product.setPrice(getArguments().getString("price", ""));
        product.setProductImage(getArguments().getString("productImage", ""));
        product.setReviewRating(getArguments().getDouble("reviewRating", 0));
        product.setReviewCount(getArguments().getInt("reviewCount", 0));
        product.setInStock(getArguments().getInt("inStock", 0) == 1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView()");
        View view = inflater.inflate(R.layout.content_product_detail, container, false);
        ButterKnife.bind(this, view);

        if (product.getProductId() != null) {
            productId.setText((Html.fromHtml(product.getProductId())));
        }

        if (product.getProductName() != null) {
            productName.setText((Html.fromHtml(product.getProductName())));
        }

        if (product.getShortDescription() != null) {
            shortDescription.setText(Html.fromHtml(product.getShortDescription()));
        }

        if (product.getLongDescription() != null) {
            longDescription.setText(Html.fromHtml(product.getLongDescription()));
        }

        if (product.getPrice() != null) {
            price.setText(product.getPrice());
        }

        reviewRating.setText(String.valueOf(product.getReviewRating()));
        reviewCount.setText(String.valueOf(product.getReviewCount()));
        if (product.isInStock()) {
            inStock.setText(R.string.yes);
        } else {
            inStock.setText(R.string.no);
        }
//
//        new DownloadImageTask(productImage).execute(product.getProductImage());
        return view;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap bitmap = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                bitmap = BitmapFactory.decodeStream(in);
                in.close();
            } catch (Exception e) {
                Log.e(TAG + ": Error", e.getMessage());
                e.printStackTrace();
            };
            return bitmap;
        }

        protected void onPostExecute(Bitmap result) {
            progressBar.setVisibility(View.INVISIBLE);
            bmImage.setImageBitmap(result);
        }
    }
}
