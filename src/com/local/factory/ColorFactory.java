package com.local.factory;

public class ColorFactory implements ShapeColorAbstractFactory {
    public Color getColor(String colorType){
        if (colorType != null) {
            switch (colorType) {
                case "RED" : return new RedColor();
                case "BLUE" : return new BlueColor();
                default:return null;
            }
        }
        return null;
    }

    @Override
    public Shape getShape(String shapeTYpe) {
        return null;
    }
}
