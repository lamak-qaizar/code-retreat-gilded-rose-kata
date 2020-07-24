package com.gildedrose;

import com.gildedrose.item.OrdinaryItem;
import com.gildedrose.item.special.AgeImproved;
import com.gildedrose.item.special.BackStagePass;
import com.gildedrose.item.special.Legendary;
import org.approvaltests.Approvals;
import org.junit.Test;

public class ApprovalTest {

    @Test
    public void testFor10Days() {

        Item[] items = new Item[] {
                new OrdinaryItem("+5 Dexterity Vest", 10, 20), //
                new AgeImproved("Aged Brie", 2, 0), //
                new OrdinaryItem("Elixir of the Mongoose", 5, 7), //
                new Legendary("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Legendary("Sulfuras, Hand of Ragnaros", -1, 80),
                new BackStagePass("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new BackStagePass("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new BackStagePass("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new OrdinaryItem("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        int days = 10;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < days; i++) {
            stringBuilder.append("-------- day " + i + " --------\n");
            stringBuilder.append("name, sellIn, quality\n");
            for (Item item : items) {
                stringBuilder.append(item + "\n");
            }
            stringBuilder.append("\n");
            app.updateQuality();
        }

        Approvals.verify(stringBuilder.toString());
    }

}
