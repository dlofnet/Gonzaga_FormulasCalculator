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

public class GeoPyramid2 extends Fragment {

    EditText geoP2v, geoP2w, geoP2h;
    Button btnGeoP2;
    TextView txtGeoP2;

    Variables var = new Variables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_geometry_pyramid2, container, false);

        geoP2v = (EditText) rootView.findViewById(R.id.geoP2v);
        geoP2w = (EditText) rootView.findViewById(R.id.geoP2w);
        geoP2h = (EditText) rootView.findViewById(R.id.geoP2h);
        btnGeoP2 = (Button) rootView.findViewById(R.id.btnGeoP2);
        txtGeoP2 = (TextView) rootView.findViewById(R.id.txtGeoP2);

        btnGeoP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setVolume(Double.parseDouble(geoP2v.getText().toString()));
                var.setWidth(Double.parseDouble(geoP2w.getText().toString()));
                var.setHeight(Double.parseDouble(geoP2h.getText().toString()));
                var.setAnsPhys(calc.pyramidBL(var.getVolume(), var.getWidth(), var.getHeight()));

                if (var.getAnsPhys() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtGeoP2.setText("V = " + var.getAnsPhys());
                }
            }
        });

        return rootView;
    }
}
