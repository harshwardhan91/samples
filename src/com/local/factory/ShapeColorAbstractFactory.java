package com.local.factory;

public interface ShapeColorAbstractFactory {
    Shape getShape(String shapeTYpe);
    Color getColor(String colorType);
}
