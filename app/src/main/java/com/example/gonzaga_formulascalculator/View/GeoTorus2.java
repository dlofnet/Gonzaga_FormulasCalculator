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

public class GeoTorus2 extends Fragment {

    EditText geoT2minr, geoT2v;
    Button btnGeoT2;
    TextView txtGeoT2;

    Variables var = new Variables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_geometry_torus2, container, false);

        geoT2minr = (EditText) rootView.findViewById(R.id.geoT2minr);
        geoT2v = (EditText) rootView.findViewById(R.id.geoT2v);
        btnGeoT2 = (Button) rootView.findViewById(R.id.btnGeoT2);
        txtGeoT2 = (TextView) rootView.findViewById(R.id.txtGeoT2);

        btnGeoT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setMinR(Double.parseDouble(geoT2minr.getText().toString()));
                var.setVolume(Double.parseDouble(geoT2v.getText().toString()));
                var.setAnsGeo(calc.torusMajR(var.getVolume(), var.getMinR()));

                if (var.getAnsGeo() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtGeoT2.setText("R = " + var.getAnsGeo());
                }
            }
        });
        return rootView;
    }
}