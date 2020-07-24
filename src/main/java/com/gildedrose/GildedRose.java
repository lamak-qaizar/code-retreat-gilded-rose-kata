package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(ItemName.AGE_BRIE.getName())
                    && !item.name.equals(ItemName.BACKSTAGE.getName())) {
                if (item.quality > 0) {
                    if (!item.name.equals(ItemName.SULFURES.getName())) {
                        item.decreaseQuality();
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.increaseQuality();

                    if (item.name.equals(ItemName.BACKSTAGE.getName())) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.increaseQuality();
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.increaseQuality();
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(ItemName.SULFURES.getName())) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(ItemName.AGE_BRIE.getName())) {
                    if (!item.name.equals(ItemName.BACKSTAGE.getName())) {
                        if (item.quality > 0) {
                            if (!item.name.equals(ItemName.SULFURES.getName())) {
                                item.decreaseQuality();
                            }
                        }
                    } else {
                        item.resetQuality();
                    }
                } else {
                    if (item.quality < 50) {
                        item.increaseQuality();
                    }
                }
            }
        }
    }
}