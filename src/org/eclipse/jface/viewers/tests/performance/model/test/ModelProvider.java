/*
 *-------------------------------------------------------------------------
 * Copyright 2009 by AIRBUS France
 *-------------------------------------------------------------------------
 */
package org.eclipse.jface.viewers.tests.performance.model.test;

import java.util.Random;

import org.eclipse.jface.viewers.tests.performance.model.ModelItem;
import org.eclipse.jface.viewers.tests.performance.model.ModelRoot;
import org.eclipse.jface.viewers.tests.performance.model.ModelItem.Kind;



/**
 * Singleton class which provides a voluminous test model, meant to be tuned for volumetrics tests
 * 
 * @author chemouil
 *
 */
public class ModelProvider {
  
  
  private static ModelProvider instance;
  private ModelRoot modelRoot;
  

  public static synchronized ModelProvider getInstance() {
    if (instance == null) {
      instance = new ModelProvider();
    }
    return instance;
  }

  private ModelProvider() {
    modelRoot = new ModelRoot();
    
    
    final Random rand = new Random();
    
    ModelItem item = null;
    
    // Generates items with unique name and random kind    
    for (int i = 0; i < 10000; ++i) {    
      item = new ModelItem("Item #" + String.valueOf(i), rand.nextBoolean() ? Kind.A : Kind.B);
      modelRoot.getItems().add(item);
    }
    
  }
  
  
  public ModelRoot getModel() {
    return modelRoot;
  }
  

}
