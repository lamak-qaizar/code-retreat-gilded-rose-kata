package com.gildedrose;

class GildedRose {
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured Mana Cake";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            switch (item.name) {
                case SULFURAS:
                    break;
                case AGED_BRIE:
                    upgradeQualityIfLessThan50(item);

                    if (isExpired(item)) {
                        upgradeQualityIfLessThan50(item);
                    }
                    break;
                case BACKSTAGE_PASSES:

                    upgradeQualityIfLessThan50(item);

                    if (item.sellIn < 11) {
                        upgradeQualityIfLessThan50(item);
                    }

                    if (item.sellIn < 6) {
                        upgradeQualityIfLessThan50(item);
                    }

                    if (isExpired(item)) {
                        item.quality = 0;
                    }
                    break;
                case CONJURED:
                    degradeQualityIfGreaterThan0(item);
                    degradeQualityIfGreaterThan0(item);

                    if (isExpired(item)) {
                        degradeQualityIfGreaterThan0(item);
                        degradeQualityIfGreaterThan0(item);
                    }
                    break;
                default:
                    degradeQualityIfGreaterThan0(item);

                    if (isExpired(item)) {
                        degradeQualityIfGreaterThan0(item);
                    }
                    break;
            }

            if (!item.name.equals(GildedRose.SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }
        }
    }

    private boolean isExpired(Item item) {
        return item.sellIn <= 0;
    }

    private void degradeQualityIfGreaterThan0(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void upgradeQualityIfLessThan50(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1; //1
        }
    }


}
