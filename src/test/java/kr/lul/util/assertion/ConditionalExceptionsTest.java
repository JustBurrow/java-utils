package kr.lul.util.assertion;

import kr.lul.util.common.ConditionChecker;
import kr.lul.util.common.ExceptionBuilder;
import kr.lul.util.common.MapBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static kr.lul.util.assertion.ConditionalExceptions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConditionalExceptionsTest {
  private class TestException extends Exception {
  }

  private ExceptionBuilder<Exception> nullBuilder = () -> null;
  private ExceptionBuilder<TestException> builder;

  @Before
  public void setUp() throws Exception {
    this.builder = TestException::new;
  }

  @Test
  public void testCheckAndThrow() throws Exception {
    assertThatThrownBy(() -> checkAndThrow(null, null))
        .isInstanceOf(NullPointerException.class)
        .hasMessage("condition checker is null.");
    assertThatThrownBy(() -> checkAndThrow(null, this.builder)).isInstanceOf(NullPointerException.class)
        .hasMessage("condition checker is null.");

    checkAndThrow(ConditionChecker.TRUE, null);
    assertThatThrownBy(() -> checkAndThrow(ConditionChecker.FALSE, null)).isInstanceOf(NullPointerException.class)
        .hasMessage("exception builder is null.");
    assertThatThrownBy(() -> checkAndThrow(ConditionChecker.FALSE, this.nullBuilder)).isInstanceOf(NullPointerException.class);
  }

  @Test
  public void testIsNull() throws Exception {
    isNull(null, null);
    isNull(null, this.nullBuilder);
    isNull(null, this.builder);

    assertThatThrownBy(() -> isNull(new Object(), null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> isNull(new Object(), this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> isNull(new Object(), this.builder)).isInstanceOf(TestException.class);
  }

  @Test
  public void testNotNull() throws Exception {
    notNull(new Object(), null);
    notNull(new Object(), this.nullBuilder);
    notNull(new Object(), this.builder);

    assertThatThrownBy(() -> notNull(null, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notNull(null, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notNull(null, this.builder)).isInstanceOf(TestException.class);
  }

  @Test
  public void testZero() throws Exception {
    assertThatThrownBy(() -> zero(-1, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> zero(-1, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> zero(-1, this.builder)).isInstanceOf(TestException.class);
    zero(0, null);
    zero(0, this.nullBuilder);
    zero(0, this.builder);
    assertThatThrownBy(() -> zero(1, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> zero(1, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> zero(1, this.builder)).isInstanceOf(TestException.class);

    assertThatThrownBy(() -> zero(-1L, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> zero(-1L, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> zero(-1L, this.builder)).isInstanceOf(TestException.class);
    zero(0L, null);
    zero(0L, this.nullBuilder);
    zero(0L, this.builder);
    assertThatThrownBy(() -> zero(1L, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> zero(1L, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> zero(1L, this.builder)).isInstanceOf(TestException.class);

    assertThatThrownBy(() -> zero(-1.0, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> zero(-1.0, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> zero(-1.0, this.builder)).isInstanceOf(TestException.class);
    zero(0.0, null);
    zero(0.0, this.nullBuilder);
    zero(0.0, this.builder);
    assertThatThrownBy(() -> zero(1.0, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> zero(1.0, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> zero(1.0, this.builder)).isInstanceOf(TestException.class);
  }

  @Test
  public void testNotZero() throws Exception {
    notZero(-1, null);
    notZero(-1, this.nullBuilder);
    notZero(-1, this.builder);
    assertThatThrownBy(() -> notZero(0, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notZero(0, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notZero(0, this.builder)).isInstanceOf(TestException.class);
    notZero(1, null);
    notZero(1, this.nullBuilder);
    notZero(1, this.builder);

    notZero(-1L, null);
    notZero(-1L, this.nullBuilder);
    notZero(-1L, this.builder);
    assertThatThrownBy(() -> notZero(0L, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notZero(0L, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notZero(0L, this.builder)).isInstanceOf(TestException.class);
    notZero(1L, null);
    notZero(1L, this.nullBuilder);
    notZero(1L, this.builder);

    notZero(-1.0, null);
    notZero(-1.0, this.nullBuilder);
    notZero(-1.0, this.builder);
    assertThatThrownBy(() -> notZero(0.0, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notZero(0.0, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notZero(0.0, this.builder)).isInstanceOf(TestException.class);
    notZero(1.0, null);
    notZero(1.0, this.nullBuilder);
    notZero(1.0, this.builder);
  }

  @Test
  public void testPositive() throws Exception {
    assertThatThrownBy(() -> positive(-1, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> positive(-1, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> positive(-1, this.builder)).isInstanceOf(TestException.class);
    assertThatThrownBy(() -> positive(0, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> positive(0, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> positive(0, this.builder)).isInstanceOf(TestException.class);
    positive(1, null);
    positive(1, this.nullBuilder);
    positive(1, this.builder);

    assertThatThrownBy(() -> positive(-1L, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> positive(-1L, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> positive(-1L, this.builder)).isInstanceOf(TestException.class);
    assertThatThrownBy(() -> positive(0L, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> positive(0L, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> positive(0L, this.builder)).isInstanceOf(TestException.class);
    positive(1L, null);
    positive(1L, this.nullBuilder);
    positive(1L, this.builder);

    assertThatThrownBy(() -> positive(-1.0, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> positive(-1.0, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> positive(-1.0, this.builder)).isInstanceOf(TestException.class);
    assertThatThrownBy(() -> positive(0.0, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> positive(0.0, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> positive(0.0, this.builder)).isInstanceOf(TestException.class);
    positive(1.0, null);
    positive(1.0, this.nullBuilder);
    positive(1.0, this.builder);
  }

  @Test
  public void testNegative() throws Exception {
    negative(-1, null);
    negative(-1, this.nullBuilder);
    negative(-1, this.builder);
    assertThatThrownBy(() -> negative(0, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> negative(0, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> negative(0, this.builder)).isInstanceOf(TestException.class);
    assertThatThrownBy(() -> negative(1, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> negative(1, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> negative(1, this.builder)).isInstanceOf(TestException.class);

    negative(-1L, null);
    negative(-1L, this.nullBuilder);
    negative(-1L, this.builder);
    assertThatThrownBy(() -> negative(0L, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> negative(0L, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> negative(0L, this.builder)).isInstanceOf(TestException.class);
    assertThatThrownBy(() -> negative(1L, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> negative(1L, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> negative(1L, this.builder)).isInstanceOf(TestException.class);

    negative(-1.0, null);
    negative(-1.0, this.nullBuilder);
    negative(-1.0, this.builder);
    assertThatThrownBy(() -> negative(0.0, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> negative(0.0, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> negative(0.0, this.builder)).isInstanceOf(TestException.class);
    assertThatThrownBy(() -> negative(1.0, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> negative(1.0, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> negative(1.0, this.builder)).isInstanceOf(TestException.class);
  }

  @Test
  public void testEmptyWithCollection() throws Exception {
    assertThatThrownBy(() -> empty((Collection<?>) null, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> empty((Collection<?>) null, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> empty((Collection<?>) null, this.builder)).isInstanceOf(NullPointerException.class);

    empty(emptyList(), null);
    empty(emptyList(), this.nullBuilder);
    empty(emptyList(), this.builder);
    assertThatThrownBy(() -> empty(asList(new Object()), null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> empty(asList(new Object()), this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> empty(asList(new Object()), this.builder)).isInstanceOf(TestException.class);

    empty(emptySet(), null);
    empty(emptySet(), this.nullBuilder);
    empty(emptySet(), this.builder);
    assertThatThrownBy(() -> empty(new HashSet<>(asList(new Object())), null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> empty(new HashSet<>(asList(new Object())), this.nullBuilder)).isInstanceOf(NullPointerException
        .class);
    assertThatThrownBy(() -> empty(new HashSet<>(asList(new Object())), this.builder)).isInstanceOf(TestException.class);
  }


  @Test
  public void testNotEmptyWithCollection() throws Exception {
    assertThatThrownBy(() -> notEmpty((Collection<?>) null, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notEmpty((Collection<?>) null, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notEmpty((Collection<?>) null, this.builder)).isInstanceOf(NullPointerException.class);

    assertThatThrownBy(() -> notEmpty(emptyList(), null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notEmpty(emptyList(), this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notEmpty(emptyList(), this.nullBuilder)).isInstanceOf(NullPointerException.class);

    assertThatThrownBy(() -> notEmpty(emptySet(), null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notEmpty(emptySet(), this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notEmpty(emptySet(), this.builder)).isInstanceOf(TestException.class);

    notEmpty(asList(new Object()), null);
    notEmpty(asList(new Object()), this.nullBuilder);
    notEmpty(asList(new Object()), this.builder);

    notEmpty(new HashSet<>(asList(new Object())), null);
    notEmpty(new HashSet<>(asList(new Object())), this.nullBuilder);
    notEmpty(new HashSet<>(asList(new Object())), this.builder);
  }

  @Test
  public void testEmptyWithMap() throws Exception {
    assertThatThrownBy(() -> empty((Map) null, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> empty((Map) null, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> empty((Map) null, this.builder)).isInstanceOf(NullPointerException.class);

    empty(new HashMap(), null);
    empty(new HashMap(), this.nullBuilder);
    empty(new HashMap(), this.builder);

    assertThatThrownBy(() -> empty(MapBuilder.hashmap(new Object(), new Object()).build(), null))
        .isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> empty(MapBuilder.hashmap(new Object(), new Object()).build(), this.nullBuilder))
        .isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> empty(MapBuilder.hashmap(new Object(), new Object()).build(), this.builder))
        .isInstanceOf(TestException.class);
  }

  @Test
  public void testNotEmptyWithMap() throws Exception {
    assertThatThrownBy(() -> notEmpty((Map) null, null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notEmpty((Map) null, this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notEmpty((Map) null, this.builder)).isInstanceOf(NullPointerException.class);

    assertThatThrownBy(() -> notEmpty(new HashMap(), null)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notEmpty(new HashMap(), this.nullBuilder)).isInstanceOf(NullPointerException.class);
    assertThatThrownBy(() -> notEmpty(new HashMap(), this.builder)).isInstanceOf(TestException.class);

    notEmpty(MapBuilder.hashmap(new Object(), new Object()).build(), null);
    notEmpty(MapBuilder.hashmap(new Object(), new Object()).build(), this.nullBuilder);
    notEmpty(MapBuilder.hashmap(new Object(), new Object()).build(), this.builder);
  }
}