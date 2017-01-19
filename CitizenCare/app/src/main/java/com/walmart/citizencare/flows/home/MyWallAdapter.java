package com.walmart.citizencare.flows.home;

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
import com.walmart.citizencare.data.IssuesView;
import com.walmart.citizencare.flows.createnew.SettingsActivity;
import com.walmart.citizencare.flows.details.IssueDetailActivity;

import java.util.List;

public class MyWallAdapter extends RecyclerView.Adapter<MyWallAdapter.ViewHolder> {

    private Context mContext;
    private List<IssuesView> mList;

    public MyWallAdapter(Context context, List<IssuesView> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wall, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final IssuesView issuesView = mList.get(position);
        holder.tvTitle.setText(issuesView.getTitle());
        holder.tvDesc.setText(issuesView.getDescription());
        holder.tvLocation.setText(issuesView.getLocation());
        holder.ivThumbnail.setVisibility(View.GONE);
        holder.btnMedia.setText(issuesView.getMediaCount() + " Media");
        holder.btnPplWatch.setText(issuesView.getWatchCount() + " People watching");
        holder.btnLike.setText(issuesView.getLikeCount() + " Likes");

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
            IssuesView issuesView = mList.get(position);
            Intent intent = new Intent(mContext, IssueDetailActivity.class);
            intent.putExtra(Constants.ISSUES_VIEW_LIST, issuesView);
            mContext.startActivity(intent);

        }
    }

}