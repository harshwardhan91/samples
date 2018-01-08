package com.local.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    List<Item> itemList = new ArrayList<>();
    public void addItem(Item item){
        itemList.add(item);
    }
    public float getCost(){
        float f = 0f;
        for (Item item : itemList) {
            f+=item.price();
        }
        return f;
    }

    public void showItems(){
        for (Item item : itemList) {
            System.out.print("name " + item.name());
            System.out.print("cost " + item.price());
            System.out.println("packing " + item.packing().pack());
        }
    }
}
