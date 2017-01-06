package kr.lul.util.assertion;

import kr.lul.util.common.ConditionChecker;
import kr.lul.util.common.ExceptionBuilder;

/**
 * 상태를 확인해 상태에 따라 예외를 던진다.
 */
public interface ConditionalException extends ConditionChecker {
  /**
   * 상태가 false이면 예외를 던진다.
   *
   * @param builder 상태가 false일 경우 던질 예외를 만든다.
   * @param <E>     예외 자료형.
   * @throws IllegalArgumentException builder가 null인 경우.
   * @throws NullPointerException     빌더가 null을 반환한 경우.
   * @throws E                        상태가 false일 경우.
   */
  default <E extends Exception> void check(ExceptionBuilder<E> builder) throws IllegalArgumentException, NullPointerException,
      E {
    if (check()) {
      return;
    } else if (null == builder) {
      throw new IllegalArgumentException("exception builder is null.");
    }

    E e = builder.build();
    if (null == e) {
      throw new NullPointerException("exception builder returned null.");
    } else {
      throw e;
    }
  }
}