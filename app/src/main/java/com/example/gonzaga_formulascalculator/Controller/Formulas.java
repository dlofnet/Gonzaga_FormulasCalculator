package com.example.gonzaga_formulascalculator.Controller;

import java.lang.Math;

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

    //formulas for geometry
    public double cylinderH(double v, double r) {
        return ((v) / ((Math.PI) * (r * r)));
    }

    public double cylinderV(double r, double h) {
        return ((Math.PI) * (r * r) * (h));
    }

    public double cylinderR(double v, double h) {
        return (Math.sqrt((v) / (Math.PI * h)));
    }

    public double torusV(double r, double R) {
        return ((Math.PI) * (r * r) * ((2) * (Math.PI) * (R)));
    }

    public double torusMajR(double v, double r) {
        return (((1/2) * v) * ((1 / (Math.PI * r)) * (1 / (Math.PI * r))));
    }

    public double torusA(double r, double R) {
        return ((2 * (Math.PI) * R) * (2 * (Math.PI) * r));
    }

    public double torusMinR(double a, double R) {
        return ((a) / (4 * (Math.PI * Math.PI) * R));
    }

    public double pyramidV(double l, double w, double h) {
        return ((l * w * h) / 3);
    }

    public double pyramidBL(double v, double w, double h) {
        return (3 * ((v) / (h * w)));
    }

    public double pyramidBW(double v, double l, double h) {
        return (3 * ((v) / (h * l)));
    }

    public double pyramidH(double v, double l, double w) {
        return (3 * ((v) / (w * l)));
    }
}