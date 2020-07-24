package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (doesItemDegradeWithTime(item) && isQualityDegradable(item) && !isLegendaryItem(item)) {
                item.quality--;

            } else {
                if (isQualityUpgradable(item)) {

                    if (isBackstagePass(item)) {

                        if (item.sellIn < 6) {
                            item.quality = Math.min(MAX_QUALITY, item.quality + 3);
                        } else if (item.sellIn <= 10) {
                            item.quality = Math.min(MAX_QUALITY, item.quality + 2);
                        } else if (item.sellIn > 10) {
                            item.quality += 1;
                        }
                    }
                    else {
                        item.quality++;
                    }
                }
            }

            if (!isLegendaryItem(item)) {
                item.sellIn--;
            }

            if (isItemPassedSellInDate(item)) {
                if(isBackstagePass(item)){
                    item.quality = MIN_QUALITY;
                }
                else if (!item.name.equals(AGED_BRIE)) {
                    if (isQualityDegradable(item) && !isLegendaryItem(item)) {
                        item.quality--;
                    }
                } else {
                    if (isQualityUpgradable(item)) {
                        item.quality++;
                    }
                }
            }
        }
    }

    private boolean isItemPassedSellInDate(Item item) {
        return item.sellIn < 0;
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT);
    }

    private boolean isQualityUpgradable(Item item) {
        return item.quality < MAX_QUALITY;
    }

    private boolean doesItemDegradeWithTime(Item item) {
        return !item.name.equals(AGED_BRIE)
                && !isBackstagePass(item);
    }

    private boolean isQualityDegradable(Item item) {
        return item.quality > MIN_QUALITY;
    }

    private boolean isLegendaryItem(Item item) {
        return item.name.equals(SULFURAS_HAND_OF_RAGNAROS);
    }
}