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

public class GeoTorus3 extends Fragment {

    EditText geoT3minr, geoT3majr;
    Button btnGeoT3;
    TextView txtGeoT3;

    Variables var = new Variables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_geometry_torus3, container, false);

        geoT3minr = (EditText) rootView.findViewById(R.id.geoT3minr);
        geoT3majr = (EditText) rootView.findViewById(R.id.geoT3majr);
        btnGeoT3 = (Button) rootView.findViewById(R.id.btnGeoT3);
        txtGeoT3 = (TextView) rootView.findViewById(R.id.txtGeoT3);

        btnGeoT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setMinR(Double.parseDouble(geoT3minr.getText().toString()));
                var.setMajR(Double.parseDouble(geoT3majr.getText().toString()));
                var.setAnsGeo(calc.torusA(var.getMinR(), var.getMajR()));

                if (var.getAnsGeo() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtGeoT3.setText("A = " + var.getAnsGeo());
                }
            }
        });
        return rootView;
    }
}