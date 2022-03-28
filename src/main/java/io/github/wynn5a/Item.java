package io.github.wynn5a;

public class Item {

  public static final String BACKSTAGE_PASSES = "Backstage passes";
  public static final String AGED_BRIE = "Aged Brie";
  public static final String SULFURAS = "Sulfuras";
  public String name;

  public int sellIn;

  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  @Override
  public String toString() {
    return "[" + this.name + ", " + this.sellIn + ", " + this.quality + "]";
  }

  public void decreaseQuality(int value) {
    if (quality <= 0 || isSulfuras()) {
      return;
    }
    quality = quality - value;
  }

  private boolean isSulfuras() {
    return SULFURAS.equals(this.name);
  }

  public void increaseQuality(int value) {
    if (quality < 50) {
      quality = quality + value;
    }
  }

  public void decreaseSellIn(int value) {
    if (isSulfuras()) {
      return;
    }
    sellIn = sellIn - value;
  }

  public boolean isBackstagePasses() {
    return BACKSTAGE_PASSES.equals(name);
  }

  public boolean isAgedBrie() {
    return name.equals(AGED_BRIE);
  }
}
