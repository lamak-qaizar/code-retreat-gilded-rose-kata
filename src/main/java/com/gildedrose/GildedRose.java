package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {

            } else if (items[i].name.equals("Aged Brie")) {

                increaseQuality(i);

            } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                increaseQuality(i);

                if (items[i].sellIn < 11) { //2
                    increaseQuality(i);
                }

                if (items[i].sellIn < 6) { //
                    increaseQuality(i);
                }

            } else {
                decreaseQuality(i);
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {

                } else if (items[i].name.equals("Aged Brie")) {
                    increaseQuality(i);
                } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    items[i].quality = 0;
                } else {
                    decreaseQuality(i);
                }
            }
        }
    }

    private void decreaseQuality(int i) {
        if (items[i].quality > 0) {
            items[i].quality = items[i].quality - 1;
        }
    }

    private void increaseQuality(int i) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1; //1
        }
    }
}
