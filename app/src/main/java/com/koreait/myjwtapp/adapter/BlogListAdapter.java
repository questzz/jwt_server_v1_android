package com.koreait.myjwtapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.koreait.myjwtapp.R;
import com.koreait.myjwtapp.repository.models.response.ResPost;

import java.util.ArrayList;
import java.util.List;

public class BlogListAdapter extends RecyclerView.Adapter<BlogListAdapter.ViewHolder> {

    private Context context;
    private List<ResPost.Data> list = new ArrayList<>();

    public BlogListAdapter(Context context) {
        this.context = context;
    }

    public void setItemData(List<ResPost.Data> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_blog_card,parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResPost.Data data = list.get(position);
        // holder.imageView
        holder.titleTv.setText(data.title);
        holder.userNameTv.setText(data.user.username);
        holder.contentTv.setText(data.content);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView titleTv;
        TextView userNameTv;
        TextView contentTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.blogCardImage);
            titleTv = itemView.findViewById(R.id.blogTitleTv);
            userNameTv = itemView.findViewById(R.id.userNameTv);
            contentTv = itemView.findViewById(R.id.blogContentTv);

        }
    }
}
