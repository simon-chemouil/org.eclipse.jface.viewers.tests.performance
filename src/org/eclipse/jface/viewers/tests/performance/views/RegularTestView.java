package org.eclipse.jface.viewers.tests.performance.views;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.tests.performance.providers.TestStandardContentProvider;


public class RegularTestView
    extends AbstractBaseTestView {

  public RegularTestView() {
    super();
  }

  protected IContentProvider getContentProvider() {
    return new TestStandardContentProvider();
  }

}
