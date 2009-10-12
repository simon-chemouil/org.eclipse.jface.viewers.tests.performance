/*
 *-------------------------------------------------------------------------
 * Copyright 2009 by AIRBUS France
 *-------------------------------------------------------------------------
 */
package org.eclipse.jface.viewers.tests.performance.providers;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.tests.performance.model.ModelItem;
import org.eclipse.jface.viewers.tests.performance.model.ModelItemsContainer;
import org.eclipse.jface.viewers.tests.performance.model.ModelManager;
import org.eclipse.jface.viewers.tests.performance.model.ModelRoot;

/**
 * @author chemouil
 */
public class TestStandardContentProvider implements ITreeContentProvider {

  /*
   * (non-Javadoc)
   * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
   */
  public Object[] getChildren(Object parent) {
    if (parent instanceof ModelRoot) {
      ModelRoot modelRoot = (ModelRoot) parent;
            
      // One virtual child that we create, the ModelItemsContainer
      // the ModelManager provides a cache
      ModelItemsContainer container = ModelManager.getInstance().getCurrentItemContainer(modelRoot);
      return new Object[] { container };

    }
    
    else if (parent instanceof ModelItemsContainer) {
      ModelItemsContainer container = (ModelItemsContainer) parent;      
      return container.getItems();
    }
    
    return null;
    
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
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
   * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
   */
  public boolean hasChildren(Object element) {
    return (element instanceof ModelRoot || (element instanceof ModelItemsContainer && ((ModelItemsContainer) element)
        .getItems().length > 0));
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
   */
  public Object[] getElements(Object inputElement) {
    return getChildren(inputElement);
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.jface.viewers.IContentProvider#dispose()
   */
  public void dispose() {
    // TODO Auto-generated method stub

  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
   * java.lang.Object, java.lang.Object)
   */
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    // TODO Auto-generated method stub

  }

}
