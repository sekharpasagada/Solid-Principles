package org.sekhar.pojo;

public class SubContractor {

	private String fullName;
	private String email;
	private int monthlyIncome;
	private int numberOfHours;

	public SubContractor(String fullName, String email, int monthlyIncome, int numberOfHours) {
		
		this.fullName = fullName;
		this.email = email;
		this.monthlyIncome = monthlyIncome;
		this.numberOfHours = numberOfHours;
		
	}
	
	public boolean approveSLA(ServiceLevelAgreement agreement)
	{
		boolean result = false;
		if(agreement.getMinimumTimeUpPercent() >= 98 && agreement.getProblemResolutionTime() <=2) {
			result = true;
		}
		   System.out.println("SLA approval for " + this.fullName + ": " + result);
		return result;
	}
	
	
}
