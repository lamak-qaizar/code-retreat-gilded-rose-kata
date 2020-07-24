package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (nameNotEqual(items[i], Constant.AGED_BRIE)
                    && nameNotEqual(items[i], Constant.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)
                    && items[i].quality > 0
                    && nameNotEqual(items[i], Constant.SULFURAS_HAND_OF_RAGNAROS)) {
                items[i].quality = items[i].quality - 1;

                if (isSellInLessThan(items[i].sellIn, 0) && items[i].quality > 0)
                    items[i].quality = items[i].quality - 1;


            } else {
                if (isQualityLessThan50(items[i].quality, 50)) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals(Constant.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)
                            && isSellInLessThan(items[i].sellIn, 11)
                            && isQualityLessThan50(items[i].quality, 50)) {
                        items[i].quality = items[i].quality + 1;

                        if (isSellInLessThan(items[i].sellIn, 6) && isQualityLessThan50(items[i].quality, 50)) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }
                }
            }

            if (nameNotEqual(items[i], Constant.SULFURAS_HAND_OF_RAGNAROS)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (isSellInLessThan(items[i].sellIn, 0)) {
                if (nameNotEqual(items[i], Constant.AGED_BRIE)) {
                    if (nameNotEqual(items[i], Constant.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        if (items[i].quality > 0 && nameNotEqual(items[i], Constant.SULFURAS_HAND_OF_RAGNAROS)) {
                            items[i].quality = items[i].quality - 1;
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (isQualityLessThan50(items[i].quality, 50)) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    private boolean isSellInLessThan(int sellIn, int value) {
        return sellIn < value;
    }

    private boolean isQualityLessThan50(int quality, int value) {
        return quality < value;
    }

    private boolean nameNotEqual(Item item, String agedBrie) {
        return !item.name.equals(agedBrie);
    }

}