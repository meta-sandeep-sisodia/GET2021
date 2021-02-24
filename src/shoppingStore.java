public class shoppingStore
{
	private static String store[][];
	public shoppingStore()
	{
		store=new String[][]{
				{"PEP1","pepsi","35","10"},
				{"CAK1","Cake","20","20"},
				{"MAG1","Maggie","15","10"},
				{"LAY1","Lays small","10","10"},
				{"LAY2","Lays big","30","10"}
				};
		System.out.println("---------------Welcome to the Store------------");
	}
	public String getCode(int index)
	{
	return store[index-1][0];	
	}
	public String getName(int index)
	{
	return store[index-1][1];	
	}
	public int getRate(int index)
	{
		return Integer.parseInt(store[index-1][2]);
	}
	public int getQuantity(int index)
	{
		return Integer.parseInt(store[index-1][3]);
	}
	public void getStock()
	{
		System.out.printf("%-7s%-15s%-15s%10s%10s\n","SR.No","ITEM CODE","ITEM NAME","RATE","QUANTITY");
		printBreak();
		for(int a=0;a<store.length;a++)
		{
			System.out.printf("%-7s%-15s%-15s%10s%10s\n",a+1,store[a][0],store[a][1],store[a][2],store[a][3]);
		}
		printBreak();
	}
	public void printBreak()
	{
		System.out.println("-------------------------------------------------------------");
	}
}
