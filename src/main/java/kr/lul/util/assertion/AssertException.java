package kr.lul.util.assertion;

/**
 * {@link Asserts}의 단정 실패시 발생하는 에러
 */
public class AssertException extends RuntimeException {
  public AssertException() {
    super();
  }

  public AssertException(String message) {
    super(message);
  }

  public AssertException(String format, Object... args) {
    super(String.format(format, args));
  }
}