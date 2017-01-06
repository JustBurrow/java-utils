package kr.lul.util.assertion;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConditionalExceptionTest {
  private class TestException extends Exception {
  }

  private ConditionalException trueCondition = () -> true;
  private ConditionalException falseCondition = () -> false;

  @Test
  public void testCheckWithBuilderAsNull() throws Exception {
    this.trueCondition.check(null);
    assertThatThrownBy(() -> this.falseCondition.check(null)).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("exception builder is null.");
  }

  @Test
  public void testCheckWithBuilderThatReturnsNull() throws Exception {
    this.trueCondition.check(() -> null);
    assertThatThrownBy(() -> this.falseCondition.check(() -> null)).isInstanceOf(NullPointerException.class)
        .hasMessage("exception builder returned null.");
  }

  @Test
  public void testCheckWithBuilder() throws Exception {
    this.trueCondition.check(TestException::new);
    assertThatThrownBy(() -> this.falseCondition.check(TestException::new)).isInstanceOf(TestException.class);
  }
}