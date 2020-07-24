package com.gildedrose;

public class ItemFactory {

    public static Item of(Item item){
        if(item.name().equals(ItemName.BACKSTAGE.getName())){
            return new BackStage(item);
        }
        return item;
    }
}
