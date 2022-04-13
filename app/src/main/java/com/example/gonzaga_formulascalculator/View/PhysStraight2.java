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

public class PhysStraight2 extends Fragment {

    EditText phys2d,phys2t,phys2x;
    Button btnPhys2;
    TextView txtPhys2;

    Variables var = new Variables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_physics_straight2, container, false);

        phys2d = (EditText) rootView.findViewById(R.id.phys2d);
        phys2t = (EditText) rootView.findViewById(R.id.phys2t);
        phys2x = (EditText) rootView.findViewById(R.id.phys2x);
        btnPhys2 = (Button) rootView.findViewById(R.id.btnPhys2);
        txtPhys2 = (TextView) rootView.findViewById(R.id.txtPhys2);

        btnPhys2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setD(Double.parseDouble(phys2d.getText().toString()));
                var.setT(Double.parseDouble(phys2t.getText().toString()));
                var.setX(Double.parseDouble(phys2x.getText().toString()));
                var.setAnsPhys(calc.physGetV(var.getD(),var.getT(), var.getX()));

                if (var.getAnsPhys() <= 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtPhys2.setText("v = " + var.getAnsPhys());
                }
            }
        });
        return rootView;
    }
}
