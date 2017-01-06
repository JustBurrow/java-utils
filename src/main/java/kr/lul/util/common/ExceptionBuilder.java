package kr.lul.util.common;

/**
 * 예외를 만든다.
 */
public interface ExceptionBuilder<E extends Exception> {
  /**
   * 정해진 예외를 만든다.
   *
   * @return 예외.
   */
  E build();
}