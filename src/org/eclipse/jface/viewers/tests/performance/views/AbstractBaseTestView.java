package org.eclipse.jface.viewers.tests.performance.views;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.tests.performance.model.ModelRoot;
import org.eclipse.jface.viewers.tests.performance.model.test.ModelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;


abstract public class AbstractBaseTestView
    extends ViewPart {

  private TreeViewer treeViewer;

  public AbstractBaseTestView() {
    super();
  }

  @Override
  public void createPartControl(Composite parent) {
    treeViewer = new TreeViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION
        | SWT.BORDER | SWT.VIRTUAL | SWT.MULTI);
    treeViewer.setUseHashlookup(true);
    treeViewer.setContentProvider(getContentProvider());
    treeViewer.setLabelProvider(new LabelProvider());
    
    
    treeViewer.setHasChildren(getInitialInput(), true); // let's assume this
    treeViewer.setInput(getInitialInput());
    
    

    getSite().setSelectionProvider(treeViewer);

  }

  @Override
  public void setFocus() {
    treeViewer.getControl().setFocus();

  }
  
  abstract protected IContentProvider getContentProvider();
  
  protected ModelRoot getInitialInput() {
    return ModelProvider.getInstance().getModel();
  }
  
  public TreeViewer getViewer() {
    return treeViewer;
  }

}
