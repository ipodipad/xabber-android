package com.xabber.android.presentation.ui.photogallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.xabber.android.R;
import com.xabber.android.ui.activity.ChatActivity;

import java.util.List;

public class PhotoGalleryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<PhotoVO> items;
    private Context context;

    private static final int TYPE_PHOTO = 0;
    private static final int TYPE_BUTTON = 1;

    public PhotoGalleryAdapter(List<PhotoVO> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_BUTTON) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_button, parent, false);
            return new ButtonViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
            return new PhotoViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        switch (holder.getItemViewType()) {
            case TYPE_PHOTO:
                final PhotoViewHolder photoHolder = (PhotoViewHolder) holder;
                PhotoVO item = items.get(position);

                photoHolder.checkBox.setChecked(item.isChecked());
                photoHolder.checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setItemChecked(position, photoHolder.checkBox.isChecked());
                    }
                });

                //Glide.with(context).load(item.getUrl()).into(holder.ivThumbnail);
                break;

            case TYPE_BUTTON:
                final ButtonViewHolder buttonHolder = (ButtonViewHolder) holder;
                buttonHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((ChatActivity)context).openSystemFileGallery();
                    }
                });
                break;
        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof ButtonVO) return TYPE_BUTTON;
        else return TYPE_PHOTO;
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {

        ImageView ivThumbnail;
        CheckBox checkBox;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            ivThumbnail = (ImageView) itemView.findViewById(R.id.ivThumbnail);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
        }
    }

    class ButtonViewHolder extends RecyclerView.ViewHolder {
        public ButtonViewHolder(View itemView) {
            super(itemView);
        }
    }

    private void setItemChecked(int position, boolean checked) {
        if (position < items.size())
            items.get(position).setChecked(checked);
    }

}
