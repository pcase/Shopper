package com.azurehorsecreations.shopper.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.azurehorsecreations.shopper.R;
import com.azurehorsecreations.shopper.data.repository.ProductRepository;
import com.azurehorsecreations.shopper.domain.executor.impl.ThreadExecutor;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.model.Question;
import com.azurehorsecreations.shopper.presentation.presenters.MainPresenter;
import com.azurehorsecreations.shopper.presentation.presenters.MainPresenter.View;
import com.azurehorsecreations.shopper.presentation.presenters.impl.MainPresenterImpl;
import com.azurehorsecreations.shopper.presentation.MainThreadImpl;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View {

    @Bind(R.id.welcome_textview)
    TextView mWelcomeTextView;

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // create a presenter for this view
        mPresenter = new MainPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this,
                new ProductRepository()
        );
    }

    @Override
    protected void onResume() {
        super.onResume();

        // let's start welcome message retrieval when the app resumes
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
    public void displayWelcomeMessage(String msg) {
        mWelcomeTextView.setText(msg);
    }

    @Override
    public void displayProductInformation(List<Product> product) {
        mWelcomeTextView.setText(product.get(0).getProductName());
    }

    @Override
    public void displayQuestionInformation(List<Question> question) {
        mWelcomeTextView.setText(question.get(0).getTitle() + "\n " + question.get(0).getLink());
    }
}
