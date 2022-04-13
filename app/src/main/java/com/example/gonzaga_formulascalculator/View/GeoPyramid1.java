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

public class GeoPyramid1 extends Fragment {

    EditText geoP1l, geoP1w, geoP1h;
    Button btnGeoP1;
    TextView txtGeoP1;

    Variables var = new Variables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_geometry_pyramid1, container, false);

        geoP1l = (EditText) rootView.findViewById(R.id.geoP1l);
        geoP1w = (EditText) rootView.findViewById(R.id.geoP1w);
        geoP1h = (EditText) rootView.findViewById(R.id.geoP1h);
        btnGeoP1 = (Button) rootView.findViewById(R.id.btnGeoP1);
        txtGeoP1 = (TextView) rootView.findViewById(R.id.txtGeoP1);

        btnGeoP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setLength(Double.parseDouble(geoP1l.getText().toString()));
                var.setWidth(Double.parseDouble(geoP1w.getText().toString()));
                var.setHeight(Double.parseDouble(geoP1h.getText().toString()));
                var.setAnsPhys(calc.pyramidV(var.getLength(), var.getWidth(), var.getHeight()));

                if (var.getAnsPhys() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtGeoP1.setText("V = " + var.getAnsPhys());
                }
            }
        });
        return rootView;
    }
}