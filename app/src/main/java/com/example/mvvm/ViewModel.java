package com.example.mvvm;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

public class ViewModel {
    private Model dataModel = new Model();
    public final ObservableField<String> mData = new ObservableField<>();
    public final ObservableBoolean isLoading = new ObservableBoolean(false);
    public void refresh() {
        isLoading.set(true);

        dataModel.retrieveData(new Model.onDataReadyCallback() {
            @Override
            public void onDataReady(String data) {
                mData.set(data);
                isLoading.set(false);
            }
        });
    }
}
