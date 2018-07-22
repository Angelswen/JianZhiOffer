package com.vechace.question14;

/**
 * 题目：将一根长度为n的绳子，剪成m段（m,n均为正数，且m>1），每段绳子长度记为k[0],k[1],...,k[m],
 * 问，k[0]*k[1]*...*k[m]的最大乘积为多少，例如，长度为8时，剪成2,3,3三段，可得到最大乘积18.
 * @author vechace
 * date: 2018/7/22
 */
public class maxProductAfterCutting {
	
	/**
	 * 解法一：动态规划，时间复杂度为O(n^2),空间复杂度为O(n)
	 * @param length
	 * @return
	 */
	public static int maxProductAfterCutting_v1(int length){
		
		if(length < 2)
			return 0;
		if(length ==2)
			return 1;
		if(length ==3)
			return 2;
		
		int[] products = new int[length +1];
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;
		
		int max = 0;
		for(int i = 4;i <= length;i++){
			max = 0;
			for(int j =1;j<=i/2;j++){
				int product = products[j]*products[i-j];
				if(max <product){
					max = product;
				}
				products[i] = max;
			}
		}
		
		max = products[length];
		return max;
	}
	
	/**
	 * 解法二：贪心算法，时间复杂度与空间复杂度均为O(1)
	 * @param length
	 * @return
	 */
	public static int maxProductAfterCutting_v2(int length){
		
		if(length < 2)
			return 0;
		if(length ==2)
			return 1;
		if(length ==3)
			return 2;
		
		int timesOf3 = length/3;
		if(length-timesOf3*3 == 1){
			timesOf3 -= 1;
		}
		
		int timesOf2 = (length -timesOf3*3)/2;
		int max = (int)(Math.pow(3, timesOf3))*(int)(Math.pow(2, timesOf2));
		return max;
	}

	public static void main(String[] args) {
		
		System.out.println("解法1： "+maxProductAfterCutting_v1(8));
		System.out.println("解法2： "+maxProductAfterCutting_v2(8));

	}

}
