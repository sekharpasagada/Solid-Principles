package org.sekhar.pojo;

public class ServiceLevelAgreement {

	private int problemResolutionTime;
	private int minimumTimeUpPercent;

	public ServiceLevelAgreement(int minimumTimeUpPercent,int problemResolutionTime) {
		this.minimumTimeUpPercent = minimumTimeUpPercent;
		this.problemResolutionTime = problemResolutionTime;
	}

	public int getProblemResolutionTime() {
		return problemResolutionTime;
	}

	public int getMinimumTimeUpPercent() {
		return minimumTimeUpPercent;
	}
	
	
	
}
