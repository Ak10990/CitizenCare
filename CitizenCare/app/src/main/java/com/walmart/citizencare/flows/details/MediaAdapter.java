package com.walmart.citizencare.flows.details;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.walmart.citizencare.Constants;
import com.walmart.citizencare.R;
import com.walmart.citizencare.data.IssueMediaData;
import com.walmart.citizencare.data.IssuesView;

import java.util.List;

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.ViewHolder> {

    private Context mContext;
    private List<IssueMediaData> mList;

    public MediaAdapter(Context context, List<IssueMediaData> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_media, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final IssueMediaData mediaData = mList.get(position);

        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTitle;
        TextView tvDesc;
        TextView tvLocation;
        TextView tvUpdatedDate;
        ImageView ivThumbnail;
        TextView btnMedia;
        TextView btnPplWatch;
        TextView btnLike;

        public ViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
            tvDesc = (TextView) view.findViewById(R.id.tv_desc);
            tvLocation = (TextView) view.findViewById(R.id.tv_location);
            tvUpdatedDate = (TextView) view.findViewById(R.id.tv_updated_date);
            ivThumbnail = (ImageView) view.findViewById(R.id.iv_thumbnail);
            btnMedia = (TextView) view.findViewById(R.id.btn_media);
            btnPplWatch = (TextView) view.findViewById(R.id.btn_ppl_watch);
            btnLike = (TextView) view.findViewById(R.id.btn_like);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = (int) itemView.getTag();
        }
    }

}