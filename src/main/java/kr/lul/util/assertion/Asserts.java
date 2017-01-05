package kr.lul.util.assertion;

import java.util.Collection;
import java.util.Map;

/**
 * 기본적인 자료형의 단정 유틸리티 메서드 모음
 */
public abstract class Asserts {
  /**
   * 인스턴스가 null인지 확인한다
   *
   * @param obj 확인할 인스턴스.
   * @throws AssertException 인스턴스가 null이 아닌 경우.
   */
  public static void isNull(Object obj) throws AssertException {
    if (null != obj) {
      throw new AssertException("obj is not null.");
    }
  }

  /**
   * 인스턴스가 null이 아님을 확인한다.
   *
   * @param obj 확인할 인스턴스.
   * @throws AssertException 인스턴스가 null인 경우.
   */
  public static void isNotNull(Object obj) throws AssertException {
    if (null == obj) {
      throw new AssertException("obj is null.");
    }
  }

  /**
   * 숫자가 0임을 확인한다.
   *
   * @param i 확인할 숫자.
   * @throws AssertException 숫자가 0이 아닌 경우.
   */
  public static void zero(int i) throws AssertException {
    if (0 != i) {
      throw new AssertException("integer[%d] is not zero.", i);
    }
  }


  /**
   * 숫자가 0임을 확인한다.
   *
   * @param l 확인할 숫자.
   * @throws AssertException 숫자가 0이 아닌 경우.
   */
  public static void zero(long l) throws AssertException {
    if (0L != l) {
      throw new AssertException("long[%d] is not zero.", l);
    }
  }

  /**
   * 숫자가 영이 아님을 확인한다.
   *
   * @param i 확인할 숫자.
   * @throws AssertException 숫자가 0인 경우.
   */
  public static void notZero(int i) throws AssertException {
    if (0 == i) {
      throw new AssertException("integer[%d] is zero.", i);
    }
  }

  /**
   * 숫자가 영이 아님을 확인한다.
   *
   * @param l 확인할 숫자.
   * @throws AssertException 숫자가 0인 경우.
   */
  public static void notZero(long l) throws AssertException {
    if (0L == l) {
      throw new AssertException("long[%d] is zero.", l);
    }
  }

  /**
   * 숫자가 0보다 큼을 확인한다.
   *
   * @param i 확인할 숫자.
   * @throws AssertException 숫자가 0보다 작거나 같은 경우.
   */
  public static void positive(int i) throws AssertException {
    if (0 >= i) {
      throw new AssertException("integer[%d] is not positive.", i);
    }
  }

  /**
   * 숫자가 0보다 큼을 확인한다.
   *
   * @param l 확인할 숫자.
   * @throws AssertException 숫자가 0보다 작거나 같은 경우.
   */
  public static void positive(long l) throws AssertException {
    if (0 >= l) {
      throw new AssertException("long[%d] is not positive.", l);
    }
  }

  /**
   * 숫자가 0보다 큼을 확인한다.
   *
   * @param d 확인할 숫자.
   * @throws AssertException 숫자가 0보다 작거나 같은 경우.
   */
  public static void positive(double d) throws AssertException {
    if (0.0 >= d) {
      throw new AssertException("double[%f] is not positive.", d);
    }
  }

  /**
   * 숫자가 0보다 크지 않음을 확인한다.
   *
   * @param i 확인할 숫자.
   * @throws AssertException 숫자가 0보다 큰 경우.
   */
  public static void notPositive(int i) throws AssertException {
    if (0 < i) {
      throw new AssertException("integer[%d] is positive.", i);
    }
  }

  /**
   * 숫자가 0보다 크지 않음을 확인한다.
   *
   * @param l 확인할 숫자.
   * @throws AssertException 숫자가 0보다 큰 경우.
   */
  public static void notPositive(long l) throws AssertException {
    if (0L < l) {
      throw new AssertException("long[%d] is positive.", l);
    }
  }

  /**
   * 숫자가 0보다 크지 않음을 확인한다.
   *
   * @param d 확인할 숫자.
   * @throws AssertException 숫자가 0보다 큰 경우.
   */
  public static void notPositive(double d) throws AssertException {
    if (0.0 < d) {
      throw new AssertException("double[%f] is positive.", d);
    }
  }

