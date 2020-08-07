package com.gildedrose;

public class InventoryItem {

    protected Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    public void performDailyAdjustment() {
        adjustDailyQuality();
        adjustSellInDay();
    }

    protected void stepUpQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    protected void stepDownQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private boolean hasSellingDaysPassed() {
        return item.sellIn < 0;
    }

    private void adjustSellInDay() {
        stepSellInDay();

        if (hasSellingDaysPassed()) {
            adjustQualityPostSellDate();
        }
    }

    protected void adjustDailyQuality() {
        stepDownQuality();
    }


    protected void stepSellInDay() {
        item.sellIn = item.sellIn - 1;
    }

    protected void adjustQualityPostSellDate() {
        stepDownQuality();
    }

}
