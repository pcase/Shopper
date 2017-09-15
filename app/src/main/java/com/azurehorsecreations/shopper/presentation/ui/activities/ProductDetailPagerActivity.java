package com.azurehorsecreations.shopper.presentation.ui.activities;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.azurehorsecreations.shopper.R;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.presentation.ui.ProductDetailPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
 * ProductDetailPagerActivity displays the product details in a swipeable viewer
 */

public class  ProductDetailPagerActivity extends AppCompatActivity {
    private static final String PRODUCT = "PRODUCT";
    private Product product;
    private Product[] productArray;
    FragmentPagerAdapter adapterViewPager;
    List<Fragment> fragments;
    @Bind(R.id.vpPager)
    ViewPager vpPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);
        ButterKnife.bind(this);
        Parcelable parcelableProduct = getIntent().getParcelableExtra("PRODUCT");
        productArray = new Product[1];
        productArray[0] = (Product)parcelableProduct;
        fragments = new ArrayList<>();
        fragments.add(ProductDetailFragment.newInstance(productArray[0]));
        adapterViewPager = new ProductDetailPagerAdapter(getSupportFragmentManager(), fragments);
        vpPager.setAdapter(adapterViewPager);

//        Parcelable[] parcelableProductArray = getIntent().getParcelableArrayExtra(PRODUCT);
//        productArray = new Product[parcelableProductArray.length];
//        for (int i=0; i<parcelableProductArray.length; ++i) {
//            productArray[i] = (Product) parcelableProductArray[i];
//        }
//        fragments = new ArrayList<>();
//        for (int i=0; i<productArray.length; ++i) {
//            fragments.add(ProductDetailFragment.newInstance(productArray[i]));
//        }
//        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
//        adapterViewPager = new ProductDetailPagerAdapter(getSupportFragmentManager(), fragments);
//        vpPager.setAdapter(adapterViewPager);
    }
}
