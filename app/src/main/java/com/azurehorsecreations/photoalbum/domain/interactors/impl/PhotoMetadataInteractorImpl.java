package com.azurehorsecreations.photoalbum.domain.interactors.impl;

import com.azurehorsecreations.photoalbum.data.repository.PhotoRepository;
import com.azurehorsecreations.photoalbum.domain.executor.IExecutor;
import com.azurehorsecreations.photoalbum.domain.executor.IMainThread;
import com.azurehorsecreations.photoalbum.domain.interactors.IPhotoMetadataInteractor;
import com.azurehorsecreations.photoalbum.domain.interactors.base.AbstractInteractor;
import com.azurehorsecreations.photoalbum.domain.model.PhotoMetadata;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * This is an interactor boilerplate with a reference to a model repository.
 * <p/>
 */
public class PhotoMetadataInteractorImpl extends AbstractInteractor implements IPhotoMetadataInteractor {

    private Callback mCallback;
    private PhotoRepository mProductRepository;

    public PhotoMetadataInteractorImpl(IExecutor threadExecutor,
                                       IMainThread mainThread,
                                       Callback callback, PhotoRepository productRepository) {
        super(threadExecutor, mainThread);
        mCallback = callback;
        mProductRepository = productRepository;
    }

    private void notifyError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onRetrievalFailed("No results :(");
            }
        });
    }

    private void postMessage(final List<PhotoMetadata> photos) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onPhotoDetailRetrieved(photos);
            }
        });
    }

    @Override
    public void run() {
        mProductRepository.getPhotoMetadata()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<PhotoMetadata>>() {

                    @Override
                    public void onError(Throwable e) {
                        notifyError();
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<PhotoMetadata> photos) {
                        postMessage(photos);
                    }
                });
    }
}
