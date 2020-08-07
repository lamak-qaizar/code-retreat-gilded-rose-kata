package com.gildedrose;

public class InventoryItem {

    protected Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    protected void incrementQualityBySingleStep() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }


    protected void adjustDailyQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void stepSellInDay() {
        item.sellIn = item.sellIn - 1;
    }

    private boolean hasSellingDaysPassed() {
        return item.sellIn < 0;
    }

    protected void adjustQualityPostSellDate() {
        adjustDailyQuality();
    }

    private void adjustSellInDay() {
        stepSellInDay();

        if (hasSellingDaysPassed()) {
            adjustQualityPostSellDate();
        }
    }

    public void performDailyAdjustment() {
        adjustDailyQuality();
        adjustSellInDay();
    }
}
