package com.gildedrose.item.special;

import com.gildedrose.item.OrdinaryItem;

/**
 * @author Muhammad Talha Jamil
 * Date: 24-Jul-20
 */
public class Legendary extends OrdinaryItem {
    public Legendary(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        // Does nothing
    }
}
