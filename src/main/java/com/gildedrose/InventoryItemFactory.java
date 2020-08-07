package com.gildedrose;

public class InventoryItemFactory {

    private InventoryItemFactory() {
    }

    public static InventoryItem createFor(Item item) {

        switch (item.name){
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePasses(item);
            case "Aged Brie":
                return new AgedBrie(item);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(item);
            default:
                return new GeneralInventoryItem(item);
        }
    }

}
