import java.util.*;
public class Test
{
  int count=0;
  Random r=new Random();
  void read(int a[],int n)
  { for(int i=0;i<n;i++)
        a[i]=r.nextInt(n-1)+1;
  }
  void quicksortrecursion(int a[],int low,int high)
  {
    int pi=partition(a,low,high);
    if(low<pi-1)
        quicksortrecursion(a, low,pi-1);
    if(high>pi)
        quicksortrecursion(a,pi, high);
  }
  int partition(int a[],int low,int high)
  {
    int p=a[(low+high)/2];
    while(low<=high)
    {
      while(a[low]<p)
         low++;
      while(a[high]>p)
         high--;
      if(low<=high)
      {
        int temp=a[low];
        a[low]=a[high];
        a[high]=temp;
        low++;
        high--;
      }
    }
    return low;
  }
  void print(int a[],int n)
  {
    for(int i:a)
    {
      System.out.println(i);
      count++;
    }
    System.out.println("count "+count);
  }
  public static void main(String[] args)
  {
    System.out.println("Enter total numbers vlaues(>5000");
    Scanner s=new Scanner(System.in);
    int n=s.nextInt();
    Test t=new Test();
    int[] a=new int[n];
    System.out.println("enter numbers:");
    t.read(a,n);
    System.out.println("Before sorting:");
    for (int i:a)
        System.out.println(i);
    long startTime=System.nanoTime();
    System.out.println("After sorting:");
    long stopTime=System.nanoTime();
    t.quicksortrecursion(a,0,n-1);
    t.print(a,n);
    double elapsedTime=(float)((stopTime-startTime)/Math.pow(10,6));
    System.out.println("Complexity is "+elapsedTime+"ms");
    s.close();
  }
}
