package com.ml.test.alg;

public class BinarySearch {

	public static void main(String[] args) {
	
		int[] ints = new int[]{1,2,3,4,5,6,7,8,9};
		System.out.println(dBiSearch(ints, 2, 0, ints.length-1));
	}
	
	public static int biSearch(int[] ints, int key) {
		int from = 0;
		int to = ints.length -1;
		int middle;
		while (from <= to) {
			middle = (from + to)/2;
			if (ints[middle] == key) {
				return middle+1;
			} else if (ints[middle] < key) {
				from = middle +1;
			} else {
				to = middle - 1;
			}
		}
		return -1;
	}
	
	public static int dBiSearch(int[] ints, int key, int from, int to) {
		if (from <= to) {
			int	middle = (from + to)/2;
			if (ints[middle] == key) {
				return middle+1;
			} else if (ints[middle] < key) {
				from = middle +1;
			} else {
				to = middle - 1;
			}
		} else {
			return -1;
		}
		return dBiSearch(ints, key, from, to);
	}
}
