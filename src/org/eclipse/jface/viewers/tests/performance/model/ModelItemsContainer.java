/*
 *-------------------------------------------------------------------------
 * Copyright 2009 by AIRBUS France
 *-------------------------------------------------------------------------
 */
package org.eclipse.jface.viewers.tests.performance.model;

/**
 * @author chemouil
 */
public class ModelItemsContainer {

  private ModelItem[] items;

  public ModelItemsContainer(ModelItem[] items) {

    this.items = items;
  }

  public ModelItem[] getItems() {
    return items;
  }

  public String toString() {
    return "Model Items";
  }

}
