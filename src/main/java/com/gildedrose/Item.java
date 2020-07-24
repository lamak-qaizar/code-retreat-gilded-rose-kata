package com.gildedrose;

public class Item {

    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    private final String name;
    private int sellIn;
    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    private void increaseQuality() {
        this.quality++;
    }

    public void increaseQualityIfLessThanMax() {
        if (this.quality < MAX_QUALITY) {
            increaseQuality();
        }
    }

    public void decreaseQualityIfGreaterThanMin() {
        if (this.quality > MIN_QUALITY) {
            decreaseQuality();
        }
    }

    public boolean isSellInNegative(){
        return sellIn < 0;
    }

    public void decreaseSellIn() {
        this.sellIn--;
    }

    public int sellIn() {
        return sellIn;
    }

    private void decreaseQuality() {
        this.quality--;
    }

    public String name() {
        return this.name;
    }

    public void resetQuality() {
        this.quality = 0;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
