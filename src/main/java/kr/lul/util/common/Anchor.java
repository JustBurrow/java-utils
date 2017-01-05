package kr.lul.util.common;

/*
 * 패키지 정보 추적용. 어노테이션 등에 패키지 정보를 전달할 때, 문자열이 아닌 참조값으로 전달하기 위해 사용.
 *
 * <code>
 *   public abstract class SomePackageAnchor implements Anchor {
 *    public SomePackageAnchor() {
 *      throw new UnsupportedOperationException();
 *    }
 *   }
 * </code>
 */
public interface Anchor {
}
