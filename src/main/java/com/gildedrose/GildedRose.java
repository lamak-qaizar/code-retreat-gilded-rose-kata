package com.gildedrose;
class GildedRose {
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (isAged_brie(items[i])) {
                items[i].quality = increaseQualityBy(items[i].quality, 1);
            } else if (isBackstage(items[i])) {
                items[i].quality = increaseQualityBy(items[i].quality, 1);
                incrementBackStageQualitySpecificToSellinDates(items[i]);
            } else if (isSulfuras(items[i])) {
                items[i].quality = increaseQualityBy(items[i].quality, 1);
            } else {
                items[i].quality = decreaseQualityBy(items[i].quality, 1);
            }
            adjustSellinDays(items[i]);
            if (items[i].sellIn < 0 && !isSulfuras(items[i])) {
                if (isAged_brie(items[i])) {
                    increaseAgedBrieQuality(i);
                }
                else if (isBackstage(items[i])) {
                    setBackStageQualityToZero(i);
                }
                else {
                    items[i].quality = decreaseQualityBy(items[i].quality, 1);
                }
            }
        }
    }
    private void setBackStageQualityToZero(int i) {
        items[i].quality = 0;
    }
    private void increaseAgedBrieQuality(int i) {
        items[i].quality = increaseQualityBy(items[i].quality, 1);
    }
    private void adjustSellinDays(Item item) {
        if (!isSulfuras(item)) {
            item.sellIn = item.sellIn - 1;
        }
    }
    private void incrementBackStageQualitySpecificToSellinDates(Item item) {
        if (item.sellIn < 11) {
            item.quality = increaseQualityBy(item.quality, 1);
        }
        if (item.sellIn < 6) {
            item.quality = increaseQualityBy(item.quality, 1);
        }
    }
    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }
    private boolean isBackstage(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }
    private boolean isAged_brie(Item item) {
        return item.name.equals("Aged Brie");
    }
    private int decreaseQualityBy(int quality, int offset) {
        if (quality > 0) {
            return quality - offset;
        }
        return quality;
    }
    private int increaseQualityBy(int quality, int offset) {
        if (quality < 50) return quality+offset;
        return quality;
    }
}