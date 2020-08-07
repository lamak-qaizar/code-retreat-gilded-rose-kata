package com.gildedrose;

public class BackstagePasses extends InventoryItem {

    public BackstagePasses(Item item) {
        super(item);
    }

    static void adjustDailyQualityForBackstage(InventoryItem inventoryItem) {

    }

    @Override
    public void adjustDailyQuality() {
        incrementQualityBySingleStep(this);

        if (item.sellIn < 11) {
            incrementQualityBySingleStep(this);
        }

        if (this.item.sellIn < 6) {
            incrementQualityBySingleStep(this);
        }
    }
}
