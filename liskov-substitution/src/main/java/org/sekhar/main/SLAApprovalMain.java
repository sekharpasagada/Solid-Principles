package org.sekhar.main;

import java.util.Arrays;
import java.util.List;

import org.sekhar.pojo.ServiceLevelAgreement;
import org.sekhar.pojo.SubContractor;

public class SLAApprovalMain {

public static void main(String[] args) {
	  int minTimeOffPercent = 95;
      int maxResolutionDays = 3;
      ServiceLevelAgreement companySla = new ServiceLevelAgreement(
              minTimeOffPercent,
              maxResolutionDays);

      // Get collaborators from their own source
      SubContractor subcontractor1 = new SubContractor(
              "Rebekah Jackson",
              "rebekah-jackson@abc.com",
              3000,
              15);
      SubContractor subcontractor2 = new SubContractor(
              "Harry Fitz",
              "harryfitz@def.com",
              3000, 15);

      List<SubContractor> collaborators = Arrays.asList(subcontractor1, subcontractor2);

      for (SubContractor subContractor : collaborators) {
		subContractor.approveSLA(companySla);
	}
      

}
	
}
