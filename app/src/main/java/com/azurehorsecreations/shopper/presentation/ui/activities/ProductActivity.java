package com.azurehorsecreations.shopper.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.azurehorsecreations.shopper.R;
import com.azurehorsecreations.shopper.data.repository.ProductRepository;
import com.azurehorsecreations.shopper.domain.executor.impl.ThreadExecutor;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.presentation.ui.EndlessRecyclerViewScrollListener;
import com.azurehorsecreations.shopper.presentation.ui.navigation.ProductNavigator;
import com.azurehorsecreations.shopper.presentation.presenters.ProductPresenter;
import com.azurehorsecreations.shopper.presentation.presenters.ProductPresenter.View;
import com.azurehorsecreations.shopper.presentation.presenters.impl.ProductPresenterImpl;
import com.azurehorsecreations.shopper.presentation.MainThreadImpl;
import com.azurehorsecreations.shopper.presentation.ui.adapters.ProductAdapter;
import com.azurehorsecreations.shopper.presentation.ui.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProductActivity extends AppCompatActivity implements View, ProductAdapter.OnItemClickListener {
    private static final String TAG = "ShopperProductActivity";
    private static final int NUMBER_OF_COLUMNS = 2;

    private EndlessRecyclerViewScrollListener mScrollListener;

    @Bind(R.id.message_view)
    TextView mMessageTextView;

    @Bind(R.id.recycler_view)
    protected RecyclerView mRecyclerView;

    @Bind(R.id.progressbar)
    protected ProgressBar mProgressBar;

    protected ProductPresenter mPresenter;
    protected ProductAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPresenter = new ProductPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this,
                new ProductRepository()
        );

        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, NUMBER_OF_COLUMNS);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        mScrollListener = new EndlessRecyclerViewScrollListener(gridLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                mPresenter.resume();
            }
        };
        mRecyclerView.addOnScrollListener(mScrollListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.resume();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(android.view.View.VISIBLE);
        Toast.makeText(this, R.string.retrieving, Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(android.view.View.INVISIBLE);
        Toast.makeText(this, R.string.retrieved, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String message) {
        mMessageTextView.setText(message);
    }

    @Override
    public void displayProductInformation(List<Product> productList) {
        if (mAdapter != null && mAdapter.getItemCount() > 0) {
            List<Product> currentList = new ArrayList<>();
            for (int i = 0; i < mAdapter.getItemCount(); i++) {
                currentList.add(mAdapter.getItem(i));
            }
            currentList.addAll(productList);
            mAdapter = new ProductAdapter(this, currentList, this);
            mAdapter.notifyDataSetChanged();
        } else {
            mAdapter = new ProductAdapter(this, productList, this);
            mAdapter.notifyDataSetChanged();
        }
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(Product product) {
        mPresenter.setNavigator(new ProductNavigator(this, ProductDetailPagerActivity.class, product));
        mPresenter.navigateToNewScreen();
    }
}
