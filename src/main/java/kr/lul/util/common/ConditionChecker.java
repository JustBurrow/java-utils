package kr.lul.util.common;

/**
 * 불리언 상태 정보를 제공한다.
 */
public interface ConditionChecker {
  ConditionChecker TRUE = () -> true;
  ConditionChecker FALSE = () -> false;

  /**
   * 상태를 확인한다.
   *
   * @return 불리언 상태.
   */
  boolean check();
}