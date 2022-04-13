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

public class GeoCylinder3 extends Fragment {

    EditText geoC3v, geoC3h;
    Button btnGeoC3;
    TextView txtGeoC3;

    Variables var = new Variables();
    Formulas calc = new Formulas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_geo_cylinder3, container, false);

        geoC3v = (EditText) rootView.findViewById(R.id.geoC3v);
        geoC3h = (EditText) rootView.findViewById(R.id.geoC3h);
        btnGeoC3 = (Button) rootView.findViewById(R.id.btnGeoC3);
        txtGeoC3 = (TextView) rootView.findViewById(R.id.txtGeoC3);

        btnGeoC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setVolume(Double.parseDouble(geoC3v.getText().toString()));
                var.setHeight(Double.parseDouble(geoC3h.getText().toString()));
                var.setAnsGeo(calc.cylinderR(var.getVolume(), var.getHeight()));

                if (var.getAnsGeo() < 0) {
                    Snackbar snackbar = Snackbar
                            .make(rootView, "Invalid input. Please try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                } else {
                    txtGeoC3.setText("V = " + var.getAnsGeo());
                }
            }
        });
        return rootView;
    }
}