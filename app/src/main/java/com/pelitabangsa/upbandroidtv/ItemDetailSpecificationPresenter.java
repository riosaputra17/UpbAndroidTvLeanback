package com.pelitabangsa.upbandroidtv;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.leanback.widget.Presenter;

import com.bumptech.glide.Glide;
import com.pelitabangsa.upbandroidtv.models.motor2.SpesifikasiItem;

public class ItemDetailSpecificationPresenter extends Presenter {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_specification_view, parent, false);

        return new ViewHolder(view);
    }

    private int getWidthInPercent(Context context, int percent) {
        int width = context.getResources().getDisplayMetrics().widthPixels;
        return (width * percent) / 100;
    }

    private int getHeightInPercent(Context context, int percent) {
        int height = context.getResources().getDisplayMetrics().heightPixels;
        return (height * percent) / 100;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {

        SpesifikasiItem content = (SpesifikasiItem) item;

        ImageView imageView = viewHolder.view.findViewById(R.id.image);
        TextView tvTitleSpec = viewHolder.view.findViewById(R.id.tv_title_spec);
        String url = content.getImage();

        tvTitleSpec.setText(content.getTitleSpec());
        Log.d("TESTLAH", "title:"+content.getTitleSpec());
        Log.d("TESTLAH", "image:"+content.getImage());
        Glide.with(viewHolder.view.getContext())
                .load(url)
                .into(imageView);

    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }
}
