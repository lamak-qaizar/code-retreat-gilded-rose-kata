package com.gildedrose;

public class InventoryItem {

    public Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    protected void incrementQualityBySingleStep() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }


    public void adjustDailyQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    void adjustSellinDays() {
        item.sellIn = item.sellIn - 1;
    }

    boolean hasSellingDaysPassed() {
        return item.sellIn < 0;
    }

    public void adjustQualityPostSellDate() {
        adjustDailyQuality();
    }
}
