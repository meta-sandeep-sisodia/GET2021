import java.util.Scanner;

class shoppingcart
{
	static String store[][];
	static String cart[][];
	public static Scanner scanner=new Scanner(System.in);
	public static void main(String args[])
	{
		openStore();
	}
	public static void openStore()
	{
		int default_capacity=10;
		cart=new String[default_capacity][2];// 2-name,quantity
		// Considering the store has a predefined items only
		store=new String[][]{{"Pepsi","10","35"},{"Maggie","20","15"},{"Lays","10","10"},{"Cake","10","20"}};
		printStock();
		printUsermenu();
	}
	public static void printStock()
	{
		System.out.println("STOCK AVAILABLE\nNAME\t\tRATE\t\tQUANTITY");
		for(int a=0;a<store.length;a++)
		{
			System.out.println(store[a][0]+"\t\t"+store[a][1]+"\t\t"+store[a][2]);
		}
	}
	public static void printUsermenu()
	{
		System.out.println("1-Add items to cart");
		System.out.println("2-Remove items from cart");
		System.out.println("3-Checkout");
		switch(scanner.nextInt())
		{
		case 1:addItem();break;
		case 2:removeItem();break;
		case 3:checkOut();break;
		default:System.out.println("Invalid option");printUsermenu();
		}
		
	}
	public static void checkOut() {
		// TODO Auto-generated method stub
		
	}
	public static void addItem()
	{
		int quantity;
		System.out.println("Select from items below to add");
		for(int a=1;a<=store.length;a++)
		{
			System.out.println(a+" "+store[a-1][0]);
		}
		int choice=scanner.nextInt();
		if(choice>0&choice<=store.length)
		{
			System.out.println("Enter the quantity for "+store[choice][0]);
			quantity=scanner.nextInt();
			int position_of_item=-1;
			int position_of_last_item=-1;
			for(int a=0;a<cart.length;a++)
			{
				if(store[choice-1][0].equals(cart[a][0]))
				{
					position_of_item=a;
					break;
				}
				else
				{
					if(cart[a][0].isEmpty())
					{
						position_of_last_item=a;
					}
					break;
				}
			}
			// Insert into cart
			if(position_of_item!=-1)
			{
				cart[position_of_item][1]+=quantity;
			}
			else if(position_of_last_item!=-1)
			{
				
			}
		}
	}
	public static void removeItem()
	{
		
	}
}