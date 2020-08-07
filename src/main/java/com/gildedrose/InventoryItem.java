package com.gildedrose;

public abstract class InventoryItem {

    public Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    static void incrementQualityBySingleStep(InventoryItem inventoryItem) {
        if (inventoryItem.item.quality < 50) {
            inventoryItem.item.quality = inventoryItem.item.quality + 1;
        }
    }

    public abstract void adjustDailyQuality();
}
