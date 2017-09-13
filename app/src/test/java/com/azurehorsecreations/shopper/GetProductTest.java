package com.azurehorsecreations.shopper;

import com.azurehorsecreations.shopper.data.repository.ProductRepository;
import com.azurehorsecreations.shopper.domain.executor.Executor;
import com.azurehorsecreations.shopper.domain.executor.MainThread;
import com.azurehorsecreations.shopper.domain.interactors.impl.ProductInteractorImpl;
import com.azurehorsecreations.shopper.domain.model.Product;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
/**
 * Tests our product interactor.
 */
public class GetProductTest {

    private       MainThread                   mMainThread;
    @Mock
    private Executor                     mExecutor;
    @Mock private ProductRepository mProductRepository;
    @Mock private ProductInteractorImpl.Callback mMockedCallback;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mMainThread = new TestMainThread();
    }

    @Test
    public void testWelcomeMessageNotFound() throws Exception {
        ProductInteractorImpl interactor = new ProductInteractorImpl(mExecutor, mMainThread, mMockedCallback, mProductRepository);
        interactor.run();

        Mockito.when(mProductRepository.getProducts())
                .thenReturn(null);

        Mockito.verify(mProductRepository).getProducts();
        Mockito.verifyNoMoreInteractions(mProductRepository);
        Mockito.verify(mMockedCallback).onRetrievalFailed(anyString());
    }

    @Test
    public void testProductFound() throws Exception {

        List<Product> products = new ArrayList<>();

        when(mProductRepository.getProducts())
                .thenReturn(products);

        ProductInteractorImpl interactor = new ProductInteractorImpl(mExecutor, mMainThread, mMockedCallback, mProductRepository);
        interactor.run();

        Mockito.verify(mProductRepository).getProducts();
        Mockito.verifyNoMoreInteractions(mProductRepository);
        Mockito.verify(mMockedCallback).onProductRetrieved(products);
    }
}