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

public class PhysStraight1 extends Fragment {

    EditText phys1x1, phys1x2;
    Button btnPhys1;
    TextView txtPhys1;

    Variables var = new Variables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_physics_straight1, container, false);

        phys1x1 = (EditText) rootView.findViewById(R.id.phys1x1);
        phys1x2 = (EditText) rootView.findViewById(R.id.phys1x2);
        btnPhys1 = (Button) rootView.findViewById(R.id.btnPhys1);
        txtPhys1 = (TextView) rootView.findViewById(R.id.txtPhys1);

        btnPhys1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setX1(Double.parseDouble(phys1x1.getText().toString()));
                var.setX2(Double.parseDouble(phys1x2.getText().toString()));
                var.setAnsPhys(calc.physGetD(var.getX2(), var.getX1()));

                if (var.getAnsPhys() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtPhys1.setText("Δd = " + var.getAnsPhys());
                }
            }
        });
        return rootView;
    }
}