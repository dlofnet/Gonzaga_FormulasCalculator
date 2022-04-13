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
import com.example.gonzaga_formulascalculator.Model.Variables;
import com.example.gonzaga_formulascalculator.R;
import com.google.android.material.snackbar.Snackbar;

public class PhysProjectile3 extends Fragment {

    EditText physP3v1y, physP3t, physP3g;
    Button btnPhysP3;
    TextView txtPhysP3;

    Variables var = new Variables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_physics_projectile3, container, false);

        physP3v1y = (EditText) rootView.findViewById(R.id.physP3v1y);
        physP3t = (EditText) rootView.findViewById(R.id.physP3t);
        physP3g = (EditText) rootView.findViewById(R.id.physP3g);
        btnPhysP3 = (Button) rootView.findViewById(R.id.btnPhysP3);
        txtPhysP3 = (TextView) rootView.findViewById(R.id.txtPhysP3);

        btnPhysP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setV1y(Double.parseDouble(physP3v1y.getText().toString()));
                var.setT(Double.parseDouble(physP3t.getText().toString()));
                var.setG(Double.parseDouble(physP3g.getText().toString()));
                var.setAnsPhys(calc.physGetV2y(var.getV1y(), var.getT(), var.getG()));

                if (var.getAnsPhys() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtPhysP3.setText("Δdᵧ = " + var.getAnsPhys());
                }
            }
        });
        return rootView;
    }
}
