package com.local.factory;

public class ShapeMain {

    static class Sample{
        Integer a;

        public Sample(Integer i) {
            a = i;
        }
    }
    public static void main(String[] args) {
       /* ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("Rect");
        if (shape != null) {
            shape.draw();
        }else{
            System.out.println("Shape type null");
        }

        ShapeColorAbstractFactory shapeColorAbstractFactory = new FactoryProducer().getFactory("SHAPE");
        Shape rect = shapeColorAbstractFactory.getShape("Rect");
        rect.draw();*/
/*
        Sample sample = new Sample(5);
        Integer b =  sample.a;
        sample.a = null;
        System.out.println(b);*/


        int i = 0;
        retry:
        for (;;) {
            System.out.println("i = " + i++);
            if(i==5 ) break retry;
        }
       /**
        outer:                   should be placed exactly before the loop
        loopingConstructOne  {   we can have statements before the outer but not inbetween the label and the loop
            inner:
            loopingConstructTwo {
                continue;       //goes to the top of loopingConstructTwo and continue
                break;          //breaks out of loopingConstructTwo
                continue outer; //goes to the outer label and reenters loopingConstructOne
                break outer;    //breaks out of the loopingConstructOne
                continue inner; //this will behave similar to continue
            }
        }*/
    }
}
