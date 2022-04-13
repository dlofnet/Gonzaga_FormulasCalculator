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

public class GeoCylinder1 extends Fragment {

    EditText geoC1v, geoC1r;
    Button btnGeoC1;
    TextView txtGeoC1;

    Variables var = new Variables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_geo_cylinder1, container, false);

        geoC1v = (EditText) rootView.findViewById(R.id.geoC1v);
        geoC1r = (EditText) rootView.findViewById(R.id.geoC1r);
        btnGeoC1 = (Button) rootView.findViewById(R.id.btnGeoC1);
        txtGeoC1 = (TextView) rootView.findViewById(R.id.txtGeoC1);

        btnGeoC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setVolume(Double.parseDouble(geoC1v.getText().toString()));
                var.setGeoRadius(Double.parseDouble(geoC1r.getText().toString()));
                var.setAnsGeo(calc.cylinderH(var.getVolume(), var.getGeoRadius()));

                if (var.getAnsGeo() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtGeoC1.setText("h = " + var.getAnsGeo());
                }
            }
        });
        return rootView;
    }
}