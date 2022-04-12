package com.example.gonzaga_formulascalculator.Controller;

public class Formulas {

    //formulas for physics
    public double physGetD(double x2, double x1) {
        return (x2 - x1);
    }

    public double physGetV(double d, double t, double x) {
        return ((d * x) / (d * t));
    }

    public double physGetA(double d, double t, double x) {
        return ((d * d) * x) / (d * (t * t));
    }

    public double physGetAc(double vt, double r) {
        return ((vt * vt) / r);
    }

    public double physGetVt(double w, double r) {
        return (w * r);
    }

    public double physGetAt(double a, double r) {
        return (a * r);
    }

    public double physGetDx(double vx, double t) {
        return (vx * t);
    }

    public double physGetDy(double v1y, double t, double g) {
        return ((v1y * t) - ((0.5) * (g * (t * t))));
    }

    public double physGetV2y(double v1y, double t, double g) {
        return (v1y - (g * t));
    }
}
