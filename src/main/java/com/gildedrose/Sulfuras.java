package com.gildedrose;

public class Sulfuras extends InventoryItem {
    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    public void adjustDailyQuality() {
        this.incrementQualityBySingleStep();
    }

    @Override
    void adjustSellinDays() {
    }
}
