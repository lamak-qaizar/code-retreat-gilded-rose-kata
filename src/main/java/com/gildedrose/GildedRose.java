package com.gildedrose;

import com.gildedrose.item.OrdinaryItem;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ((OrdinaryItem) item).update();
        }
    }
}