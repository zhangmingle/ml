package com.ml.test.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortAlg {

	public static void main(String[] args) {
		
		int[] ints = new int[]{7,8,9,4,5,6,3,2};
/*		SortAlg.bubbleSort(ints);
		for (int i =0;i<ints.length;i++) {
			System.out.print(ints[i]);
		}
		System.out.println("");*/
/*		SortAlg.quickSort(ints, 0, ints.length-1);
		for (int i =0;i<ints.length;i++) {
			System.out.print(ints[i]);
		}*/
		
		Random ran = new Random(10);
		for (int i=1;i<1000;i++) {
			System.out.println(ran.nextFloat());
		}
	}
	
	private static void bubbleSort(int[] ints) {
		for (int i = 0; i < ints.length -1; i++) {
			for (int j = 0; j < ints.length - i - 1; j++) {
				if (ints[j] > ints[j+1]) {
					int temp = ints[j];
					ints[j] = ints[j+1];
					ints[j+1] = temp;
				}
			}
		}
	}
	
	private static void quickSort(int[] a,int l, int r) {

		if (l < r) {
			int i =l;
			int j = r;
			int key = a[l];
			
			while (j > i) {
				while (i < j && a[j] > key) {
					j--;
				}
				if (i < j) {
					a[i++] = a[j];
				}
				while (i < j && a[i] < key) {
					i++;
				}
				if (i < j) {
					a[j--] = a[i];
				}
			}
			a[i] = key;
	        quickSort(a, l, i-1); /* 递归调用 */
	        quickSort(a, i+1, r); /* 递归调用 */
	    }
}
}
