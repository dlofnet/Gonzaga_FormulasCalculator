package com.example.gonzaga_formulascalculator.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gonzaga_formulascalculator.Controller.Formulas;
import com.example.gonzaga_formulascalculator.Model.PhysicsVariables;
import com.example.gonzaga_formulascalculator.R;
import com.google.android.material.snackbar.Snackbar;

public class PhysProjectile1 extends Fragment {

    EditText physP1vx, physP1t;
    Button btnPhysP1;
    TextView txtPhysP1;

    PhysicsVariables var = new PhysicsVariables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_physics_projectile1, container, false);

        physP1vx = (EditText) rootView.findViewById(R.id.physP1vx);
        physP1t = (EditText) rootView.findViewById(R.id.physP1t);
        btnPhysP1 = (Button) rootView.findViewById(R.id.btnPhysP1);
        txtPhysP1 = (TextView) rootView.findViewById(R.id.txtPhysP1);

        btnPhysP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setVx(Double.parseDouble(physP1vx.getText().toString()));
                var.setT(Double.parseDouble(physP1t.getText().toString()));
                var.setAnsPhys(calc.physGetDx(var.getVx(), var.getT()));

                if (var.getAnsPhys() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtPhysP1.setText("Δdₓ = " + var.getAnsPhys());
                }
            }
        });
        return rootView;
    }
}
