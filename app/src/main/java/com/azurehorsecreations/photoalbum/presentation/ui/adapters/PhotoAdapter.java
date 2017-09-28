package com.azurehorsecreations.photoalbum.presentation.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.azurehorsecreations.photoalbum.contants.PhotoConstants;
import com.azurehorsecreations.photoalbum.domain.model.PhotoMetadata;
import com.azurehorsecreations.photoalbum.domain.model.Photo;
import com.azurehorsecreations.photoalbum.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by pattycase on 9/27/17.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
        private ArrayList<PhotoMetadata> photoImages;
        private Context context;

        public PhotoAdapter(Context context, ArrayList<PhotoMetadata> photoImages) {
            this.context = context;
            this.photoImages = photoImages;
        }

        @Override
        public PhotoAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photo_row_layout, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.photo_title.setText(photoImages.get(i).getTitle());
            Picasso.with(context).load(PhotoConstants.PHOTO_DOWNLOAD_URL + photoImages.get(i).getFilename()).resize(120, 60).into(viewHolder.photo_image);
        }

        @Override
        public int getItemCount() {
            return photoImages.size();
        }

        public PhotoMetadata getItem(int id) {
        return photoImages.get(id);
    }

        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView photo_image;
            TextView photo_title;
            public ViewHolder(View view) {
                super(view);
                photo_title = (TextView)view.findViewById(R.id.title_text);
                photo_image = (ImageView)view.findViewById(R.id.image_view);
            }
        }

    public interface OnItemClickListener {
        void onClick(PhotoMetadata item);
    }
}
