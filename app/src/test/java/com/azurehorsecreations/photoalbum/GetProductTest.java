package com.azurehorsecreations.photoalbum;

import com.azurehorsecreations.photoalbum.data.repository.PhotoRepository;
import com.azurehorsecreations.photoalbum.domain.executor.IExecutor;
import com.azurehorsecreations.photoalbum.domain.executor.IMainThread;
import com.azurehorsecreations.photoalbum.domain.interactors.impl.PhotoMetadataInteractorImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
    @Mock private PhotoRepository mProductRepository;
    @Mock private PhotoMetadataInteractorImpl.Callback mMockedCallback;

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