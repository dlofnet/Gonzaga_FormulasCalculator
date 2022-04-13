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

public class GeoCylinder2 extends Fragment {

    EditText geoC2r, geoC2h;
    Button btnGeoC2;
    TextView txtGeoC2;

    Variables var = new Variables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_geo_cylinder2, container, false);

        geoC2r = (EditText) rootView.findViewById(R.id.geoC2r);
        geoC2h = (EditText) rootView.findViewById(R.id.geoC2h);
        btnGeoC2 = (Button) rootView.findViewById(R.id.btnGeoC2);
        txtGeoC2 = (TextView) rootView.findViewById(R.id.txtGeoC2);

        btnGeoC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setGeoRadius(Double.parseDouble(geoC2r.getText().toString()));
                var.setHeight(Double.parseDouble(geoC2h.getText().toString()));
                var.setAnsGeo(calc.cylinderV(var.getGeoRadius(), var.getHeight()));

                if (var.getAnsGeo() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtGeoC2.setText("V = " + var.getAnsGeo());
                }
            }
        });
        return rootView;
    }
}