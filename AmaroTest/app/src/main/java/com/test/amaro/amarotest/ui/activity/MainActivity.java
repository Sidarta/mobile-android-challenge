package com.test.amaro.amarotest.ui.activity;

import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.test.amaro.amarotest.R;
import com.test.amaro.amarotest.entity.Product;
import com.test.amaro.amarotest.ui.activity.presenter.MainActivityPresenter;
import com.test.amaro.amarotest.ui.activity.presenter.implementation.MainActivityPresenterImplementation;
import com.test.amaro.amarotest.ui.adapter.FeedAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View, SwipeRefreshLayout.OnRefreshListener {

    private static final String LOG_TAG = " TAG Main Act.";

    /*
    Recycler View
     */
    @BindView(R.id.recyclerviewfeed) RecyclerView mFeedRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private FeedAdapter mFeedAdapter;

    /*
    Presenter
     */
    private MainActivityPresenter mMainActivityPresenter;

    /*
    Pull To Refresh
     */
    @BindView(R.id.swiperefresh) SwipeRefreshLayout mFeedSwipeRefreshLayout;

    /*
    Model - List of products
     */
    private List<Product> mProductsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //butter knife
        ButterKnife.bind(this);

        mProductsList = new ArrayList<>();

        mLayoutManager = new LinearLayoutManager(this);
        mFeedAdapter = new FeedAdapter(this, mProductsList);
        mFeedRecyclerView.setAdapter(mFeedAdapter);
        mFeedRecyclerView.setLayoutManager(mLayoutManager);

        mFeedSwipeRefreshLayout.setOnRefreshListener(this);

        //TODO might have to convert mView to Activity
        mMainActivityPresenter = new MainActivityPresenterImplementation(this, this);

        //initial loading
        this.goToTopOfList();
        mMainActivityPresenter.getFeed();
        mFeedSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.goToTopOfList(); //TODO thinking.. could save user state - leave where he left
//        mMainActivityPresenter.getFeed();
//        mFeedSwipeRefreshLayout.setRefreshing(true);
    }

    /*
    Swipe Refresh Layout
     */
    @Override
    public void onRefresh() {
        mFeedSwipeRefreshLayout.setRefreshing(true);
        swipeOnRefreshUpdateProductsList();
    }

    /*
    Presenter Methods
     */
    @Override
    public void refreshProductList(List<Product> products) {
        mProductsList.clear();
        mProductsList.addAll(products);
        mFeedAdapter.updateFeed(mProductsList);
        mFeedSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void goToTopOfList() {
        mFeedRecyclerView.getLayoutManager().scrollToPosition(0);
    }

    @Override
    public void showErrorMessage() {
        mFeedSwipeRefreshLayout.setRefreshing(false);
        Snackbar.make(mFeedRecyclerView, R.string.error_feed, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void sortFeed() {
        Collections.sort(mProductsList);
        mFeedAdapter.updateFeed(mProductsList);
        mFeedSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void feedWithOnlyProductsOnSale() {
        List<Product> productsListAux = new ArrayList<Product>();

        for (Product prod:mProductsList) {
            if(prod.getSale()){
                productsListAux.add(prod);
            }
        }
        mProductsList.clear();
        mProductsList = productsListAux;
        mFeedAdapter.updateFeed(mProductsList);
        mFeedSwipeRefreshLayout.setRefreshing(false);
    }


    /*
    Action Bar Menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            // Check if user triggered a refresh:
            case R.id.menurefresh:
                Log.i(LOG_TAG, "Refresh menu item selected");

                // Signal SwipeRefreshLayout to start the progress indicator
                mFeedSwipeRefreshLayout.setRefreshing(true);

                // Start the refresh background task.
                // This method calls setRefreshing(false) when it's finished.
                swipeOnRefreshUpdateProductsList();

                return true;

            case R.id.sortprice:
                mFeedSwipeRefreshLayout.setRefreshing(true);
                this.sortFeed();

            case R.id.showonlyonsale:
                mFeedSwipeRefreshLayout.setRefreshing(true);
                this.feedWithOnlyProductsOnSale();

        }

        return super.onOptionsItemSelected(item);
    }

    /*
    Separate method for updating - used on callback and on menu force update
     */
    private void swipeOnRefreshUpdateProductsList() {
        //do the actual refreshing here
        this.goToTopOfList();
        mMainActivityPresenter.getFeed();
    }
}
