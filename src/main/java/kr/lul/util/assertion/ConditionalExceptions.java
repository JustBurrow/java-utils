package kr.lul.util.assertion;

import kr.lul.util.common.ConditionChecker;
import kr.lul.util.common.ExceptionBuilder;

import java.util.Collection;
import java.util.Map;

/**
 * 인자의 상태에 따라 예외를 던지는 유틸리티 메서드 모음.
 */
public abstract class ConditionalExceptions {
  /**
   * 상태 확인 후 false인 경우 정해진 예외를 던진다.
   *
   * @param condition
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void checkAndThrow(ConditionChecker condition, ExceptionBuilder<E> builder) throws NullPointerException, E {
    if (condition == null) {
      throw new NullPointerException("condition checker is null.");
    } else if (condition.check()) {
      return;
    }

    if (builder == null) {
      throw new NullPointerException("exception builder is null.");
    }
    throw builder.build();
  }

  /**
   * 인스턴스가 null이 아닌 경우 예외를 던진다.
   *
   * @param obj
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void isNull(Object obj, ExceptionBuilder<E> builder) throws NullPointerException, E {
    if (obj == null) {
      return;
    }
    throw builder.build();
  }

  /**
   * 인스턴스가 null인 경우 예외를 던진다.
   *
   * @param obj
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void notNull(Object obj, ExceptionBuilder<E> builder) throws NullPointerException, E {
    if (obj != null) {
      return;
    }
    throw builder.build();
  }

  /**
   * 숫자가 0이 아니면 예외를 던진다.
   *
   * @param i
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void zero(int i, ExceptionBuilder<E> builder) throws NullPointerException, E {
    if (0 == i) {
      return;
    }
    throw builder.build();
  }

  /**
   * 숫자가 0이 아니면 예외를 던진다.
   *
   * @param l
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void zero(long l, ExceptionBuilder<E> builder) throws NullPointerException, E {
    if (0L == l) {
      return;
    }
    throw builder.build();
  }

  /**
   * 숫자가 0이 아니면 예외를 던진다.
   *
   * @param d
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void zero(double d, ExceptionBuilder<E> builder) throws NullPointerException, E {
    if (0.0 == d) {
      return;
    }
    throw builder.build();
  }

  /**
   * 숫자가 0이면 예외를 던진다.
   *
   * @param i
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void notZero(int i, ExceptionBuilder<E> builder) throws NullPointerException, E {
    if (0 != i) {
      return;
    }
    throw builder.build();
  }

  /**
   * 숫자가 0이면 예외를 던진다.
   *
   * @param l
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void notZero(long l, ExceptionBuilder<E> builder) throws NullPointerException, E {
    if (0L != l) {
      return;
    }
    throw builder.build();
  }

  /**
   * 숫자가 0이면 예외를 던진다.
   *
   * @param d
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void notZero(double d, ExceptionBuilder<E> builder) throws NullPointerException, E {
    if (0.0 != d) {
      return;
    }
    throw builder.build();
  }

  /**
   * 숫자가 0보다 작거나 같으면 예외를 던진다.
   *
   * @param i
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void positive(int i, ExceptionBuilder<E> builder) throws NullPointerException, E {
    if (0 < i) {
      return;
    }
    throw builder.build();
  }

  /**
   * 숫자가 0보다 작거나 같으면 예외를 던진다.
   *
   * @param l
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void positive(long l, ExceptionBuilder<E> builder) throws NullPointerException, E {
    if (0L < l) {
      return;
    }
    throw builder.build();
  }

  /**
   * 숫자가 0보다 작거나 같으면 예외를 던진다.
   *
   * @param d
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void positive(double d, ExceptionBuilder<E> builder) throws NullPointerException, E {
    if (0.0 < d) {
      return;
    }
    throw builder.build();
  }

  /**
   * 숫자가 0보다 크거나 같으면 예외를 던진다.
   *
   * @param i
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void negative(int i, ExceptionBuilder<E> builder) throws NullPointerException, E {
    if (0 > i) {
      return;
    }
    throw builder.build();
  }

  /**
   * 숫자가 0보다 크거나 같으면 예외를 던진다.
   *
   * @param l
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void negative(long l, ExceptionBuilder<E> builder) throws NullPointerException, E {
    if (0L > l) {
      return;
    }
    throw builder.build();
  }

  /**
   * 숫자가 0보다 크거나 같으면 예외를 던진다.
   *
   * @param d
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void negative(double d, ExceptionBuilder<E> builder) throws NullPointerException, E {
    if (0.0 > d) {
      return;
    }
    throw builder.build();
  }

  /**
   * 컬렉션이 비어있지 않으면 예외를 던진다.
   *
   * @param collection
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void empty(Collection<?> collection, ExceptionBuilder<E> builder) throws NullPointerException, E {
    if (collection.isEmpty()) {
      return;
    }
    throw builder.build();
  }

  /**
   * 컬렉션이 비어있으면 예외를 던진다.
   *
   * @param collection
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void notEmpty(Collection<?> collection, ExceptionBuilder<E> builder) throws
      NullPointerException, E {
    if (!collection.isEmpty()) {
      return;
    }
    throw builder.build();
  }

  /**
   * 맵이 비어있지 않으면 예외를 던진다.
   *
   * @param map
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void empty(Map map, ExceptionBuilder<E> builder) throws NullPointerException, E {
    if (map.isEmpty()) {
      return;
    }
    throw builder.build();
  }

  /**
   * 맵이 비어있으면 예외를 던진다.
   *
   * @param map
   * @param builder
   * @param <E>
   * @throws NullPointerException
   * @throws E
   */
  public static <E extends Exception> void notEmpty(Map map, ExceptionBuilder<E> builder) throws NullPointerException,
      E {
    if (!map.isEmpty()) {
      return;
    }
    throw builder.build();
  }

  protected ConditionalExceptions() {
    throw new UnsupportedOperationException();
  }
}