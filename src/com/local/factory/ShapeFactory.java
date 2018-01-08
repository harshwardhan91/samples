package com.local.factory;

public class ShapeFactory implements ShapeColorAbstractFactory{
    public Shape getShape(String shapeType){
        if (shapeType != null) {
            switch (shapeType) {
                case "Rect" : return new Rectangle();
                case "Circ" : return new Circle();
                default:return null;
            }
        }
        return null;
    }

    @Override
    public Color getColor(String colorType) {
        return null;
    }
}
