package com.gildedrose;

public class InventoryItem {

    public Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    static void incrementQualityBySingleStep(InventoryItem inventoryItem) {
        if (inventoryItem.item.quality < 50) {
            inventoryItem.item.quality = inventoryItem.item.quality + 1;
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
}
