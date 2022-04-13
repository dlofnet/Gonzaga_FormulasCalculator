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

public class GeoTorus4 extends Fragment {

    EditText geoT4majr, geoT4a;
    Button btnGeoT4;
    TextView txtGeoT4;

    Variables var = new Variables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_geometry_torus4, container, false);

        geoT4majr = (EditText) rootView.findViewById(R.id.geoT4majr);
        geoT4a = (EditText) rootView.findViewById(R.id.geoT4a);
        btnGeoT4 = (Button) rootView.findViewById(R.id.btnGeoT4);
        txtGeoT4 = (TextView) rootView.findViewById(R.id.txtGeoT4);

        btnGeoT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setMajR(Double.parseDouble(geoT4majr.getText().toString()));
                var.setArea(Double.parseDouble(geoT4a.getText().toString()));
                var.setAnsGeo(calc.torusMinR(var.getArea(), var.getMajR()));

                if (var.getAnsGeo() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtGeoT4.setText("r = " + var.getAnsGeo());
                }
            }
        });
        return rootView;
    }
}