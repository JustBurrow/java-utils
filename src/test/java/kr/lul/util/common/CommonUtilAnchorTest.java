package kr.lul.util.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by justburrow on 2017. 1. 5..
 */
public class CommonUtilAnchorTest {
  @Test
  public void testConstructor() throws Exception {
    assertThatThrownBy(() -> new CommonUtilAnchor() {
    }).isInstanceOf(UnsupportedOperationException.class);
  }
}