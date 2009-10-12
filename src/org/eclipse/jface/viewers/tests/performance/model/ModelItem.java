/*
 *-------------------------------------------------------------------------
 * Copyright 2009 by AIRBUS France
 *-------------------------------------------------------------------------
 */
package org.eclipse.jface.viewers.tests.performance.model;


/**
 * @author chemouil
 *
 */
public class ModelItem {
  
  public static enum Kind { A, B };
  
  private String name;
  private Kind kind;

  
  
  public ModelItem(String name, Kind kind) {
    this.name = name;
    this.kind = kind;
  }


  
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();    
    builder.append(name);
    builder.append(", kind[");
    builder.append(kind);
    builder.append("]");
    return builder.toString();
  }



  /**
   * @return the kind
   */
  public Kind getKind() {
    return kind;
  }


  
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }



  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((kind == null) ? 0 : kind.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }



  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    ModelItem other = (ModelItem) obj;
    if (kind == null) {
      if (other.kind != null) {
        return false;
      }
    }
    else if (!kind.equals(other.kind)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    }
    else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }



  
 

}
