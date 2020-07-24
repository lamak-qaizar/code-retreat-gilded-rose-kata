package com.gildedrose;

public class BackStage extends Item {


    public BackStage(Item item){
        super(item.name(), item.sellIn(), item.quality);
    }
}
