package io.github.wynn5a;

public class Item {

  public String name;

  public int sellIn;

  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  public boolean is(String name) {
    return this.name.equals(name);
  }

  @Override
  public String toString() {
    return "[" + this.name + ", " + this.sellIn + ", " + this.quality + "]";
  }

  public void decreaseQuality(int value) {
    if (quality <= 0 || is("Sulfuras")) {
      return;
    }
    quality = quality - value;
  }

  public void increaseQuality(int value) {
    if (quality < 50) {
      quality = quality + value;
    }
  }

  public void decreaseSellIn(int value) {
    if (is("Sulfuras")) {
      return;
    }
    sellIn = sellIn - value;
  }
}
