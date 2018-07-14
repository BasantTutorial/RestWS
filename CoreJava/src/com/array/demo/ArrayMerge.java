package com.array.demo;

import java.util.Arrays;

public class ArrayMerge {
	public static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int i;
		int j;
		for (i = 0; i < a.length; i++)
			c[i] = a[i];

		for (j = 0; j < b.length; j++)
			c[i++] = b[j];
		return c;
	}

	public static void sort(int[] input) {
		int temp = 0;
		for (int i = 0; i <= input.length - 1; i++) {
			for (int j = i + 1; j <= input.length - 1; j++) {
				if (input[i] > input[j]) {
					temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
			System.out.print(input[i]);
		}
	}

	public static void main(String[] args) {
		System.out.println("After Merge: "
				+ Arrays.toString(merge(new int[] { 2, 8, 9 }, new int[] { 4,
						0, 5 })));

		sort(merge(new int[] { 2, 8, 9 }, new int[] { 4, 0, 5 }));
	}
}
