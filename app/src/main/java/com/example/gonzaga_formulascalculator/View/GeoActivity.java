package com.example.gonzaga_formulascalculator.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.gonzaga_formulascalculator.R;

public class GeoActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView btnCylinder, btnTorus, btnPyramid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hides Title Bar and Action Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_geo);

        btnCylinder = findViewById(R.id.btnCylinder);
        btnTorus = findViewById(R.id.btnTorus);
        btnPyramid = findViewById(R.id.btnPyramid);

        btnCylinder.setOnClickListener(this);
        btnTorus.setOnClickListener(this);
        btnPyramid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCylinder:
                Intent i = new Intent(this, GeometryCylinder.class);
                startActivity(i);
                break;
            case R.id.btnTorus:
                Intent i1 = new Intent(this, GeometryTorus.class);
                startActivity(i1);
                break;
            case R.id.btnPyramid:
                Intent i2 = new Intent(this, GeometryPyramid.class);
                startActivity(i2);
                break;
        }
    }
}