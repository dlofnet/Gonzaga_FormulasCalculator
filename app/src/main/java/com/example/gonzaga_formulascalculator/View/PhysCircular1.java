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

public class PhysCircular1 extends Fragment {

    EditText physC1vt, physC1r;
    Button btnPhysC1;
    TextView txtPhysC1;

    PhysicsVariables var = new PhysicsVariables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_physics_circular1, container, false);

        physC1vt = (EditText) rootView.findViewById(R.id.physC1vt);
        physC1r = (EditText) rootView.findViewById(R.id.physC1r);
        btnPhysC1 = (Button) rootView.findViewById(R.id.btnPhysC1);
        txtPhysC1 = (TextView) rootView.findViewById(R.id.txtPhysC1);

        btnPhysC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setVt(Double.parseDouble(physC1vt.getText().toString()));
                var.setRadius(Double.parseDouble(physC1r.getText().toString()));
                var.setAnsPhys(calc.physGetAc(var.getVt(), var.getRadius()));

                if (var.getAnsPhys() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtPhysC1.setText("a\uD835\uDCB8 = " + var.getAnsPhys());
                }
            }
        });
        return rootView;
    }
}
