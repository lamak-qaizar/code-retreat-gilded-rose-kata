package com.gildedrose;

class GildedRose {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
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
            if (normalItem(item)) {
                if (item.quality > 0) {
                    decrementQuality(item);
                }
            } else {
                if (qualityIsNotMaximum(item)) {
                    incrementQuality(item);

                    if (item.name.equals(BACKSTAGE_PASSES)) {
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

            decrementSellIn(item);

            if (expired(item)) {
                if (normalItem(item)){
                    if(item.quality > 0){
                        decrementQuality(item);
                    }
                }

                if (item.name.equals(BACKSTAGE_PASSES)) {
                    setQualitytoZero(item);
                }

                if (item.name.equals(AGED_BRIE)) {
                    if (qualityIsNotMaximum(item)) {
                        incrementQuality(item);
                    }
                }
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
        item.quality = item.quality - 1;
    }
}