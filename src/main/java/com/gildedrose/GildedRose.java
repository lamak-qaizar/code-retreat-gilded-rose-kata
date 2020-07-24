package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {

            if (item.name().equals(ItemName.AGE_BRIE.getName())) {
                updateAgeBrieQuality(item);
            } else if (item.name().equals(ItemName.BACKSTAGE.getName())) {
                updateBackStageQuality(item);
            } else if (item.name().equals(ItemName.CONJURED.getName())) {
                updateConjuredQuality(item);
            } else if (!item.name().equals(ItemName.SULFURES.getName())) {
                item.decreaseQualityIfGreaterThanMin();
                item.decreaseSellIn();
                if (item.isSellInNegative()) {
                    item.decreaseQualityIfGreaterThanMin();
                }
            }
        }
    }

    private void updateConjuredQuality(Item item){
        item.decreaseQualityIfGreaterThanMin();
        item.decreaseSellIn();
        if (item.isSellInNegative()) {
            item.decreaseQualityIfGreaterThanMin();
        }
    }

    private void updateAgeBrieQuality(Item item) {
        item.increaseQualityIfLessThanMax();
        item.decreaseSellIn();
        if (item.isSellInNegative()) item.increaseQualityIfLessThanMax();

    }

    private void updateBackStageQuality(Item item) {
        item.increaseQualityIfLessThanMax();

        if (item.sellIn() < 11) {
            item.increaseQualityIfLessThanMax();
        }

        if (item.sellIn() < 6) {
            item.increaseQualityIfLessThanMax();
        }

        item.decreaseSellIn();
        if (item.isSellInNegative()) {
            item.resetQuality();
        }
    }
}