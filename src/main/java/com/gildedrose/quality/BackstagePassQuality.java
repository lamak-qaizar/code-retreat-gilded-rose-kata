package com.gildedrose.quality;

import com.gildedrose.Constants;
import com.gildedrose.Item;
import com.gildedrose.ItemType;

public class BackstagePassQuality implements QualityUpdateStrategy {

  @Override
  public void updateQuality(Item item) {
    if(item.name.equals(ItemType.BACKSTAGE_PASSES)) {

      increaseQualityUntilMax(item);
      increasePercentQualityUnderNDays(item, 10);
      increasePercentQualityUnderNDays(item, 5);
      item.sellIn--;
      if(item.sellIn < 0) {
        item.quality = Constants.MINIMUM_QUALITY_SCORE;
      }
    }
  }

  private static void increasePercentQualityUnderNDays(Item item, int noOfDays) {
    if (item.sellIn <= noOfDays) {
      increaseQualityUntilMax(item);
    }
  }

  private static void increaseQualityUntilMax(Item item) {
    if (item.quality < Constants.MAXIMUM_QUALITY_SCORE) {
      item.quality += 1;
    }
  }
}
