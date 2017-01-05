package kr.lul.util.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 메서드 체인으로 맵을 생성할 수 있는 유틸리티 클래스.
 * thread NOT safe.
 */
public class MapBuilder<K, V> {
  public static <K, V> MapBuilder<K, V> hashmap() {
    return new MapBuilder<>(new HashMap<>());
  }

  public static <K, V> MapBuilder<K, V> hashmap(K key, V value) {
    return new MapBuilder<>(new HashMap<K, V>()).put(key, value);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  private Map<K, V> map;

  public MapBuilder(Map<K, V> map) {
    if (null == map) {
      throw new IllegalArgumentException("map is null.");
    }
    this.map = map;
  }

  private void checkState() throws IllegalStateException {
    if (null == this.map) {
      throw new IllegalStateException("dead builder.");
    }
  }

  public MapBuilder<K, V> put(K key, V value) {
    checkState();
    this.map.put(key, value);
    return this;
  }

  public Map<K, V> build() {
    checkState();
    Map<K, V> map = this.map;
    this.map = null;
    return map;
  }
}