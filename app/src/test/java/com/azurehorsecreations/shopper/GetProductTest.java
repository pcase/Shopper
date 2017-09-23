package com.azurehorsecreations.shopper;

import com.azurehorsecreations.shopper.data.repository.ProductRepository;
import com.azurehorsecreations.shopper.domain.executor.IExecutor;
import com.azurehorsecreations.shopper.domain.executor.IMainThread;
import com.azurehorsecreations.shopper.domain.interactors.impl.ProductInteractorImpl;
import com.azurehorsecreations.shopper.domain.model.Product;
import com.azurehorsecreations.shopper.domain.repository.IProductRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
/**
 * Tests our product interactor.
 */
public class GetProductTest {

    private IMainThread mMainThread;
    @Mock
    private IExecutor mExecutor;
    @Mock private ProductRepository mProductRepository;
    @Mock private ProductInteractorImpl.Callback mMockedCallback;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mMainThread = new TestMainThread();
    }

    @Test
    public void testWelcomeMessageNotFound() throws Exception {
//        ProductInteractorImpl interactor = new ProductInteractorImpl(mExecutor, mMainThread, mMockedCallback, mProductRepository);
//        interactor.run();
//
//        mProductRepository.getProducts(mProductRepositoryCallback);
//
//        Mockito.verify(mProductRepository).getProducts(mProductRepositoryCallback);
//        Mockito.verifyNoMoreInteractions(mProductRepository);
//        Mockito.verify(mMockedCallback).onRetrievalFailed(anyString());
    }

    @Test
    public void testProductFound() throws Exception {

//        List<Product> products = new ArrayList<>();
//
//        mProductRepository.getProducts(mProductRepositoryCallback);
//
//        ProductInteractorImpl interactor = new ProductInteractorImpl(mExecutor, mMainThread, mMockedCallback, mProductRepository);
//        interactor.run();
//
//        Mockito.verify(mProductRepository).getProducts(mProductRepositoryCallback);
//        Mockito.verifyNoMoreInteractions(mProductRepository);
//        Mockito.verify(mMockedCallback).onProductRetrieved(products);
    }
}