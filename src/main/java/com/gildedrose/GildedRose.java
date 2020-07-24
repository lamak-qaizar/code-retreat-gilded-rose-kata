package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(ItemType.AGED_BRIE)
                    && !items[i].name.equals(ItemType.BACKSTAGE_PASSES)) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals(ItemType.SULFURAS)) {
                        items[i].quality -= 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality += 1;

                    if (items[i].name.equals(ItemType.BACKSTAGE_PASSES)) {
                        increaseConcertQualityUnder10Days(i);

                        if (items[i].sellIn < 6) {
                            increaseQualityUntilMax(i);
                        }
                    }
                }
            }

            if (!items[i].name.equals(ItemType.SULFURAS)) {
                items[i].sellIn -= 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(ItemType.AGED_BRIE)) {
                    if (!items[i].name.equals(ItemType.BACKSTAGE_PASSES)) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(ItemType.SULFURAS)) {
                                items[i].quality -= 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    private void increaseConcertQualityUnder10Days(int i) {
        if (items[i].sellIn < 11) {
            increaseQualityUntilMax(i);
        }
    }

    private void increaseQualityUntilMax(int i) {
        if (items[i].quality < 50) {
            items[i].quality += 1;
        }
    }
}