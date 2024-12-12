package org.miu.lesson8.prob2;

import java.util.List;
public class Statistics {
	/** 
	 * Polymorphically computes and returns the sum
	 * of all the salaries of all the staff/teachers in the list.
	 */
	public static double computeSumOfSalaries(List<EmployeeData> aList) {
		if(aList == null || aList.isEmpty()) return 0;
		double sum = 0;
		for(EmployeeData d : aList) {
			if(d==null) continue;
			sum += d.getSalary();
		}
		return sum;
	}
}
