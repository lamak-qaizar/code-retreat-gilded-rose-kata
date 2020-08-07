package com.gildedrose;

public class AgedBrie extends InventoryItem {
    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void adjustDailyQuality() {
        this.stepUpQuality();
    }

    @Override
    protected void adjustQualityPostSellDate() {
        this.stepUpQuality();
    }
}
