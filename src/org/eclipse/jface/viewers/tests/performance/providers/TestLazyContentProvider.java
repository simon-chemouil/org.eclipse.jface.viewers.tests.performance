/*
 *-------------------------------------------------------------------------
 * Copyright 2009 by AIRBUS France
 *-------------------------------------------------------------------------
 */
package org.eclipse.jface.viewers.tests.performance.providers;

import org.eclipse.jface.viewers.ILazyTreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.tests.performance.model.ModelItem;
import org.eclipse.jface.viewers.tests.performance.model.ModelItemsContainer;
import org.eclipse.jface.viewers.tests.performance.model.ModelManager;
import org.eclipse.jface.viewers.tests.performance.model.ModelRoot;

/**
 * @author chemouil
 */
public class TestLazyContentProvider implements ILazyTreeContentProvider {

  private TreeViewer treeViewer;

  /**
   * @param viewer
   */
  public TestLazyContentProvider(TreeViewer viewer) {
    treeViewer = viewer;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.jface.viewers.ILazyTreeContentProvider#getParent(java.lang.Object)
   */
  public Object getParent(Object element) {
    if (element instanceof ModelRoot) {
      return null;
    }
    else if (element instanceof ModelItemsContainer) {
      return ModelManager.getInstance().getCurrentModelRoot();
    }
    else if (element instanceof ModelItem) {
      /*
       * In a larger scenario, we have multiple instances of ModelRoots, so we need to dissociate
       * them
       */
      return ModelManager.getInstance().getCurrentItemContainer(
          ModelManager.getInstance().getCurrentModelRoot());

    }
    else {
      return null;
    }
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.jface.viewers.ILazyTreeContentProvider#updateChildCount(java.lang.Object, int)
   */
  public void updateChildCount(Object element, int currentChildCount) {
    if (element instanceof ModelRoot) {
      // One ModelItemsContainer only
      // Could have more stuff if we had other ModelItem types (and the associated containers)
      treeViewer.setChildCount(element, 1);
    }
    else if (element instanceof ModelItemsContainer) {
      treeViewer.setChildCount(element, ((ModelItemsContainer)element).getItems().length);
    }

    /* else, no action, 0 children */
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.jface.viewers.ILazyTreeContentProvider#updateElement(java.lang.Object, int)
   */
  public void updateElement(Object parent, int index) {
    if (parent instanceof ModelRoot) {
      ModelRoot modelRoot = (ModelRoot) parent;
            
      // One virtual child that we create, the ModelItemsContainer
      // the ModelManager provides a cache
      ModelItemsContainer container = ModelManager.getInstance().getCurrentItemContainer(modelRoot);
      treeViewer.replace(parent, index, container);
      // Likely to have children
      treeViewer.setHasChildren(container, true);      
    }
    
    else if (parent instanceof ModelItemsContainer) {
      ModelItemsContainer container = (ModelItemsContainer) parent;      
      treeViewer.replace(parent, index, container.getItems()[index]);
    }
    

  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.jface.viewers.IContentProvider#dispose()
   */
  public void dispose() {

  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
   * java.lang.Object, java.lang.Object)
   */
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

  }

}
