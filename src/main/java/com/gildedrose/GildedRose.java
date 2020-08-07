package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            InventoryItem inventoryItem = InventoryItemFactory.createFor(item);

            inventoryItem.adjustDailyQuality();
            inventoryItem.adjustSellinDays();

            if (inventoryItem.hasSellingDaysPassed()) {
                inventoryItem.adjustQualityPostSellDate();
            }
        }
    }


}