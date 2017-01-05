package kr.lul.util.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 */
public class CommonUtilAnchorTest {
  @Test
  public void testConstructor() throws Exception {
    assertThatThrownBy(() -> new CommonUtilAnchor() {
    }).isInstanceOf(UnsupportedOperationException.class);
  }
}