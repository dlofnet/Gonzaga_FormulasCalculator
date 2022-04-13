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

public class PhysCircular3 extends Fragment {

    EditText physC3a, physC3r;
    Button btnPhysC3;
    TextView txtPhysC3;

    Variables var = new Variables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_physics_circular3, container, false);

        physC3a = (EditText) rootView.findViewById(R.id.physC3a);
        physC3r = (EditText) rootView.findViewById(R.id.physC3r);
        btnPhysC3 = (Button) rootView.findViewById(R.id.btnPhysC3);
        txtPhysC3 = (TextView) rootView.findViewById(R.id.txtPhysC3);

        btnPhysC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setA(Double.parseDouble(physC3a.getText().toString()));
                var.setRadius(Double.parseDouble(physC3r.getText().toString()));
                var.setAnsPhys(calc.physGetAt(var.getA(), var.getRadius()));

                if (var.getAnsPhys() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtPhysC3.setText("aₜ = " + var.getAnsPhys());
                }
            }
        });
        return rootView;
    }
}