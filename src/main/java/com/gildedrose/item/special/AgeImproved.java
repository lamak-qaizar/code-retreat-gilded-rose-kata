package com.gildedrose.item.special;

import com.gildedrose.Item;
import com.gildedrose.item.OrdinaryItem;

/**
 * @author Muhammad Talha Jamil
 * Date: 24-Jul-20
 */
public class AgeImproved extends OrdinaryItem {

    public AgeImproved(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        if (isQualityUpgradable(this)) {
            this.quality++;
        }

        this.sellIn--;

        if (isItemPassedSellInDate(this) && isQualityUpgradable(this)) {
            this.quality++;
        }
    }

    private boolean isItemPassedSellInDate(Item item) {
        return item.sellIn < 0;
    }

    private boolean isQualityUpgradable(Item item) {
        return item.quality < MAX_QUALITY;
    }
}
