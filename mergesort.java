//JAVA PROGRAM FOR MERGE SORT


import java.util.*;

class Mergesort {
	int count=0;
	int[] array;
	int[] tempMergeArr;
	int length;
	Random r=new Random();
	void read(int inputarr[],int n)
	{
		for(int i=0;i<n;i++)
			inputarr[i]=r.nextInt(n-1)+1;
	}
	void sort(int inputarr[])
	{
		this.array=inputarr;
		this.length=inputarr.length;
		this.tempMergeArr=new int[length];
		divideArray(0,length-1);
	}
	void divideArray(int lowerindex,int higherindex)
	{
		if(lowerindex<higherindex)
		{
			int middle=lowerindex+(higherindex-lowerindex)/2;
			//it will sort the left side of an array
			divideArray(lowerindex,middle);
			//it will sort the right side of an array
			divideArray(middle+1,higherindex);
			mergeArray(lowerindex,middle,higherindex);
		}
	}
	void mergeArray(int lowerindex,int middle,int higherindex)
	{
		for(int i=lowerindex;i<=higherindex;i++)
			tempMergeArr[i]=array[i];
		int i=lowerindex;
		int j=middle+1;
		int k=lowerindex;
		while(i<=middle && j<=higherindex)
		{
			if(tempMergeArr[i]<=tempMergeArr[j]) {
				array[k]=tempMergeArr[i];
				i++;
			}
			else {
				array[k]=tempMergeArr[j];
				j++;
			}
			k++;
		}
		while(i<=middle)
		{
			array[k]=tempMergeArr[i];
			k++;
			i++;
		}
	}
	void printArray(int inputarr[])
	{
		for(int i:inputarr) {
			System.out.println(i);
			count++;}
		System.out.println("count="+count);
	}
	public static void main(String[] args)
	{
		
		System.out.println("enter total number of value (>5000):");
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] inputarr;
		inputarr=new int[n];
		System.out.println("enter elements");
		Mergesort ms=new Mergesort();
		ms.read(inputarr,n);
		System.out.println("Before sorting:");
		for(int i:inputarr)
			  System.out.println(i);
		long startTime =System.nanoTime();
		System.out.println("After sorting:");
		long stopTime=System.nanoTime();
		ms.sort(inputarr);;
		ms.printArray(inputarr);
		double elapsedTime=(float)(stopTime-startTime)/Math.pow(10, 6);
		System.out.println("Merge Sort Complexity="+elapsedTime+"ms");
		s.close();
	}
}
