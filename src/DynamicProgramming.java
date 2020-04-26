/**
 * 老闭给的动态规划秘籍
 */
public class DynamicProgramming{
	
	public static int Test1(int[] price,int budget)
	{
		int[] a=new int[budget+1];
		for(int i=1;i<=budget;i++)
		{
			a[i]=Integer.MAX_VALUE-1;
			for(int j:price)
			{
				if(i<j) continue;
				a[i]=Math.min(a[i], a[i-j]+1);
			}
		}
		return a[budget]==Integer.MAX_VALUE-1?-1:a[budget];
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] price={5,20,100,200};
		int budget=200;
		System.out.println(Test1(price,budget));

	}

}
