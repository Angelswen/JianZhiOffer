package com.vechace.question14;

/**
 * ��Ŀ����һ������Ϊn�����ӣ�����m�Σ�m,n��Ϊ��������m>1����ÿ�����ӳ��ȼ�Ϊk[0],k[1],...,k[m],
 * �ʣ�k[0]*k[1]*...*k[m]�����˻�Ϊ���٣����磬����Ϊ8ʱ������2,3,3���Σ��ɵõ����˻�18.
 * @author vechace
 * date: 2018/7/22
 */
public class maxProductAfterCutting {
	
	/**
	 * �ⷨһ����̬�滮��ʱ�临�Ӷ�ΪO(n^2),�ռ临�Ӷ�ΪO(n)
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
	 * �ⷨ����̰���㷨��ʱ�临�Ӷ���ռ临�ӶȾ�ΪO(1)
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
		
		System.out.println("�ⷨ1�� "+maxProductAfterCutting_v1(8));
		System.out.println("�ⷨ2�� "+maxProductAfterCutting_v2(8));

	}

}
