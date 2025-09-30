package com.example;

public class Square implements Shape {
    private Draw2d draw2d;
    private Draw3d draw3d;
    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public void drawShape() {
        draw2d.draw(getShapeName());
        draw3d.draw(getShapeName());
    }

    public void setDraw2d(Draw2d draw2d) {
        this.draw2d = draw2d;
    }

    public void setDraw3d(Draw3d draw3d) {
        this.draw3d = draw3d;
    }
}
