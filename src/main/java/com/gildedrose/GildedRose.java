package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (item.isBackstage()) {
                incrementQualityForBackstage(item);
            } else if (item.isAgedBrie() || item.isSulfuras()) {
                incrementQualityBySingleStep(item);
            } else {
                item.reduceQualityBySingleStep();
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

    private void incrementQualityForBackstage(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                incrementQualityBySingleStep(item);
            }

            if (item.sellIn < 6) {
                incrementQualityBySingleStep(item);
            }

        }
    }

    private void incrementQualityBySingleStep(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

}