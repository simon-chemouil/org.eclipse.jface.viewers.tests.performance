/*
 *-------------------------------------------------------------------------
 * Copyright 2009 by AIRBUS France
 *-------------------------------------------------------------------------
 */
package org.eclipse.jface.viewers.tests.performance.model;

/**
 * 
 * Singleton class which provides easy access to the current input model 
 * and its helper objects
 * 
 * @author chemouil
 */
public class ModelManager {

  private static ModelManager instance;

  private ModelItemsContainer currentItemsContainer;

  private ModelRoot currentItemsContainerRoot;

  private ModelRoot currentModelRoot;

  public static synchronized ModelManager getInstance() {
    if (instance == null) {
      instance = new ModelManager();
    }
    return instance;
  }

  private ModelManager() {
      
  }

  public void setCurrentModelRoot(ModelRoot mr) {
    currentModelRoot = mr;
  }
  
  /*
   * It's up to the user to keep this up to date
   */
  public ModelRoot getCurrentModelRoot() {
    return currentModelRoot;
  }
  
  
  /*
   * Returns the container
   * Required to get a matchable type because of the type erasure on List
   * (we can have several ModelItem-like types)
   */
  public synchronized ModelItemsContainer getCurrentItemContainer(ModelRoot mr) {

    if (currentItemsContainer == null || mr != currentItemsContainerRoot) {
      currentItemsContainer = new ModelItemsContainer(mr.getItems().toArray(
          new ModelItem[mr.getItems().size()]));
      currentItemsContainerRoot = mr;
    }
    return currentItemsContainer;
  }

  
}
