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
                if (item.isAgedBrie()) {
                    inventoryItem.incrementQualityBySingleStep();
                } else {
                    if (item.isBackstage()) {
                        item.quality = 0;
                    } else {
                        if (item.quality > 0) {
                            if (!item.isSulfuras()) {
                                item.quality = item.quality - 1;
                            }
                        }
                    }
                }
            }
        }
    }

}