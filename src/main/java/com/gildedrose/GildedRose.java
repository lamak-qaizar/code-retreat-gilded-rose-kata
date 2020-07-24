package com.gildedrose;

import com.gildedrose.quality.AgedBrieQuality;
import com.gildedrose.quality.BackstagePassQuality;
import com.gildedrose.quality.ConjuredQuality;
import com.gildedrose.quality.DefaultItemQuality;
import com.gildedrose.quality.QualityUpdateStrategy;
import com.gildedrose.quality.SulfurasQualityUpdate;
import java.util.ArrayList;
import java.util.List;

class GildedRose {

    Item[] items;
    List<QualityUpdateStrategy> qualityUpdateStrategies;

    public GildedRose(Item[] items) {
        this.items = items;
        qualityUpdateStrategies = new ArrayList<>();
        qualityUpdateStrategies.add(new AgedBrieQuality());
        qualityUpdateStrategies.add(new BackstagePassQuality());
        qualityUpdateStrategies.add(new SulfurasQualityUpdate());
        qualityUpdateStrategies.add(new ConjuredQuality());
        qualityUpdateStrategies.add(new DefaultItemQuality());
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            qualityUpdateStrategies.forEach(qualityUpdateStrategy -> {
                qualityUpdateStrategy.updateQuality(item);
            });
        }
    }

    private static void degradeQualityUntilMinimum(Item item) {
        if (item.quality > Constants.MINIMUM_QUALITY_SCORE && !item.name.equals(ItemType.SULFURAS)) {
            item.quality -= 1;
        }
    }

    private static void increasePercentQualityUnderNDays(Item item, int noOfDays) {
        if (item.sellIn <= noOfDays) {
            increaseQualityUntilMax(item);
        }
    }

    private static void increaseConcertQualityUnder10Days(Item item) {
        increasePercentQualityUnderNDays(item, 10);
    }

    private static void increaseQualityUntilMax(Item item) {
        if (item.quality < Constants.MAXIMUM_QUALITY_SCORE) {
            item.quality += 1;
        }
    }
}
