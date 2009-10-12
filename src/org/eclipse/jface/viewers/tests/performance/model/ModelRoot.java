/*
 *-------------------------------------------------------------------------
 * Copyright 2009 by AIRBUS France
 *-------------------------------------------------------------------------
 */
package org.eclipse.jface.viewers.tests.performance.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author chemouil
 *
 */
public class ModelRoot {
  
  
  private List<ModelItem> items;


  public ModelRoot() {
    items = Collections.synchronizedList(new ArrayList<ModelItem>());
    
  }
  
  
  public List<ModelItem> getItems() {
    return items;
  }
    

}