  /**
   * 숫자가 0보다 작음을 확인한다.
   *
   * @param i 확인할 숫자.
   * @throws AssertException 숫자가 0보다 크거나 같은 경우.
   */
  public static void negative(int i) throws AssertException {
    if (0L <= i) {
      throw new AssertException("integer[%d] is not negative.", i);
    }
  }

  /**
   * 숫자가 0보다 작음을 확인한다.
   *
   * @param l 확인할 숫자.
   * @throws AssertException 숫자가 0보다 크거나 같은 경우.
   */
  public static void negative(long l) throws AssertException {
    if (0 <= l) {
      throw new AssertException("long[%d] is not negative.", l);
    }
  }

  /**
   * 숫자가 0보다 작음을 확인한다.
   *
   * @param d 확인할 숫자.
   * @throws AssertException 숫자가 0보다 크거나 같은 경우.
   */
  public static void negative(double d) throws AssertException {
    if (0.0 <= d) {
      throw new AssertException("double[%f] is not negative.", d);
    }
  }

  /**
   * 숫자가 0보다 작지 않음을 확인한다.
   *
   * @param i 확인할 숫자.
   * @throws AssertException 숫자가 0보다 작은 경우.
   */
  public static void notNegative(int i) throws AssertException {
    if (0 > i) {
      throw new AssertException("integer[%d] is negative.", i);
    }
  }

  /**
   * 숫자가 0보다 작지 않음을 확인한다.
   *
   * @param l 확인할 숫자.
   * @throws AssertException 숫자가 0보다 작은 경우.
   */
  public static void notNegative(long l) throws AssertException {
    if (0L > l) {
      throw new AssertException("integer[%d] is negative.", l);
    }
  }

  /**
   * 숫자가 0보다 작지 않음을 확인한다.
   *
   * @param d 확인할 숫자.
   * @throws AssertException 숫자가 0보다 작은 경우.
   */
  public static void notNegative(double d) throws AssertException {
    if (0.0 > d) {
      throw new AssertException("double[%f] is negative.", d);
    }
  }

  /**
   * 문자열이 null 이거나 빈 문자열임을 확인한다.
   *
   * @param str 확인할 문자열.
   * @throws AssertException 문자열이 내용이 있을 때
   */
  public static void empty(CharSequence str) throws AssertException {
    if (null != str && 0 < str.length()) {
      throw new AssertException("string[%s] is not empty.", str);
    }
  }

  /**
   * 문자열이 빈 문자열이 아님을 확인한다.
   *
   * @param str 확인할 문자열.
   * @throws AssertException 문자열이 null 이거나 비어있는 경우.
   */
  public static void hasLength(CharSequence str) throws AssertException {
    if (null == str) {
      throw new AssertException("str is null.");
    } else if (0 == str.length()) {
      throw new AssertException("str is empty.");
    }
  }

  /**
   * 컬렉션이 null 이거나 비어있을 확인한다.
   *
   * @param collection 확인할 컬렉션.
   * @throws AssertException 컬렉션에 내용이 있을 경우.
   */
  public static void empty(Collection collection) throws AssertException {
    if (null != collection && !collection.isEmpty()) {
      throw new AssertException("collection[%s] is not empty.", collection);
    }
  }

  /**
   * 컬렉션이 비어있지 않음을 확인한다.
   *
   * @param collection 확인할 컬렉션.
   * @throws AssertException 컬렉션이 null 이거나 비어있는 경우.
   */
  public static void notEmpty(Collection collection) throws AssertException {
    if (null == collection) {
      throw new AssertException("collection is null.");
    } else if (collection.isEmpty()) {
      throw new AssertException("collection is empty.");
    }
  }

  /**
   * 맵이 null 이거나 비어있음을 확인한다.
   *
   * @param map 확인할 맵.
   * @throws AssertException 맵에 내용이 있을 경우.
   */
  public static void empty(Map map) throws AssertException {
    if (null != map && !map.isEmpty()) {
      throw new AssertException("map[%s] is not empty.");
    }
  }

  /**
   * 맵이 비어있지 않음을 확인한다.
   *
   * @param map 확인할 맵.
   * @throws AssertException 맵이 null 이거나 비어있는 경우.
   */
  public static void notEmpty(Map map) throws AssertException {
    if (null == map) {
      throw new AssertException("map is null.");
    } else if (map.isEmpty()) {
      throw new AssertException("map is empty.");
    }
  }

  public Asserts() {
    throw new UnsupportedOperationException();
  }
}