package com.test.amaro.amarotest.ui.activity.presenter.implementation;

import android.content.Context;
import android.util.Log;

import com.test.amaro.amarotest.callback.OnGetFeed;
import com.test.amaro.amarotest.entity.Product;
import com.test.amaro.amarotest.repository.FeedRepository;
import com.test.amaro.amarotest.repository.implementation.FeedRepositoryImplementation;
import com.test.amaro.amarotest.ui.activity.presenter.MainActivityPresenter;

import java.util.List;

public class MainActivityPresenterImplementation implements MainActivityPresenter, OnGetFeed{

    private static final String LOG_TAG = "TAG MA Pres. Imp.";

    private MainActivityPresenter.View mView;
    private Context mContext;
    private FeedRepository mFeedRepository;

    public MainActivityPresenterImplementation(View mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
        mFeedRepository = new FeedRepositoryImplementation();
    }

    @Override
    public void getFeed() {
        mFeedRepository.getFeed(this);
    }

    @Override
    public void onGetFeedSuccessful(List<Product> products) {
        mView.refreshProductList(products);
    }

    @Override
    public void onGetFeedFailiure(String errorMessage) {
        Log.e(LOG_TAG, errorMessage);
        mView.showErrorMessage();
    }
}
