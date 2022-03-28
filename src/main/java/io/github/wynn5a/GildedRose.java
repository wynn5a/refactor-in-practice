package io.github.wynn5a;

/**
 * @author wynn5a
 * @date 2022/3/24
 */
public class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      updateQualityFor(item);
    }
  }

  private void updateQualityFor(Item item) {
    if (item.isBackstagePasses()) {
      if (item.sellIn < 6) {
        item.increaseQuality(3);
      } else if (item.sellIn < 11) {
        item.increaseQuality(2);
      }else{
        item.increaseQuality(1);
      }
    } else if (item.isAgedBrie()) {
      item.increaseQuality(1);
    } else {
      item.decreaseQuality(1);
    }

    item.decreaseSellIn(1);

    if (item.sellIn < 0) {
      if (item.isAgedBrie()) {
        return;
      }
      if (item.isBackstagePasses()) {
        item.quality = 0;
      } else {
        item.decreaseQuality(1);
      }
    }
  }
}