package com.android.flipprogressdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.taishi.flipprogressdialog.FlipProgressDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRotationX,btnRotationY,btnFast,btnSlow,btnBorder,btnDim,btnNoAlpha,btn360,btnCircle;
    List<Integer> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageList.add(R.drawable.ic_baseline_favorite_border_24);
        imageList.add(R.drawable.ic_baseline_favorite_24);

        btnRotationX = findViewById(R.id.btnRotationX);
        btnRotationY = findViewById(R.id.btnRotationy);
        btnFast = findViewById(R.id.btnFast);
        btnSlow = findViewById(R.id.btnSlow);
        btnBorder = findViewById(R.id.btnBorder);
        btnDim = findViewById(R.id.btnDim);
        btnNoAlpha = findViewById(R.id.btnNoAlphaChange);
        btn360 = findViewById(R.id.btn360);
        btnCircle = findViewById(R.id.btnCircle);


        btnRotationX.setOnClickListener(this);
        btnRotationY.setOnClickListener(this);
        btnFast.setOnClickListener(this);
        btnSlow.setOnClickListener(this);
        btnBorder.setOnClickListener(this);
        btnDim.setOnClickListener(this);
        btnNoAlpha.setOnClickListener(this);
        btn360.setOnClickListener(this);
        btnCircle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRotationX:{
                showFlipProgressDialog("rotationX","");
                break;
            }
            case R.id.btnRotationy:{
                showFlipProgressDialog("rotationY","");
                break;
            }
            case R.id.btnFast:{
                showFlipProgressDialog("rotationY","fast");
                break;
            }
            case R.id.btnSlow:{
                showFlipProgressDialog("rotationY","slow");
                break;
            }
            case R.id.btnBorder:{
                showFlipProgressDialog("rotationY","border");
                break;
            }
            case R.id.btnDim:{
                showFlipProgressDialog("rotationY","dim");
                break;
            }
            case R.id.btn360:{
                showFlipProgressDialog("rotationY","360");
                break;
            }
            case R.id.btnNoAlphaChange:{
                showFlipProgressDialog("rotationY","alpha");
                break;
            }
            case R.id.btnCircle:{
                showFlipProgressDialog("rotationY","circle");
                break;
            }
        }
    }

    private void showFlipProgressDialog(String orientation,String option) {
        FlipProgressDialog flipProgressDialog = new FlipProgressDialog();
        flipProgressDialog.setImageList(imageList);
        flipProgressDialog.setOrientation(orientation);
        flipProgressDialog.setBackgroundColor(Color.parseColor("#FF4081"));

        if (orientation.equals("rotationY")){
            flipProgressDialog.setBackgroundAlpha(0.2f);
            flipProgressDialog.setCornerRadius(32);
        }else if (orientation.equals("rotationX")){
            flipProgressDialog.setBackgroundAlpha(1.0f);
        }else{
            flipProgressDialog.setBackgroundAlpha(0.3f);
        }

        //option
        if (option.equals("fast")){
            flipProgressDialog.setDuration(300);
        }else if (option.equals("slow")){
            flipProgressDialog.setDuration(800);
        }else if (option.equals("dim")){
            flipProgressDialog.setDimAmount(0.8f);
        }else if (option.equals("border")){
            flipProgressDialog.setBorderColor(Color.parseColor("#333639"));
            flipProgressDialog.setBorderStroke(10);
        }else if (option.equals("alpha")){
            flipProgressDialog.setMinAlpha(1.0f);
        }else if (option.equals("360")){
            flipProgressDialog.setEndAngle(360.0f);
        }else if (option.equals("circle")){
            flipProgressDialog.setCornerRadius(200);
        }


        flipProgressDialog.show(getFragmentManager(),"");
    }
}