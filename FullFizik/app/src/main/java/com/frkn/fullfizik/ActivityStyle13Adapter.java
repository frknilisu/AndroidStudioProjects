package com.frkn.fullfizik;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ActivityStyle13Adapter extends RecyclerView.Adapter<ActivityStyle13Adapter.ItemViewHolder> {
    private ArrayList<ActivityStyle13Model> dataList;
    private LayoutInflater mInflater;
    private Context context;
    private ActivityStyle13ClickListener clicklistener = null;

    public ActivityStyle13Adapter(Context ctx, ArrayList<ActivityStyle13Model> dataList) {
        this.context = ctx;
        this.dataList = dataList;
        this.mInflater = LayoutInflater.from(context);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView image;
        private TextView name;
        private TextView description;

        public ItemViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            image = (ImageView) itemView.findViewById(R.id.imageMain);
            name = (TextView) itemView.findViewById(R.id.name);
            description = (TextView) itemView.findViewById(R.id.manifesto);
        }

        @Override
        public void onClick(View v) {

            if (clicklistener != null) {
                clicklistener.itemClicked(v, getAdapterPosition());
            }
        }
    }

    public void setClickListener(ActivityStyle13ClickListener listener) {
        this.clicklistener = listener;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_activity13, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        ActivityStyle13Model item = dataList.get(position);
        holder.image.setImageResource(item.getImageId());
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());

        /*
        Glide.with(context)
                .load(BuildConfig.IMAGE_URL + dataList.get(position).getImageUrl())
                .thumbnail(0.01f)
                .centerCrop()
                .into(holder.image);
                */

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
