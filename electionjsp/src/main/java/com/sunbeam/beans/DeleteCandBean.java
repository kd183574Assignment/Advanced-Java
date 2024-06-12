// Source code is decompiled from a .class file using FernFlower decompiler.
package com.sunbeam.beans;

import com.sunbeam.dao.CandidateDao;
import com.sunbeam.dao.CandidateDaoImpl;

public class DeleteCandBean {
   private int id;

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public DeleteCandBean(int id) {
      this.id = id;
   }

   public DeleteCandBean() {
   }

   public void deleteCandidate() {
      try {
         CandidateDao cd = new CandidateDaoImpl();
         cd.deleteById(id);
      } catch (Exception e) {
         e.printStackTrace();
      }

   }
}
