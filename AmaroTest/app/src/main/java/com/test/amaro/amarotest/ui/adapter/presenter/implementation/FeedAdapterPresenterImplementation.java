package com.test.amaro.amarotest.ui.adapter.presenter.implementation;

import com.test.amaro.amarotest.ui.adapter.presenter.FeedAdapterPresenter;

public class FeedAdapterPresenterImplementation implements FeedAdapterPresenter{

    //View is here if we needed to update some UI based on some other Logic
    private FeedAdapterPresenter.View mView;

    public FeedAdapterPresenterImplementation(View mView) {
        this.mView = mView;
    }
}
