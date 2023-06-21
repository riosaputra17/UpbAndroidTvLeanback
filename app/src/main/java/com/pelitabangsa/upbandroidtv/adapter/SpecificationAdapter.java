package com.pelitabangsa.upbandroidtv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pelitabangsa.upbandroidtv.R;
import com.pelitabangsa.upbandroidtv.models.motor2.SpesifikasiItem;

import java.util.List;

public class SpecificationAdapter extends RecyclerView.Adapter<SpecificationAdapter.ViewHolder> {

    private List<SpesifikasiItem> mSpesifikasiItem;

    public SpecificationAdapter(List<SpesifikasiItem> spesifikasiItems) {
        mSpesifikasiItem = spesifikasiItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View spesifikasiItemView = inflater.inflate(R.layout.item_detail_specification_view, parent, false);

        ViewHolder viewHolder = new ViewHolder(spesifikasiItemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SpesifikasiItem spesifikasiItem = mSpesifikasiItem.get(position);

        ImageView image = holder.image;

        Context context = holder.image.getContext();
        String url = spesifikasiItem.getImage();
        Glide.with(context)
                .load(url)
                .into(image);

        TextView tvTitleSpec = holder.tvTitleSpec;
        tvTitleSpec.setText(spesifikasiItem.getTitleSpec());

        TextView tvDescSpec = holder.tvDescSpec;
        tvDescSpec.setText(spesifikasiItem.getDescSpec());
    }

    @Override
    public int getItemCount() {
        return mSpesifikasiItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView tvTitleSpec;
        public TextView tvDescSpec;

        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image);
            tvTitleSpec = (TextView) itemView.findViewById(R.id.tv_title_spec);
            tvDescSpec = (TextView) itemView.findViewById(R.id.tv_desc_spec);
        }

    }

}
