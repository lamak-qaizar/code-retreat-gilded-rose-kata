package com.gildedrose.item.special;

import com.gildedrose.item.OrdinaryItem;

public class Conjured extends OrdinaryItem {

    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {

        if (isQualityDegradable()) {
            this.quality -= 2;
        }

        this.sellIn--;

        if (isItemPassedSellInDate() && isQualityDegradable()) {
            quality -= 2;
        }
    }
}
