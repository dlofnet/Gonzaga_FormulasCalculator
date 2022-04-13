package com.example.gonzaga_formulascalculator.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.gonzaga_formulascalculator.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnPhysics, btnGeo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hides Title Bar and Action Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        btnPhysics = findViewById(R.id.btnPhysics);
        btnGeo = findViewById(R.id.btnGeo);

        btnPhysics.setOnClickListener(this);
        btnGeo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPhysics:
                Intent i1 = new Intent(this, PhysicsActivity.class);
                startActivity(i1);
                break;
            case R.id.btnGeo:
                Intent i2 = new Intent(this, GeoActivity.class);
                startActivity(i2);
                break;
        }
    }
}