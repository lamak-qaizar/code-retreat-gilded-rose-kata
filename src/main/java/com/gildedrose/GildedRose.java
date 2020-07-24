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
            Item item = items[i];
            if (!item.name.equals(ItemType.AGED_BRIE)
                    && !item.name.equals(ItemType.BACKSTAGE_PASSES)) {
                degradeQualityUntilMinimum(item);
            } else {
                increaseQualityUntilMax(item);

                if (item.quality < MAXIMUM_QUALITY_SCORE && item.name.equals(ItemType.BACKSTAGE_PASSES)) {
                    increaseConcertQualityUnder10Days(item);
                    increasePercentQualityUnderNDays(item, 5);
                }
            }

            if (!item.name.equals(ItemType.SULFURAS)) {
                item.sellIn -= 1;
            }

            if (item.sellIn < 0) {
                if (item.name.equals(ItemType.AGED_BRIE)) {
                    if (item.quality < MAXIMUM_QUALITY_SCORE) {
                        item.quality += 1;
                    }
                } else {
                    if (item.name.equals(ItemType.BACKSTAGE_PASSES)) {
                        item.quality = MINIMUM_QUALITY_SCORE;
                    } else {
                        degradeQualityUntilMinimum(item);
                    }
                }
            }
        }
    }

    private static void degradeQualityUntilMinimum(Item item) {
        if (item.quality > MINIMUM_QUALITY_SCORE && !item.name.equals(ItemType.SULFURAS)) {
            item.quality -= 1;
        }
    }

    private static void increasePercentQualityUnderNDays(Item item, int noOfDays) {
        if (item.sellIn <= noOfDays) {
            increaseQualityUntilMax(item);
        }
    }

    private static void increaseConcertQualityUnder10Days(Item item) {
        increasePercentQualityUnderNDays(item, 10);
    }

    private static void increaseQualityUntilMax(Item item) {
        if (item.quality < MAXIMUM_QUALITY_SCORE) {
            item.quality += 1;
        }
    }
}
