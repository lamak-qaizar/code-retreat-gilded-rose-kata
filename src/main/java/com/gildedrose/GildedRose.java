package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name().equals(ItemName.AGE_BRIE.getName())
                || item.name().equals(ItemName.BACKSTAGE.getName())) {

                item.increaseQualityIfLessThanMax();

                if (item.name().equals(ItemName.BACKSTAGE.getName())) {

                    if (item.sellIn() < 11) {
                        item.increaseQualityIfLessThanMax();
                    }

                    if (item.sellIn() < 6) {
                        item.increaseQualityIfLessThanMax();
                    }
                }

            } else if (!item.name().equals(ItemName.SULFURES.getName())) {
                item.decreaseQualityIfGreaterThanMin();
            }

            if (!item.name().equals(ItemName.SULFURES.getName())) {
                item.decreaseSellIn();
            }

            if (item.sellIn() < 0) {
                if (item.name().equals(ItemName.AGE_BRIE.getName())) {
                    item.increaseQualityIfLessThanMax();
                } else {
                    if (item.name().equals(ItemName.BACKSTAGE.getName())) {
                        item.resetQuality();
                    } else if (!item.name().equals(ItemName.SULFURES.getName())) {
                        item.decreaseQualityIfGreaterThanMin();
                    }
                }
            }
        }
    }
}