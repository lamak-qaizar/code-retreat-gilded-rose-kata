package com.gildedrose.item.special;

import com.gildedrose.item.OrdinaryItem;

public class BackStagePass extends OrdinaryItem {

    public BackStagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {

        if (this.sellIn < 0) {
            this.quality = MIN_QUALITY;
        } else if (this.sellIn < 6) {
            this.quality = Math.min(MAX_QUALITY, this.quality + 3);
        } else if (this.sellIn <= 10) {
            this.quality = Math.min(MAX_QUALITY, this.quality + 2);
        } else if (this.sellIn > 10) {
            this.quality += 1;
        }
        this.sellIn --;
        if (this.sellIn < 0) {
            this.quality = MIN_QUALITY;
        }
    }
}
