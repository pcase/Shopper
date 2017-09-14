package com.azurehorsecreations.shopper.presentation.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.azurehorsecreations.shopper.R;
import com.azurehorsecreations.shopper.domain.model.Product;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

/*
 * ProductAdapter handles product name and image information for the product page
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private static final String TAG = "ProductAdapter";
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private List<Product> mProductList;
    private Handler handler;
    private ImageDownloader imageDownloader;

    public ProductAdapter(Context context, List<Product> products) {
        this.mInflater = LayoutInflater.from(context);
        this.mProductList = products;
    }

    public Product getItem(int id) {
        return mProductList.get(id);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_row_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String name = mProductList.get(position).getProductName();
        holder.productTextView.setText(name);
        String imageUrl = mProductList.get(position).getProductImage();
        setImage(holder, imageUrl);
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.product_text)
        protected TextView productTextView;

        @Bind(R.id.product_image)
        protected ImageView productImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setImage(final ViewHolder holder, String url) {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Bitmap bitmap = (Bitmap) msg.obj;
                holder.productImageView.setImageBitmap(bitmap);
            }
        };

        imageDownloader = new ImageDownloader();
        imageDownloader.loadImage(url, handler);
    }
}
