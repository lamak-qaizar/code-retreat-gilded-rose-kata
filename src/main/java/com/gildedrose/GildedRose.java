package com.gildedrose;

class GildedRose {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            Item item = items[i];

            if (item.name.equals(SULFURAS)) {
                if (item.sellIn > 0) {
                    decrementSellIn(item);
                }
                continue;
            }

            if (item.name.equals(CONJURED_MANA_CAKE)) {
                decrementSellIn(item);
                decrementQualityByTwo(item);
                if (expired(item)) {
                    decrementQualityByTwo(item);
                }
                continue;
            }

            if (normalItem(item)) {
                decrementQuality(item);
            }

            if (item.name.equals(AGED_BRIE)) {
                if (qualityIsNotMaximum(item)) {
                    incrementQuality(item);
                }
            }

            if (item.name.equals(BACKSTAGE_PASSES)) {
                if (qualityIsNotMaximum(item)) {
                    incrementQuality(item);
                    increaseBackstagePassesQuality(item);
                }
            }

            decrementSellIn(item);

            if (normalItem(item) && expired(item)) {
                decrementQuality(item);
            }

            if (item.name.equals(BACKSTAGE_PASSES) && expired(item)) {
                setQualitytoZero(item);
            }

            if (item.name.equals(AGED_BRIE) && expired(item)) {
                if (qualityIsNotMaximum(item)) {
                    incrementQuality(item);
                }
            }

        }
    }

    private void increaseBackstagePassesQuality(Item item) {
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

    private boolean normalItem(Item item) {
        return !item.name.equals(AGED_BRIE)
                && !item.name.equals(BACKSTAGE_PASSES);
    }

    private boolean expired(Item item) {
        return item.sellIn < 0;
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
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void decrementQualityByTwo(Item item) {
        decrementQuality(item);
        decrementQuality(item);
    }
}