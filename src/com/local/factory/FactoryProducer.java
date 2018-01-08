package com.local.factory;

public class FactoryProducer {
    public ShapeColorAbstractFactory getFactory(String factoryType){
        if (factoryType != null) {
            switch (factoryType) {
                case "SHAPE": return new ShapeFactory();
                case "COLOR":return new ColorFactory();
                default:return null;
            }
        }
        return null;
    }
}
