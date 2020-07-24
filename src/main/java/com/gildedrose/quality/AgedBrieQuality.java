package com.gildedrose.quality;

import com.gildedrose.Constants;
import com.gildedrose.Item;
import com.gildedrose.ItemType;

public class AgedBrieQuality implements QualityUpdateStrategy {

  @Override
  public void updateQuality(Item item) {
    if(item.name.equals(ItemType.AGED_BRIE)) {
      item.sellIn--;
      increaseQualityUntilMax(item);
      if (item.sellIn < 0) {
        increaseQualityUntilMax(item);
      }
    }
  }

  private static void increaseQualityUntilMax(Item item) {
    if (item.quality < Constants.MAXIMUM_QUALITY_SCORE) {
      item.quality += 1;
    }
  }
}
