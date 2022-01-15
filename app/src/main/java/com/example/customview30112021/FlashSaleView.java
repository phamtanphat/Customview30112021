package com.example.customview30112021;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class FlashSaleView extends ConstraintLayout {

    private ImageView img;
    private TextView txtPrice , txtSold;
    private ProgressBar progressBar;

    private Integer price, total , sold , resourceImage;


    public FlashSaleView(@NonNull Context context) {
        super(context);
        initView(context,null);
    }

    public FlashSaleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    public FlashSaleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    private void initView(Context context, AttributeSet attr){
        if (context != null && attr != null){
            // CHuyển kiểu layout sang view
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.item_flash_sale,this,true);
            // Lấy dữ liệu từ attrs
            TypedArray typedArray = context.obtainStyledAttributes(attr,R.styleable.FlashSaleView);
            price = typedArray.getInt(R.styleable.FlashSaleView_price,-1);
            total = typedArray.getInt(R.styleable.FlashSaleView_total,-1);
            sold = typedArray.getInt(R.styleable.FlashSaleView_sold,-1);
            resourceImage = typedArray.getResourceId(R.styleable.FlashSaleView_imageSrc,-1);
            typedArray.recycle();
            mapView(view);

        }
    }

    private void mapView(View view) {
        img = view.findViewById(R.id.imageView);
        txtPrice = view.findViewById(R.id.textViewPrice);
        txtSold = view.findViewById(R.id.textViewSold);
        progressBar = view.findViewById(R.id.progressBar);

        img.setImageResource(resourceImage);
        txtPrice.setText("đ " + price);
        txtSold.setText("Đã bán " + sold);

        progressBar.setMax(total);
        progressBar.setProgress(Math.round(sold * 100 / total));
    }
}
