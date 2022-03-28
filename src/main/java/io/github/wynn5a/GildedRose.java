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
    if (item.is(Item.BACKSTAGE_PASSES)) {
      if (item.sellIn < 6) {
        item.increaseQuality(3);
      } else if (item.sellIn < 11) {
        item.increaseQuality(2);
      }else{
        item.increaseQuality(1);
      }
    } else if (item.is(Item.AGED_BRIE)) {
      item.increaseQuality(1);
    } else {
      item.decreaseQuality(1);
    }

    item.decreaseSellIn(1);

    if (item.sellIn < 0) {
      if (item.is(Item.AGED_BRIE)) {
        return;
      }
      if (item.is(Item.BACKSTAGE_PASSES)) {
        item.quality = 0;
      } else {
        item.decreaseQuality(1);
      }
    }
  }

}