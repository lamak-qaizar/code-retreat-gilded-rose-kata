package com.gildedrose;

public class Sulfuras extends InventoryItem {
    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    public void adjustDailyQuality() {
        this.stepUpQuality();
    }

    @Override
    protected void stepSellInDay() {
    }

    @Override
    protected void adjustQualityPostSellDate() {

    }
}
