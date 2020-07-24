package com.gildedrose;

class GildedRose {

    public static final int MINIMUM_QUALITY_SCORE = 0;
    public static final int MAXIMUM_QUALITY_SCORE = 50;


    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(ItemType.AGED_BRIE)
                    && !items[i].name.equals(ItemType.BACKSTAGE_PASSES)) {
                if (items[i].quality > MINIMUM_QUALITY_SCORE) {
                    if (!items[i].name.equals(ItemType.SULFURAS)) {
                        items[i].quality -= 1;
                    }
                }
            } else {
                if (items[i].quality < MAXIMUM_QUALITY_SCORE) {
                    items[i].quality += 1;

                    if (items[i].name.equals(ItemType.BACKSTAGE_PASSES)) {
                        increaseConcertQualityUnder10Days(i);

                        increasePercentQualityUnder5Days(i, 6);
                    }
                }
            }

            if (!items[i].name.equals(ItemType.SULFURAS)) {
                items[i].sellIn -= 1;
            }

            if (items[i].sellIn < 0) {
                if (items[i].name.equals(ItemType.AGED_BRIE)) {
                    if (items[i].quality < MAXIMUM_QUALITY_SCORE) {
                        items[i].quality += 1;
                    }
                } else {
                    if (items[i].name.equals(ItemType.BACKSTAGE_PASSES)) {
                        items[i].quality = MINIMUM_QUALITY_SCORE;
                    } else {
                        if (items[i].quality > MINIMUM_QUALITY_SCORE) {
                            if (!items[i].name.equals(ItemType.SULFURAS)) {
                                items[i].quality -= 1;
                            }
                        }
                    }
                }
            }
        }
    }

    private void increasePercentQualityUnder5Days(int i, int i2) {
        if (items[i].sellIn < i2) {
            increaseQualityUntilMax(i);
        }
    }

    private void increaseConcertQualityUnder10Days(int i) {
        increasePercentQualityUnder5Days(i, 11);
    }

    private void increaseQualityUntilMax(int i) {
        if (items[i].quality < 50) {
            items[i].quality += 1;
        }
    }
}
