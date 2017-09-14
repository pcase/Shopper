package com.azurehorsecreations.shopper.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.azurehorsecreations.shopper.R;
import com.azurehorsecreations.shopper.data.repository.ProductRepository;
import com.azurehorsecreations.shopper.domain.executor.impl.ThreadExecutor;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.presentation.presenters.MainPresenter;
import com.azurehorsecreations.shopper.presentation.presenters.MainPresenter.View;
import com.azurehorsecreations.shopper.presentation.presenters.impl.MainPresenterImpl;
import com.azurehorsecreations.shopper.presentation.MainThreadImpl;
import com.azurehorsecreations.shopper.presentation.ui.ProductAdapter;
import com.azurehorsecreations.shopper.presentation.ui.SimpleDividerItemDecoration;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShopperProductActivity extends AppCompatActivity implements View, android.view.View.OnClickListener {
    private static final int NUMBER_OF_COLUMNS = 2;
    @Bind(R.id.welcome_textview)
    TextView mWelcomeTextView;
    @Bind(R.id.recycler_view)
    protected RecyclerView recyclerView;
    protected MainPresenter mPresenter;
    protected ProductAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPresenter = new MainPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this,
                new ProductRepository()
        );

        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, NUMBER_OF_COLUMNS);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.resume();
    }

    @Override
    public void showProgress() {
        mWelcomeTextView.setText("Retrieving...");
    }

    @Override
    public void hideProgress() {
        Toast.makeText(this, "Retrieved!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String message) {
        mWelcomeTextView.setText(message);
    }

    @Override
    public void displayProductInformation(List<Product> productList) {
        mWelcomeTextView.setText(productList.get(0).getProductName());
        mAdapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(android.view.View view) {

    }
}