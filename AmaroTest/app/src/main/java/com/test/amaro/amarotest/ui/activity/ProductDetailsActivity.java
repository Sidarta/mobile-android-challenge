package com.test.amaro.amarotest.ui.activity;

import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.amaro.amarotest.R;
import com.test.amaro.amarotest.entity.Product;
import com.test.amaro.amarotest.entity.Size;
import com.test.amaro.amarotest.ui.activity.presenter.ProductDetailsActivityPresenter;
import com.test.amaro.amarotest.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * normally we would have another service to get product details. So in that case we would have a presenter and an implementation
 * on this Activity. That way we could handle the api's, and all the necessary logic.
 * On this case, because this is a simple example/test, we are getting details via parcelable bundle.
 * So, we will still have the presenter to handle UI updates and stuff, but we wont have any
 * getting of information via api os something like that - so we wont need an implementation, only the presenter interface
 */


public class ProductDetailsActivity extends AppCompatActivity implements ProductDetailsActivityPresenter.View{

    //our "model" - the selected product
    Product product;

    List<TextView> sizeGrid;

    //so we can manipulate tap events
    List<TextView> sizeGridAvailables;

    @BindView(R.id.image_view_id)
    ImageView mImgViewProductImage;

    @BindView(R.id.linear_sizes_id)
    LinearLayout mLinLaySizeGrid;

    @BindView(R.id.text_view_size1_id)
    TextView mTxtViewSize1;

    @BindView(R.id.text_view_size2_id)
    TextView mTxtViewSize2;

    @BindView(R.id.text_view_size3_id)
    TextView mTxtViewSize3;

    @BindView(R.id.text_view_size4_id)
    TextView mTxtViewSize4;

    @BindView(R.id.text_view_size5_id)
    TextView mTxtViewSize5;

    @BindView(R.id.text_view_sale_status_id)
    TextView mTxtViewSaleStatus;

    @BindView(R.id.text_view_prodname_id)
    TextView mTxtViewProdName;

    @BindView(R.id.text_view_price_id)
    TextView mTxtViewProdPrice;

    @BindView(R.id.text_view_actual_price_id)
    TextView mTxtViewActualPrice;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        //butter knife
        ButterKnife.bind(this);

        //getting product from extra
        product = getIntent().getParcelableExtra(Constants.EXTRA_PRODUCT);
        sizeGrid = new ArrayList<TextView>();
        sizeGridAvailables = new ArrayList<TextView>();

        sizeGrid.add(mTxtViewSize1);
        sizeGrid.add(mTxtViewSize2);
        sizeGrid.add(mTxtViewSize3);
        sizeGrid.add(mTxtViewSize4);
        sizeGrid.add(mTxtViewSize5);

        this.displayProduct(product);
    }

    @Override
    public void displayProduct(Product product) {
        //picasso
        Picasso.get()
                .load(Uri.parse(product.getImage()))
                .placeholder(R.drawable.product_placeholder)
                .error(R.drawable.product_placeholder)
                .into(mImgViewProductImage);

        //------- size grid setup - not the best approach,
        // but for now, we know that the maximum is 5 sizes (pp, p, m, g, gg and from 36 to 44)
        for(int i = 0; i<5; i++){
            Size s = product.getSizes().get(i);
            TextView txtViewSize =  sizeGrid.get(i);

            //check for unique sizes first
            if(s.getSize().equalsIgnoreCase("u")){
                //size is unique, so we can leave out the size grid
                mLinLaySizeGrid.setVisibility(View.GONE);
                break;
            } else {
                txtViewSize.setText(s.getSize());
                if(s.isAvailable()){
                    txtViewSize.setAlpha(Constants.ALPHA_INSTOCK);
                    sizeGridAvailables.add(txtViewSize);
                } else {
                    txtViewSize.setAlpha(Constants.ALPHA_OUT_OF_STOCK);
                }
            }
        }

        for (TextView txtViewSize:sizeGridAvailables) {
            txtViewSize.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    highlightSelectedSize((TextView)v);
                }
            });
        }
        //-------

        mTxtViewProdPrice.setText(product.getRegular_price());

        //is on sale?
        if(product.getSale()){
            mTxtViewSaleStatus.setVisibility(View.VISIBLE);
            mTxtViewProdPrice.setVisibility(View.VISIBLE);
            mTxtViewProdPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);

        } else {
            mTxtViewSaleStatus.setVisibility(View.GONE);
            mTxtViewProdPrice.setVisibility(View.GONE);
        }

        mTxtViewProdName.setText(product.getName());

        mTxtViewActualPrice.setText(product.getActual_price());
    }

    private void highlightSelectedSize(TextView v) {
        for (TextView txtViewSize:sizeGrid) {
            if(txtViewSize.equals(v)){
                txtViewSize.setBackground(getResources().getDrawable(R.drawable.shape_round_activesize));
                txtViewSize.setTextColor(getResources().getColor(R.color.white));
            } else {
                txtViewSize.setBackground(getResources().getDrawable(R.drawable.shape_round_sizeindicator));
                txtViewSize.setTextColor(getResources().getColor(R.color.black));
            }
        }
    }
}
