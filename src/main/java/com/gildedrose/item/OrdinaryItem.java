package com.gildedrose.item;

import com.gildedrose.Item;

/**
 * @author Muhammad Talha Jamil
 * Date: 24-Jul-20
 */
public class OrdinaryItem extends Item {

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    public OrdinaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        if (isQualityDegradable()) {
            this.quality--;
        }

        this.sellIn--;

        if (isItemPassedSellInDate() && isQualityDegradable()) {
            quality--;
        }
    }


    protected boolean isItemPassedSellInDate() {
        return sellIn < 0;
    }

    protected boolean isQualityUpgradable() {
        return quality < MAX_QUALITY;
    }


    protected boolean isQualityDegradable() {
        return quality > MIN_QUALITY;
    }
}
