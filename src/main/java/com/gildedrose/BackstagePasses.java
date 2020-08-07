package com.gildedrose;

public class BackstagePasses extends InventoryItem {

    public BackstagePasses(Item item) {
        super(item);
    }

    static void adjustDailyQualityForBackstage(InventoryItem inventoryItem) {

    }

    @Override
    public void adjustDailyQuality() {
        this.incrementQualityBySingleStep();

        if (item.sellIn < 11) {
            this.incrementQualityBySingleStep();
        }

        if (this.item.sellIn < 6) {
            this.incrementQualityBySingleStep();
        }
    }
}
