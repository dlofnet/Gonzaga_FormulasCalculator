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

public class PhysProjectile2 extends Fragment {

    EditText physP2v1y, physP2t, physP2g;
    Button btnPhysP2;
    TextView txtPhysP2;

    PhysicsVariables var = new PhysicsVariables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_physics_projectile2, container, false);

        physP2v1y = (EditText) rootView.findViewById(R.id.physP2v1y);
        physP2t = (EditText) rootView.findViewById(R.id.physP2t);
        physP2g = (EditText) rootView.findViewById(R.id.physP2g);
        btnPhysP2 = (Button) rootView.findViewById(R.id.btnPhysP2);
        txtPhysP2 = (TextView) rootView.findViewById(R.id.txtPhysP2);

        btnPhysP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setV1y(Double.parseDouble(physP2v1y.getText().toString()));
                var.setT(Double.parseDouble(physP2t.getText().toString()));
                var.setG(Double.parseDouble(physP2g.getText().toString()));
                var.setAnsPhys(calc.physGetDy(var.getV1y(), var.getT(), var.getG()));

                if (var.getAnsPhys() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtPhysP2.setText("v₂ᵧ = " + var.getAnsPhys());
                }
            }
        });
        return rootView;
    }
}
