package com.gildedrose;

public class AgedBrie extends InventoryItem {
    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void adjustDailyQuality() {
        this.incrementQualityBySingleStep();
    }

    @Override
    protected void adjustQualityPostSellDate() {
        this.incrementQualityBySingleStep();
    }
}
