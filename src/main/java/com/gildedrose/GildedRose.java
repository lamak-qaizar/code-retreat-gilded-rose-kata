package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void adjustDailyQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    public void updateQuality() {
        for (Item item : items) {

            if (item.isBackstage()) {
                adjustDailyQualityForBackstage(item);
            } else if (item.isAgedBrie()) {
                adjustDailyQualityForAgedBrie(item);
            } else if (item.isSulfuras()) {
                adjustDailyQualityForSulfuras(item);
            } else {
                adjustDailyQuality(item);
            }

            if (!item.isSulfuras()) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.isAgedBrie()) {
                    if (!item.isBackstage()) {
                        if (item.quality > 0) {
                            if (!item.isSulfuras()) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    incrementQualityBySingleStep(item);
                }
            }
        }
    }

    private void adjustDailyQualityForSulfuras(Item item) {
        incrementQualityBySingleStep(item);
    }

    private void adjustDailyQualityForAgedBrie(Item item) {
        incrementQualityBySingleStep(item);
    }

    private void adjustDailyQualityForBackstage(Item item) {
        incrementQualityBySingleStep(item);

        if (item.sellIn < 11) {
            incrementQualityBySingleStep(item);
        }

        if (item.sellIn < 6) {
            incrementQualityBySingleStep(item);
        }
    }

    private void incrementQualityBySingleStep(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

}