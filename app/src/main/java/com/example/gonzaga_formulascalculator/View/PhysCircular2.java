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

public class PhysCircular2 extends Fragment {

    EditText physC2w, physC2r;
    Button btnPhysC2;
    TextView txtPhysC2;

    Variables var = new Variables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_physics_circular2, container, false);

        physC2w = (EditText) rootView.findViewById(R.id.physC2w);
        physC2r = (EditText) rootView.findViewById(R.id.physC2r);
        btnPhysC2 = (Button) rootView.findViewById(R.id.btnPhysC2);
        txtPhysC2 = (TextView) rootView.findViewById(R.id.txtPhysC2);

        btnPhysC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setW(Double.parseDouble(physC2w.getText().toString()));
                var.setRadius(Double.parseDouble(physC2r.getText().toString()));
                var.setAnsPhys(calc.physGetVt(var.getW(), var.getRadius()));

                if (var.getAnsPhys() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtPhysC2.setText("vₜ = " + var.getAnsPhys());
                }
            }
        });
        return rootView;
    }
}