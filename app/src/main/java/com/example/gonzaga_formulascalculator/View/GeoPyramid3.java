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

public class GeoPyramid3 extends Fragment {

    EditText geoP3l, geoP3v, geoP3h;
    Button btnGeoP3;
    TextView txtGeoP3;

    Variables var = new Variables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_geometry_pyramid3, container, false);

        geoP3l = (EditText) rootView.findViewById(R.id.geoP3l);
        geoP3v = (EditText) rootView.findViewById(R.id.geoP3v);
        geoP3h = (EditText) rootView.findViewById(R.id.geoP3h);
        btnGeoP3 = (Button) rootView.findViewById(R.id.btnGeoP3);
        txtGeoP3 = (TextView) rootView.findViewById(R.id.txtGeoP3);

        btnGeoP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setLength(Double.parseDouble(geoP3l.getText().toString()));
                var.setVolume(Double.parseDouble(geoP3v.getText().toString()));
                var.setHeight(Double.parseDouble(geoP3h.getText().toString()));
                var.setAnsPhys(calc.pyramidBW(var.getVolume(), var.getLength(), var.getHeight()));

                if (var.getAnsPhys() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtGeoP3.setText("V = " + var.getAnsPhys());
                }
            }
        });
        return rootView;
    }
}