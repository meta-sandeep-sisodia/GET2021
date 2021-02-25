import java.util.*;
class shoppingCart
{
	public static Scanner scanner=new Scanner(System.in);
	public static shoppingStore store=new shoppingStore();
	private static ArrayList<String> cart;
	private static int choice;
	private static int quantity;
	private shoppingCart()
	{
		cart=new ArrayList<>();
	}
	public static void main(String[] args)
	{
		new shoppingCart();
		printMenu();
	}
	public static void printMenu()
	{
		Collections.sort(cart);
		System.out.println("1 : Add Item\n2 : Remove Item\n3 : Update Item\n4 : View Cart\n5 : Checkout\n6 : Exit");
		int choice=scanner.nextInt();
		switch(choice)
		{
		case 1:addItem();break;
		case 2:removeItem();break;
		case 3:updateItem();break;
		case 4:viewCart();printMenu();break;
		case 5:checkOut();break;
		case 6:System.exit(-1);break;
		}
	
	}
	private static void viewCart()
	{
		Collections.sort(cart);
		int temp=0;
		String working;
		int lastindex;
		while(temp<cart.size()-1)
		{
			working=cart.get(temp);
			lastindex=cart.lastIndexOf(working);
			System.out.println(working+" --- "+(lastindex-temp+1));
			temp=lastindex+1;
		}
	}
	private static void updateItem()
	{
		viewCart();
		getDetails("Update");
		cart.remove(store.getCode(choice));
		printMenu();
	}
	private static void removeItem()
	{
		viewCart();
		getDetails("remove");
		for(int temp=1;temp<=quantity;temp++)
		{
			cart.remove(store.getCode(choice));
			printMenu();
		}
	}
	private static void addItem()
	{
		store.getStock();
		getDetails("add");
		String code=store.getCode(choice);
		int storequantity=store.getQuantity(choice);
		int cartquantity=Collections.frequency(cart, code);
		if(storequantity>=cartquantity+quantity)
		{
			for(int temp=1;temp<=quantity;temp++)
			{
				cart.add(store.getCode(choice));
			}
		}
		else
		{
			System.out.println("Invalid quantity : Maximum quantity can be = "+store.getQuantity(choice));
		}
		printMenu();
	}
	private static void checkOut() {
		// UnderDevelopment
		
	}
	public static void getDetails(String operation)
	{
		System.out.println("Enter the item's serial number to "+operation+"\t");
		choice=scanner.nextInt();
		System.out.println("Enter the quantity to "+operation+"\t");
		quantity=scanner.nextInt();
	}
}