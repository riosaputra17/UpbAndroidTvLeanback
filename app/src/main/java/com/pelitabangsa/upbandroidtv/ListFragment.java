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

public class ListFragment extends RowsSupportFragment {

    private ArrayObjectAdapter rootAdapter = new ArrayObjectAdapter(new ListRowPresenter(FocusHighlight.ZOOM_FACTOR_MEDIUM));

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAdapter(rootAdapter);
    }

    public void bindData(DataModel dataList) {

        for (DataModel.Result dataModel : dataList.result) {
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new ItemPresenter());

            for (DataModel.Result.Detail detail : dataModel.details) {
                arrayObjectAdapter.add(detail);
            }

            HeaderItem headerItem = new HeaderItem(dataModel.title);
            ListRow listRow = new ListRow(headerItem, arrayObjectAdapter);
            rootAdapter.add(listRow);
        }
    }
}