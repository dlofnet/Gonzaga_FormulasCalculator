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

public class GeoTorus1 extends Fragment {

    EditText geoT1minr, geoT1majr;
    Button btnGeoT1;
    TextView txtGeoT1;

    Variables var = new Variables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_geometry_torus1, container, false);

        geoT1minr = (EditText) rootView.findViewById(R.id.geoT1minr);
        geoT1majr = (EditText) rootView.findViewById(R.id.geoT1majr);
        btnGeoT1 = (Button) rootView.findViewById(R.id.btnGeoT1);
        txtGeoT1 = (TextView) rootView.findViewById(R.id.txtGeoT1);

        btnGeoT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setMinR(Double.parseDouble(geoT1minr.getText().toString()));
                var.setMajR(Double.parseDouble(geoT1majr.getText().toString()));
                var.setAnsGeo(calc.torusV(var.getMinR(), var.getMajR()));

                if (var.getAnsGeo() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtGeoT1.setText("V = " + var.getAnsGeo());
                }
            }
        });
        return rootView;
    }
}