package com.example.gonzaga_formulascalculator.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.gonzaga_formulascalculator.R;

public class PhysicsActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView btnStraight, btnCircular, btnProjectile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hides Title Bar and Action Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_physics);

        btnStraight = findViewById(R.id.btnStraight);
        btnCircular = findViewById(R.id.btnCircular);
        btnProjectile = findViewById(R.id.btnProjectile);

        btnStraight.setOnClickListener(this);
        btnCircular.setOnClickListener(this);
        btnProjectile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStraight:
                Intent i = new Intent(this, PhysicsStraight.class);
                startActivity(i);
                break;
            case R.id.btnCircular:
                Intent i1 = new Intent(this, PhysicsCircular.class);
                startActivity(i1);
                break;
            case R.id.btnProjectile:
                Intent i2 = new Intent(this, PhysicsProjectile.class);
                startActivity(i2);
                break;
        }
    }
}