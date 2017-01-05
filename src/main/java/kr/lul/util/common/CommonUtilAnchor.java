package kr.lul.util.common;

public abstract class CommonUtilAnchor implements Anchor {
  public static final Package PACKAGE = CommonUtilAnchor.class.getPackage();
  public static final String PACKAGE_NAME = PACKAGE.getName();

  public CommonUtilAnchor() {
    throw new UnsupportedOperationException();
  }
}