package com.rohan.mmengineerco.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fire is the biggest enemy of mankind,Can be used efficiently if handled properly.we as a firefighter has always look to possess and provide capabilities to handle and manage fire with lot of advancement in technolgy.With the support of various approving agency and regulators we have been able to provide latest innovative solutions and avoid disaster from the risk of fire. I wish that new and new products and technologies are developed and adopted globally to make world fire safe. keep moving...........");
    }

    public LiveData<String> getText() {
        return mText;
    }
}