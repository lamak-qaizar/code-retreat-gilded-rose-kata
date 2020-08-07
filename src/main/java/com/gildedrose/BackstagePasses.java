package com.gildedrose;

public class BackstagePasses extends InventoryItem {

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    protected void adjustDailyQuality() {
        this.stepUpQuality();

        if (item.sellIn < 11) {
            this.stepUpQuality();
        }

        if (this.item.sellIn < 6) {
            this.stepUpQuality();
        }
    }

    @Override
    protected void adjustQualityPostSellDate() {
        item.quality = 0;
    }
}
