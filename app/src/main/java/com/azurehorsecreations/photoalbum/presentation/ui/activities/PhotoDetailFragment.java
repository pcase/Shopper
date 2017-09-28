package com.azurehorsecreations.photoalbum.presentation.ui.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.azurehorsecreations.photoalbum.R;
import com.azurehorsecreations.photoalbum.domain.model.PhotoMetadata;
import com.azurehorsecreations.photoalbum.utils.ImageDownloader;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
 * ProductDetailFragment is a fragment for the product detail page
 */

public class PhotoDetailFragment extends Fragment {
    private static final String TAG = "PhotoDetailFrag";
    private PhotoMetadata photo;

    @Bind(R.id.title)
    TextView title;

    @Bind(R.id.description)
    TextView description;

    public static PhotoDetailFragment newInstance(PhotoMetadata photo) {
        PhotoDetailFragment fragmentFirst = new PhotoDetailFragment();
        Bundle args = new Bundle();
        args.putString("titlr", photo.getTitle());
        args.putString("description", photo.getDescription());
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photo = new PhotoMetadata();
        photo.setTitle(getArguments().getString("title", ""));
        photo.setDescription(getArguments().getString("description", ""));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView()");
        View view = inflater.inflate(R.layout.content_photo_detail, container, false);
        ButterKnife.bind(this, view);

        if (photo.getTitle() != null) {
            title.setText((Html.fromHtml(photo.getTitle())));
        }

        if (photo.getDescription() != null) {
            description.setText(Html.fromHtml(photo.getDescription()));
        }


//        loadImage(productImage, product.getProductImage());
        return view;
    }

    private void loadImage(final ImageView bmImage, String url) {
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Bitmap bitmap = (Bitmap) msg.obj;
                bmImage.setImageBitmap(bitmap);
            }
        };

        ImageDownloader imageDownloader = new ImageDownloader();
        imageDownloader.loadImage(url, handler);
    }
}
