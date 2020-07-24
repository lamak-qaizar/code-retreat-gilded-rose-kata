package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        decrementQuality(item);
                    }
                }
            } else {
                if (qualityIsNotMaximum(item)) {
                    incrementQuality(item);

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (qualityIsNotMaximum(item)) {
                                incrementQuality(item);
                            }
                        }

                        if (item.sellIn < 6) {
                            if (qualityIsNotMaximum(item)) {
                                incrementQuality(item);
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                decrementSellIn(item);
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                decrementQuality(item);
                            }
                        }
                    } else {
                        setQualitytoZero(item);
                    }
                } else {
                    if (qualityIsNotMaximum(item)) {
                        incrementQuality(item);
                    }
                }
            }
        }
    }

    private boolean qualityIsNotMaximum(Item item) {
        return item.quality < 50;
    }

    private void setQualitytoZero(Item item) {
        item.quality = 0;
    }

    private void decrementSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void incrementQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private void decrementQuality(Item item) {
        item.quality = item.quality - 1;
    }
}