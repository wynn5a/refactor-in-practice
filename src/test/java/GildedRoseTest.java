import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.wynn5a.GildedRose;
import io.github.wynn5a.Item;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * @author wynn5a
 * @date 2022/3/24
 */
public class GildedRoseTest {

  @Test
  public void should_decrease_quality_and_sell_in_after_one_day() {
    Item a = new Item("a", 10, 10);
    Item b = new Item("b", 9, 9);
    GildedRose rose = new GildedRose(new Item[]{a, b});
    rose.updateQuality();
    assertEquals(9, a.quality);
    assertEquals(9, a.sellIn);
    assertEquals(8, b.sellIn);
    assertEquals(8, b.sellIn);
  }

  @Test
  public void item_quality_never_less_than_0() {
    Item a = new Item("a", 10, 10);
    GildedRose rose = new GildedRose(new Item[]{a});
    IntStream.range(0, 11).forEach(i -> rose.updateQuality());
    assertEquals(0, a.quality);
    assertEquals(-1, a.sellIn);
  }

  @Test
  public void quality_decreases_2_once_sell_in_less_than_0(){
    Item a = new Item("a", 1, 10);
    GildedRose rose = new GildedRose(new Item[]{a});

    rose.updateQuality();
    rose.updateQuality();

    assertEquals(7, a.quality);
    assertEquals(-1, a.sellIn);
  }

  @Test
  public void quality_of_aged_brie_increase_with_day_passes(){
    Item a = new Item("Aged Brie", 2, 10);
    GildedRose rose = new GildedRose(new Item[]{a});

    rose.updateQuality();

    assertEquals(11, a.quality);
    assertEquals(1, a.sellIn);
  }


  @Test
  public void quality_of_item_should_have_max_value_50_and_min_value_0(){
    Item a = new Item("Aged Brie", 2, 10);
    Item b = new Item("B", 2, 10);
    GildedRose rose = new GildedRose(new Item[]{a, b});

    for (int i = 0; i < 50; i++) {
      rose.updateQuality();
    }

    assertEquals(50, a.quality);
    assertEquals(0, b.quality);
  }

  @Test
  public void sulfuras_will_keep_its_quality_and_sell_in_with_day_passes(){
    Item a = new Item("Sulfuras", 10, 10);
    GildedRose rose = new GildedRose(new Item[]{a});

    for (int i = 0; i < 10; i++) {
      rose.updateQuality();
    }

    assertEquals(10, a.quality);
    assertEquals(10, a.sellIn);
  }

  @Test
  public void backstage_passes_has_special_rule(){
    Item a = new Item("Backstage passes", 11, 30);
    GildedRose rose = new GildedRose(new Item[]{a});

    //increase 1 every day
    rose.updateQuality();
    assertEquals(31, a.quality);
    assertEquals(10, a.sellIn);

    //increase 2 if sell_in is less than 10
    rose.updateQuality();
    assertEquals(33, a.quality);
    assertEquals(9, a.sellIn);

    for (int i = 0; i < 5; i++) {
      rose.updateQuality();
    }

    //increase 3 if sell_in is less than 5
    assertEquals(44, a.quality);
    assertEquals(4, a.sellIn);


    for (int i = 0; i < 3; i++) {
      rose.updateQuality();
    }

    //never larger than 50
    assertEquals(50, a.quality);
    assertEquals(1, a.sellIn);

    rose.updateQuality();
    assertEquals(50, a.quality);
    assertEquals(0, a.sellIn);

    //quality will be 0 when sell in is less than 0
    rose.updateQuality();
    assertEquals(0, a.quality);
    assertEquals(-1, a.sellIn);

    rose.updateQuality();
    assertEquals(0, a.quality);
    assertEquals(-2, a.sellIn);
  }
}
