public class ShoppingStore
{
	static String store[][];
	public ShoppingStore()
	{
		store=new String[][]{
				{"101","pepsi","35","10"},
				{"124","Cake","20","20"},
				{"514","Maggie","15","10"},
				{"220","Lays small","10","10"},
				{"221","Lays big","30","10"}
				};
		System.out.println("---------------Welcome to the Store------------");
	}
	public static void getStock()
	{
		System.out.printf("%-7s%-15s%-15s%10s%10s\n","SR.No","ITEM CODE","ITEM NAME","RATE","QUANTITY");
		printBreak();
		for(int a=0;a<store.length;a++)
		{
			System.out.printf("%-7s%-15s%-15s%10s%10s\n",a+1,store[a][0],store[a][1],store[a][2],store[a][3]);
		}
		printBreak();
	}
	public static double getRate(int index)
	{
		return Double.parseDouble(store[index][2]);
	}
	public static int getQuantity(int index)
	{
		return Integer.parseInt(store[index][3]);
	}
	public static void removeItem(int index,int quantity)
	{
		if(getQuantity(index)-quantity>=0)
		{
			store[index][3]=String.valueOf(getQuantity(index)-quantity);
		}
	}
	public static void printBreak()
	{
		System.out.println("-------------------------------------------------------------");
	}
}
