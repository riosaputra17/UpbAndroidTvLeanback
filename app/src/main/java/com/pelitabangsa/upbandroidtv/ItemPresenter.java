package com.pelitabangsa.upbandroidtv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.leanback.widget.Presenter;

import com.bumptech.glide.Glide;

public class ItemPresenter extends Presenter {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);

        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = getWidthInPercent(parent.getContext(), 24);
        params.height = getHeightInPercent(parent.getContext(), 24);

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

        DataModel.Result.Detail content = (DataModel.Result.Detail) item;

        ImageView imageView = viewHolder.view.findViewById(R.id.poster_image);
        String url = "https://www.themoviedb.org/t/p/w500" + content.backdrop_path;

        Glide.with(viewHolder.view.getContext())
                .load(url)
                .into(imageView);

    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }
}
