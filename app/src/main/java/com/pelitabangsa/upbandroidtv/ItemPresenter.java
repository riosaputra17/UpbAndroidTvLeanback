package com.pelitabangsa.upbandroidtv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.leanback.widget.Presenter;

import com.bumptech.glide.Glide;
import com.pelitabangsa.upbandroidtv.models.motor.DetailsItem;

public class ItemPresenter extends Presenter {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);

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

        DetailsItem content = (DetailsItem) item;

        ImageView imageView = viewHolder.view.findViewById(R.id.poster_image);
        TextView textCard = viewHolder.view.findViewById(R.id.text_card);
        String url = content.getMotorPoster();

        textCard.setText(content.getMotorModel());
        Glide.with(viewHolder.view.getContext())
                .load(url)
                .into(imageView);

    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }
}
