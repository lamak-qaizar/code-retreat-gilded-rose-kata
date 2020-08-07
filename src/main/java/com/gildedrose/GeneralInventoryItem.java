package com.gildedrose;

public class GeneralInventoryItem extends InventoryItem {

    public GeneralInventoryItem(Item item) {
        super(item);
    }


    public void adjustDailyQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
