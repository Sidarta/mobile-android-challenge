package com.test.amaro.amarotest.repository;

import com.test.amaro.amarotest.callback.OnGetFeed;

public interface FeedRepository {

    void getFeed(OnGetFeed onGetFeed);

}
