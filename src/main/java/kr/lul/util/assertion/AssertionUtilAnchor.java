package kr.lul.util.assertion;

import kr.lul.util.common.Anchor;

public class AssertionUtilAnchor implements Anchor {
  public static final Package PACKAGE = AssertionUtilAnchor.class.getPackage();
  public static final String PACKAGE_NAME = PACKAGE.getName();

  public AssertionUtilAnchor() {
    throw new UnsupportedOperationException();
  }
}