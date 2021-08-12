//JAVA PROGRAM FOR KRUSKAL'S ALGORITHM

public class Kruskals{
	 static int v=9;
	 static int[] parent=new int[v];
	static int INF=Integer.MAX_VALUE;
	public static void main(String[] args)
	{  
		
	//int c[][]= {{INF,2,INF,6,INF},{2,INF,3,8,5},{INF,3,INF,INF,7},{6,8,INF,INF,9},{INF,5,7,9,INF}};
		int c[][]= {{INF,4,INF,INF,INF,INF,INF,8,INF},
				{4,INF,8,INF,INF,INF,INF,11,INF},
				{INF,8,INF,7,INF,4,INF,INF,2},
				{INF,INF,7,INF,9,14,INF,INF,INF},
				{INF,INF,INF,9,INF,10,INF,INF,INF},
				{INF,INF,4,14,10,INF,2,INF,INF},
				{INF,INF,INF,INF,INF,2,INF,1,6},
				{8,11,INF,INF,INF,INF,1,INF,7},
				{INF,INF,2,INF,INF,INF,6,7,INF},
				};
	   kruskalMST(c);
	  
	}
	static void kruskalMST(int c[][])
	{
		int mincost=0;
		int edge_count=0;
		//creating parent array
		for(int i=0;i<v;i++)
		  parent[i]=i;
		while(edge_count<v-1)
		{
			int min=INF,a=-1,b=-1;
			for(int i=0;i<v;i++)
			{
				for(int j=0;j<v;j++)
				{
					if(find(i)!=find(j) && c[i][j]<min)
					{
						min=c[i][j];
						a=i;
						b=j;
					}
				}
			}
			union1(a,b);	
			System.out.printf("Edge %d: (%d,%d) cost:%d\n",edge_count++,a,b,min);
			mincost +=min;
			}
		System.out.printf("Minimum cost=%d\n", mincost);
	}
	static int find(int i) {
		while(parent[i]!=i)
			i=parent[i];
		return i;
	}
	 static void union1(int i,int j) {
		int a=find(i);
		int b=find(j);
		parent[a]=b;
	}
}
