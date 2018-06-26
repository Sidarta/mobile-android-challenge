package com.test.amaro.amarotest.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.amaro.amarotest.R;
import com.test.amaro.amarotest.entity.Product;
import com.test.amaro.amarotest.ui.activity.ProductDetailsActivity;
import com.test.amaro.amarotest.ui.adapter.presenter.FeedAdapterPresenter;
import com.test.amaro.amarotest.ui.adapter.presenter.implementation.FeedAdapterPresenterImplementation;
import com.test.amaro.amarotest.utils.Constants;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> implements FeedAdapterPresenter.View {

    //presenter not used here yet because no logic on this ui is implemented
    private FeedAdapterPresenter mFeedAdapterPresenter;
    private Context mContext;

    //products list
    private List<Product> mProductList;

    public FeedAdapter(Context mContext, List<Product> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
        this.mFeedAdapterPresenter = new FeedAdapterPresenterImplementation(this);
    }

    /*
    Adapter Methods
     */
    @NonNull
    @Override
    public FeedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull FeedAdapter.ViewHolder holder, int position) {
        final Product product = this.mProductList.get(position);
        holder.productName.setText(product.getName());
        holder.productPrice.setText(product.getActual_price());

        //picasso
        Picasso.get()
                .load(Uri.parse(product.getImage()))
                .placeholder(R.drawable.product_placeholder)
                .error(R.drawable.product_placeholder)
                .into(holder.productImage);

        //on click - start product details activity
        holder.productCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start product details activity
                Intent intent = new Intent(mContext, ProductDetailsActivity.class);
                intent.putExtra(Constants.EXTRA_PRODUCT, product);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    /*
    Presenter View methods
     */
    @Override
    public void updateFeed(List<Product> products) {
        this.mProductList = products;
        this.notifyDataSetChanged();
    }

    /*
    Adapter View Holder
     */
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView productName;
        ImageView productImage;
        TextView productPrice;
        CardView productCard;

        ViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.text_view_title_id);
            productImage = itemView.findViewById(R.id.image_view_photo_id);
            productPrice = itemView.findViewById(R.id.text_view_price_id);
            productCard = itemView.findViewById(R.id.product_card);
        }
    }
}
