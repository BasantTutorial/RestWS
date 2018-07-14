package com.core.iv;

import java.util.ArrayList;
import java.util.List;

public class FindSumOfEvenPosition {

	public static void main(String[] args) {
		int sum = 0;
		List<Integer> al = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			al.add(i);
		}
		for (int j = 2; j <= al.size(); j = j + 2) {
			sum = sum + j;
		}
		System.out.println("Sum Of Even Position digit: " + sum);
	}

}
