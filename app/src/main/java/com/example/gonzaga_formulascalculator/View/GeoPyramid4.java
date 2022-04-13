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

public class GeoPyramid4 extends Fragment {

    EditText geoP4l, geoP4w, geoP4v;
    Button btnGeoP4;
    TextView txtGeoP4;

    Variables var = new Variables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_geometry_pyramid4, container, false);

        geoP4l = (EditText) rootView.findViewById(R.id.geoP4l);
        geoP4w = (EditText) rootView.findViewById(R.id.geoP4w);
        geoP4v = (EditText) rootView.findViewById(R.id.geoP4v);
        btnGeoP4 = (Button) rootView.findViewById(R.id.btnGeoP4);
        txtGeoP4 = (TextView) rootView.findViewById(R.id.txtGeoP4);

        btnGeoP4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setLength(Double.parseDouble(geoP4l.getText().toString()));
                var.setWidth(Double.parseDouble(geoP4w.getText().toString()));
                var.setVolume(Double.parseDouble(geoP4v.getText().toString()));
                var.setAnsPhys(calc.pyramidH(var.getVolume(), var.getLength(), var.getWidth()));

                if (var.getAnsPhys() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtGeoP4.setText("V = " + var.getAnsPhys());
                }
            }
        });
        return rootView;
    }
}