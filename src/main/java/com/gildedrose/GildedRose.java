package com.gildedrose;

class GildedRose {
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item currentItem = items[i];
            if (isSpecialItem(currentItem)) {
                currentItem.quality = currentItem.quality - 1;
            } else {
                handleQualityForNormalItem(currentItem);
            }
            sellInForLagendryItem(currentItem);

            qualityDecreaseForNormalItem(currentItem);

            handleNegativeSellInCases(currentItem);
        }
    }

    private boolean isSpecialItem(Item currentItem) {
        return nameNotEqual(currentItem, Constant.AGED_BRIE)
                && nameNotEqual(currentItem, Constant.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)
                && qualityGreaterThan(currentItem)
                && nameNotEqual(currentItem, Constant.SULFURAS_HAND_OF_RAGNAROS);
    }

    private void handleQualityForNormalItem(Item currentItem) {
        if (isQualityLessThan50(currentItem.quality, 50)) {
            currentItem.quality = currentItem.quality + 1;
            if (currentItem.name.equals(Constant.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)
                    && isSellInLessThan(currentItem.sellIn, 11)
                    && isQualityLessThan50(currentItem.quality, 50)) {
                currentItem.quality = currentItem.quality + 1;
                if (isSellInLessThan(currentItem.sellIn, 6) && isQualityLessThan50(currentItem.quality, 50)) {
                    currentItem.quality = currentItem.quality + 1;
                }
            }
        }
    }

    private void sellInForLagendryItem(Item currentItem) {
        if (nameNotEqual(currentItem, Constant.SULFURAS_HAND_OF_RAGNAROS)) {
            currentItem.sellIn = currentItem.sellIn - 1;
        }
    }

    private void handleNegativeSellInCases(Item currentItem) {
        if (isSellInLessThan(currentItem.sellIn, 0)) {
            if (nameEqual(currentItem, Constant.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                currentItem.quality = 0;
            }
            if (nameEqual(currentItem, Constant.AGED_BRIE)
                    && isQualityLessThan50(currentItem.quality, 50)) {
                currentItem.quality = currentItem.quality + 1;
            }
        }
    }

    private void qualityDecreaseForNormalItem(Item currentItem) {
        if (isSellInLessThan(currentItem.sellIn, 0)
                && nameNotEqual(currentItem, Constant.AGED_BRIE)
                && nameNotEqual(currentItem, Constant.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)
                && qualityGreaterThan(currentItem)
                && nameNotEqual(currentItem, Constant.SULFURAS_HAND_OF_RAGNAROS)) {
            currentItem.quality = currentItem.quality - 1;
        }
    }

    private boolean qualityGreaterThan(Item currentItem) {
        return currentItem.quality > 0;
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
    private boolean nameEqual(Item item, String agedBrie) {
        return item.name.equals(agedBrie);
    }
}