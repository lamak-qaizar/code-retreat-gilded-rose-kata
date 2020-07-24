package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            switch (items[i].name) {
                case "Sulfuras, Hand of Ragnaros":
                    break;
                case "Aged Brie":
                    increaseQualityIfLessThan50(i);

                    if (items[i].sellIn <= 0) {
                        increaseQualityIfLessThan50(i);
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":

                    increaseQualityIfLessThan50(i);

                    if (items[i].sellIn < 11) { //2
                        increaseQualityIfLessThan50(i);
                    }

                    if (items[i].sellIn < 6) { //
                        increaseQualityIfLessThan50(i);
                    }

                    if (items[i].sellIn <= 0) {
                        items[i].quality = 0;
                    }
                    break;
                default:
                    decreaseQualityIfGreaterThan0(i);

                    if (items[i].sellIn <= 0) {
                        decreaseQualityIfGreaterThan0(i);
                    }
                    break;
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }
        }
    }

    private void decreaseQualityIfGreaterThan0(int i) {
        if (items[i].quality > 0) {
            items[i].quality = items[i].quality - 1;
        }
    }

    private void increaseQualityIfLessThan50(int i) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1; //1
        }
    }
}
