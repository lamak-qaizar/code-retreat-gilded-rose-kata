package com.gildedrose;
class GildedRose {
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if (!isAged_brie(items[i]) && !isBackstage(items[i] ) && !isSulfuras(items[i])) {

                        items[i].quality = decreaseQualityBy(items[i].quality, 1);


            } else {
                if (items[i].quality < 50) {
                    items[i].quality = increaseQualityBy(items[i].quality, 1);
                    if (isBackstage(items[i])) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = increaseQualityBy(items[i].quality, 1);
                            }
                        }
                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = increaseQualityBy(items[i].quality, 1);
                            }
                        }
                    }
                }
            }
            if (!isSulfuras(items[i])) {
                items[i].sellIn = items[i].sellIn - 1;
            }
            if (items[i].sellIn < 0) {
                if (!isAged_brie(items[i])) {
                    if (!isBackstage(items[i])) {
                            if (!isSulfuras(items[i])) {
                                items[i].quality = decreaseQualityBy(items[i].quality, 1);
                            }

                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = increaseQualityBy(items[i].quality, 1);
                    }
                }
            }
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
        return quality + offset;
    }
}