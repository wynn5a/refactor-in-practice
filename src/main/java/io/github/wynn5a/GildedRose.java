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
    if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes")) {
      if (item.quality > 0) {
        if (!item.name.equals("Sulfuras")) {
          item.quality = item.quality - 1;
        }
      }
    } else {
      if (item.quality < 50) {
        item.quality = item.quality + 1;

        if (item.name.equals("Backstage passes")) {
          if (item.sellIn < 11) {
            if (item.quality < 50) {
              item.quality = item.quality + 1;
            }
          }

          if (item.sellIn < 6) {
            if (item.quality < 50) {
              item.quality = item.quality + 1;
            }
          }
        }
      }
    }

    if (!item.name.equals("Sulfuras")) {
      item.sellIn = item.sellIn - 1;
    }

    if (item.sellIn < 0) {
      if (!item.name.equals("Aged Brie")) {
        if (!item.name.equals("Backstage passes")) {
          if (item.quality > 0) {
            if (!item.name.equals("Sulfuras")) {
              item.quality = item.quality - 1;
            }
          }
        } else {
          item.quality = 0;
        }
      } else {
        if (item.quality < 50) {
          item.quality = item.quality + 1;
        }
      }
    }
  }
}