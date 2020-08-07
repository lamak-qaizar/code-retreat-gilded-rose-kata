package com.gildedrose;

public class Conjured extends InventoryItem {
    public Conjured(Item item) {
        super(item);
    }

    @Override
    protected void adjustDailyQuality() {
        this.stepDownQuality();
        this.stepDownQuality();
    }
}
