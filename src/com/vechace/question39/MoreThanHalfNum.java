package com.vechace.question39;

/**
 * ��Ŀ:��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֣����磬����һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�����飬�г�����2�Σ��������鳤�ȵ�һ�㣬������2.
 * @author vechace
 * date: 2018/7/22
 */
public class MoreThanHalfNum {
	
	static boolean inputInvalid = false;
	
	/**
	 * Description: �ⷨ1,ʱ�临�Ӷ�ΪO(n)
	 * @param data
	 * @return
	 */
	public static int MoreThanHalfNum(int data[]){
		
		if(CheckInvalidArray(data)){
			return  0;
		}
		int length = data.length;
		int mid = length >>1;
		int start = 0;
		int end = length -1;
		int index = Partition(data, start, end);
		while(index != mid){
			
			if(index > mid){
				end = index -1;
				index = Partition(data, start, end);
			}else{
				start = index +1;
				index = Partition(data, start, end);
			}
		}
		
		int result = data[mid];
		if(!CheckMoreThanHalf(data, result)){
			result = 0;
		}
		
		return result;
	}
	
	/**
	 * Description: �ⷨ����ʱ�临�Ӷ�ΪO(n)
	 * @param data
	 * @return
	 */
	public static int MoreThanHalfNum_v2(int data[]){
		
		if(CheckInvalidArray(data)){
			return 0;
		}
		
		int result = data[0];
		int times = 1;
		for(int i = 1;i < data.length;i++){
			if(times ==0){
				result = data[i];
				times = 1;
			}else if(data[i] ==result){
				times++;
			}else{
				times--;
			}
		}
		
		if(!CheckMoreThanHalf(data, result)){
			result = 0;
		}
		return result;
	}
	
	/**
	 * Description:�ж������Ƿ�Ϸ�
	 * @param data
	 * @return
	 */
	public static boolean CheckInvalidArray(int data[]){
		
		inputInvalid = false;
		if(data == null || data.length <=0){
			inputInvalid = true;
		}
		return inputInvalid;
	}
	
	/**
	 * Description: ����Ƿ���ڴ����������鳤��һ�������
	 * @param data
	 * @param key
	 * @return
	 */
	public static boolean CheckMoreThanHalf(int data[],int key){
		
		int times = 0;
		for(int i = 0;i < data.length;i++){
			if(data[i] == key){
				times++;
			}
		}
		
		boolean isMoreThanHalf = true;
		if(times*2 <= data.length){
			inputInvalid = true;
			isMoreThanHalf = false;
		}
		return isMoreThanHalf;
	}
	
	/**
	 * Description�� ���֣�����ŵĻ�����ͬ
	 * @param data
	 * @param low
	 * @param high
	 * @return
	 */
	public static int Partition(int data[],int low,int high) {
		
		if(data == null || data.length <=0 || low <0 || high >= data.length){
			return -1;
		}
		int tmp = data[low];
		while(low < high){
			while(low<high && data[high]>=tmp){
				high--;
				
			}
			data[low] = data[high];
			while(low<high && data[low]<=tmp){
				low++;
			}
			data[high] = data[low];
		}
		data[low] = tmp;
		return low;
		
	}
	
	public static void main(String[] args) {
		
		int data[] = {1,1,2,2,2,2,3};
		System.out.println("�ⷨһ�� "+MoreThanHalfNum(data));
		System.out.println("�ⷨ���� "+MoreThanHalfNum_v2(data) );
	}

}
