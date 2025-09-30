package com.example;


public class Circle implements Shape {
    private Draw2d draw2d;
    private Draw3d draw3d;

    Circle(Draw2d draw2d,Draw3d draw3d ){
        this.draw2d=draw2d;
        this.draw3d=draw3d;
    }
    @Override
    public String getShapeName() {
        return "circle";
    }

    @Override
    public void drawShape() {
        draw2d.draw(getShapeName());
        draw3d.draw(getShapeName());
    }
}
