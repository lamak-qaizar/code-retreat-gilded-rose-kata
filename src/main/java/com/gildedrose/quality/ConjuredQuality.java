package com.gildedrose.quality;

import com.gildedrose.Constants;
import com.gildedrose.Item;
import com.gildedrose.ItemType;

public class ConjuredQuality implements QualityUpdateStrategy {

  @Override
  public void updateQuality(Item item) {
    if (item.name.equals(ItemType.CONJURED)) {
      item.sellIn--;
      degradeQualityUntilMinimum(item);
      degradeQualityUntilMinimum(item);
    }
  }
  private static void degradeQualityUntilMinimum(Item item) {
    if (item.quality > Constants.MINIMUM_QUALITY_SCORE && !item.name.equals(ItemType.SULFURAS)) {
      item.quality -= 1;
    }
  }
}
