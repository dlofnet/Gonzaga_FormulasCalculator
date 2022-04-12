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

public class PhysStraight3 extends Fragment {

    EditText phys3d,phys3t,phys3x;
    Button btnPhys3;
    TextView txtPhys3;

    PhysicsVariables var = new PhysicsVariables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_physics_straight3, container, false);

        phys3d = (EditText) rootView.findViewById(R.id.phys3d);
        phys3t = (EditText) rootView.findViewById(R.id.phys3t);
        phys3x = (EditText) rootView.findViewById(R.id.phys3x);
        btnPhys3 = (Button) rootView.findViewById(R.id.btnPhys3);
        txtPhys3 = (TextView) rootView.findViewById(R.id.txtPhys3);

        btnPhys3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setD(Double.parseDouble(phys3d.getText().toString()));
                var.setT(Double.parseDouble(phys3t.getText().toString()));
                var.setX(Double.parseDouble(phys3x.getText().toString()));
                var.setAnsPhys(calc.physGetA(var.getD(),var.getT(), var.getX()));

                if (var.getAnsPhys() <= 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtPhys3.setText("a = " + var.getAnsPhys());
                }
            }
        });
        return rootView;
    }
}