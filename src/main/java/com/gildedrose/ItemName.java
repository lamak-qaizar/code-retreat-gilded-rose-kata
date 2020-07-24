package com.gildedrose;

public enum ItemName {
    AGE_BRIE("Aged Brie"),
    SULFURES("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED("Conjured Mana Cake");

    private final String name;

    ItemName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
