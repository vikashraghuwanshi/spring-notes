package com.vikash.notes;

public class BaseEntity {

   public void setNew(boolean aNew) {
      isNew = aNew;
   }

   public boolean isNew() {
      return isNew;
   }

   private transient boolean isNew;




}
