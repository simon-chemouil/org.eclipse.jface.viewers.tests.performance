package org.eclipse.jface.viewers.tests.performance.views;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.tests.performance.providers.TestLazyContentProvider;


public class LazyTestView
    extends AbstractBaseTestView {

  public LazyTestView() {
    super();
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.viewers.tests.lazy.views.AbstractBaseTestView#getContentProvider()
   */  
  protected IContentProvider getContentProvider() {
    return new TestLazyContentProvider(this.getViewer());
  }



}
