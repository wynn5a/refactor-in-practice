import io.github.wynn5a.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author wynn5a
 * @date 2022/3/24
 */
public class ItemTest {

  @Test
  public void should_override_to_string() {
    Item i = new Item("gold", 10, 2);
    Assertions.assertEquals("[gold, 10, 2]", i.toString());
  }
}
