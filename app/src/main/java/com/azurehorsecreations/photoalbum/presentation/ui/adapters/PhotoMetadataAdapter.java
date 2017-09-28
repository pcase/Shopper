package com.azurehorsecreations.photoalbum.presentation.ui.adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.azurehorsecreations.photoalbum.R;
import com.azurehorsecreations.photoalbum.domain.model.PhotoMetadata;
import com.azurehorsecreations.photoalbum.utils.ImageDownloader;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
 * ProductAdapter handles product name and image information for the product page
 */

public class PhotoMetadataAdapter extends RecyclerView.Adapter<PhotoMetadataAdapter.ViewHolder> {
    private static final String TAG = "PhotoAdapter";
    private List<PhotoMetadata> mPhotoList;
    private Handler handler;
    private ImageDownloader imageDownloader;
    private Context mContext;
    private final OnItemClickListener listener;

    public PhotoMetadataAdapter(Context context, List<PhotoMetadata> photos, OnItemClickListener listener) {
        this.mContext = context;
        this.mPhotoList = photos;
        this.listener = listener;
    }

    public PhotoMetadata getItem(int id) {
        return mPhotoList.get(id);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_detail_row_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String title = mPhotoList.get(position).getTitle();
        holder.titleTextView.setText(title);
        String description = mPhotoList.get(position).getDescription();
        holder.descriptionTextView.setText(description);
        String filename = mPhotoList.get(position).getFilename();
        holder.filenameTextView.setText(filename);
    }

    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.title_text)
        protected TextView titleTextView;

        @Bind(R.id.description_text)
        protected TextView descriptionTextView;

        @Bind(R.id.filename_text)
        protected TextView filenameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void click(final PhotoMetadata photo, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(photo);
                }
            });
        }
    }

    public void setImage(final ViewHolder holder, String url) {
//        handler = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                Bitmap bitmap = (Bitmap) msg.obj;
//                holder.productImageView.setImageBitmap(bitmap);
//            }
//        };
//
//        imageDownloader = new ImageDownloader();
//        imageDownloader.loadImage(url, handler);
    }

    public interface OnItemClickListener {
        void onClick(PhotoMetadata item);
    }
}
