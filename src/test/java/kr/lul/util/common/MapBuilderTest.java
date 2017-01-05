package kr.lul.util.common;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static kr.lul.util.common.MapBuilder.hashmap;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MapBuilderTest {
  private Map<Object, String> testMap() {
    Map<Object, String> map = new HashMap<>();
    for (int i = 0; i < 10; i++) {
      map.put(new Object(), randomAlphanumeric(5));
    }
    return map;
  }

  @Test
  public void testHashmap() throws Exception {
    //When
    MapBuilder<Object, Object> builder = hashmap();

    //Then
    assertThat(builder).isInstanceOf(MapBuilder.class);
    assertThat(builder.build()).isInstanceOf(HashMap.class)
        .isNotNull()
        .isEmpty();
  }

  @Test
  public void testHashmapWithPair() throws Exception {
    //Given
    Object key = new Object();
    String val = randomAlphanumeric(5);

    //When
    MapBuilder<Object, String> builder = MapBuilder.hashmap(key, val);

    //Then
    assertThat(builder).isInstanceOf(MapBuilder.class);
    assertThat(builder.build()).isNotNull()
        .isInstanceOf(HashMap.class)
        .hasSize(1)
        .containsKey(key).containsValue(val);
  }

  @Test
  public void testConstructorWithNull() throws Exception {
    assertThatThrownBy(() -> new MapBuilder<Object, String>(null)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void testPutMultiValue() throws Exception {
    //Given
    final Map<Object, String> expected = testMap();

    //When
    MapBuilder<Object, String> builder = hashmap();
    expected.forEach(builder::put);

    //Then
    assertThat(builder).isNotNull();
    assertThat(builder.build()).isNotNull()
        .isNotSameAs(expected)
        .isEqualTo(expected)
        .hasSize(expected.size());

    assertThatThrownBy(() -> builder.put(new Object(), randomAlphanumeric(5)))
        .isInstanceOf(IllegalStateException.class);
  }
}