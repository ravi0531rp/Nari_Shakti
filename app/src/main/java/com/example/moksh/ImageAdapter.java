package com.example.moksh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moksh.loginandregister.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by moksh on 21/3/18.
 */


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Upload> mUploads;
    public ImageAdapter(Context context, List<Upload> uploads) {
        mContext = context;
        mUploads = uploads;
    }
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_layout,parent,false);
        return new ImageViewHolder( v);
    }
    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Upload currentUpload = mUploads.get(position);
        holder.textViewName.setText(currentUpload.getmName());
        Picasso.with(mContext)
                .load(currentUpload.getmImageUrl())
                .fit()
                .centerCrop()
                .into(holder.imageView);
    }
    @Override
    public int getItemCount() {
        return mUploads.size();
    }
    public  class ImageViewHolder extends  RecyclerView.ViewHolder{
        public TextView textViewName;
        public ImageView imageView;
        public ImageViewHolder(View itemView) {
            super(itemView);
            textViewName =itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);
        }
    }
}
