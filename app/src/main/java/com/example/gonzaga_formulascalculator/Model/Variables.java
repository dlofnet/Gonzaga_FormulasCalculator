package com.example.gonzaga_formulascalculator.Model;

public class Variables {

    //physics variables
    private double ansPhys;
    private double x, x1, x2, d, t;
    private double vt, w, a, radius;
    private double vx, v1y, g;

    //physics setters
    public void setX1(double x1) { this.x1 = x1; }
    public void setX2(double x2) { this.x2 = x2; }
    public void setAnsPhys(double ansPhys) { this.ansPhys = ansPhys; }
    public void setX(double x) { this.x = x; }
    public void setD(double d) { this.d = d; }
    public void setT(double t) { this.t = t; }
    public void setVt(double vt) { this.vt = vt; }
    public void setRadius(double radius) { this.radius = radius; }
    public void setW(double w) { this.w = w; }
    public void setA(double a) { this.a = a; }
    public void setVx(double vx) { this.vx = vx; }
    public void setV1y(double v1y) { this.v1y = v1y; }
    public void setG(double g) { this.g = g; }

    //physics getters
    public double getX1() { return x1; }
    public double getX2() { return x2; }
    public double getAnsPhys() { return ansPhys; }
    public double getX() { return x; }
    public double getD() { return d; }
    public double getT() { return t; }
    public double getVt() { return vt; }
    public double getRadius() { return radius; }
    public double getW() { return w; }
    public double getA() { return a; }
    public double getVx() { return vx; }
    public double getV1y() { return v1y; }
    public double getG() { return g; }

    //geometry variables
    private double volume, geoRadius, minR, majR, length, width, height, area, ansGeo;

    //geometry setters
    public void setVolume(double volume) { this.volume = volume; }
    public void setGeoRadius(double geoRadius) { this.geoRadius = geoRadius; }
    public void setMinR(double minR) { this.minR = minR; }
    public void setMajR(double majR) { this.majR = majR; }
    public void setLength(double length) { this.length = length; }
    public void setWidth(double width) { this.width = width; }
    public void setHeight(double height) { this.height = height; }
    public void setArea(double area) { this.area = area; }
    public void setAnsGeo(double ansGeo) { this.ansGeo = ansGeo; }

    //geometry getters
    public double getVolume() { return volume; }
    public double getGeoRadius() { return geoRadius; }
    public double getMinR() { return minR; }
    public double getMajR() { return majR; }
    public double getLength() { return length; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public double getArea() { return area; }
    public double getAnsGeo() { return ansGeo; }
}
