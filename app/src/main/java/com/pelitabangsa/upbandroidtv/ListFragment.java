package com.pelitabangsa.upbandroidtv;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.FocusHighlight;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

import com.pelitabangsa.upbandroidtv.models.motor.DetailsItem;
import com.pelitabangsa.upbandroidtv.models.motor.MotorModel;
import com.pelitabangsa.upbandroidtv.models.motor.ResultsItem;

public class ListFragment extends RowsSupportFragment {

    private OnItemSelectedListener itemSelectedListener = null;
    private OnItemClickListener itemViewClickedListener = null;
    private ArrayObjectAdapter rootAdapter = new ArrayObjectAdapter(new ListRowPresenter(FocusHighlight.ZOOM_FACTOR_MEDIUM));

    public interface OnItemSelectedListener {
        void onItemSelected(DetailsItem item);
    }

    public interface OnItemClickListener {
        void onItemClick(DetailsItem item);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAdapter(rootAdapter);

        setOnItemViewSelectedListener(new ItemViewSelectedListener());
        setOnItemViewClickedListener(new ItemViewClickedListener());
    }

    public void bindData(MotorModel motorList) {

        for (ResultsItem motorModel : motorList.getResults()) {
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new ItemPresenter());

            for (DetailsItem detail : motorModel.getDetails()) {
                arrayObjectAdapter.add(detail);
            }

            HeaderItem headerItem = new HeaderItem(motorModel.getTitle());
            ListRow listRow = new ListRow(headerItem, arrayObjectAdapter);
            rootAdapter.add(listRow);
        }
    }

    public void setOnContentSelectedListener(OnItemSelectedListener listener) {
        this.itemSelectedListener = listener;
    }

    public void setOnContentClickedListener(OnItemClickListener listener) {
        this.itemViewClickedListener = listener;
    }

    private class ItemViewSelectedListener implements OnItemViewSelectedListener {
        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item instanceof DetailsItem) {
                if (itemSelectedListener != null) {
                    itemSelectedListener.onItemSelected((DetailsItem) item);
                }
            }
        }
    }

    private class ItemViewClickedListener implements OnItemViewClickedListener {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item instanceof DetailsItem) {
                if (itemViewClickedListener != null) {
                    itemViewClickedListener.onItemClick((DetailsItem) item);
                }
            }
        }
    }

}