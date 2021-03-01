import java.util.InputMismatchException;
import java.util.Scanner;

class ShoppingCart
{
	static Scanner scanner=new Scanner(System.in);
	static int cart[][];
	public static void main(String args[])
	{
		new ShoppingStore();
		cart=new int[ShoppingStore.store.length][2];
		printMenu();
	}
	public static void printMenu()
	{
		System.out.println("1 : Add Item\n2 : Remove Item\n3 : Update Item\n4 : View Cart\n5 : Checkout\n6 : Exit");
		ShoppingStore.printBreak();
		try
		{
			int choice=scanner.nextInt();
			switch(choice)
			{
			case 1:addItem();printMenu();break;
			case 2:removeItem();printMenu();break;
			case 3:updateItem();printMenu();break;
			case 4:viewCart();printMenu();break;
			case 5:checkOut();break;
			case 6:System.exit(-1);break;
			default:System.out.println("Invalid choice");scanner.nextLine();printMenu();
			}
		}
		catch(InputMismatchException e)
		{
			System.out.print("Enter only Integral value");
			scanner.nextLine();
			printMenu();
		}
	}
	public static void printStatus(boolean status)
	{
		System.out.println(">>>>>>>>>>>>> Operation "+(status==true?"Successfull":"Failed")+"<<<<<<<<<<<<<");
	}
	private static void checkOut()
	{
		double sum=0;
		System.out.println(">>> YOUR BILL <<<");
		for(int loop_var=0;loop_var<cart.length;loop_var++)
		{
			if(cart[loop_var][1]>0)
			{ 
				double cost=(ShoppingStore.getRate(loop_var)*cart[loop_var][1]);
				sum+=cost;
				System.out.printf("%-10s %4d %8.2f \n",ShoppingStore.store[loop_var][1],cart[loop_var][1],cost);
			}
		}
		System.out.println("Your Total >>> Rs. "+sum);
	}
	private static void viewCart()
	{
		System.out.println("\t\t>>> YOUR CART <<<");
		for(int loop_var=0;loop_var<cart.length;loop_var++)
		{
			if(cart[loop_var][1]>0)
			{
				System.out.printf("%-10s-----%-15s\n",ShoppingStore.store[loop_var][1],cart[loop_var][1]);
			}
		}
	}
	private static void updateItem()
	{
		viewCart();
		int choice=getChoice("update");
		int quantity=getQuantity("update (new quantity)");
		try
		{
			if(quantity>=0&&quantity<=ShoppingStore.getQuantity(choice))
			{
				cart[choice][1]=quantity;
				printStatus(true);
			}
			else
			{
				System.out.println("Item quantity can not be more than quantity in store or in negative");
				printStatus(false);
			}
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("Item not present in shopping store");
			printStatus(false);
		}
	}
	private static void removeItem()
	{
		viewCart();
		int choice=getChoice("remove");
		int quantity=getQuantity("remove");
		try
		{
			if(cart[choice][1]-quantity>=0)
			{
				cart[choice][1]=cart[choice][1]-quantity;
				printStatus(true);
			}
			else
			{
				System.out.println("Item quantity to remove can not be more than item quantity in cart");
				printStatus(false);
			}
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("Item not present in shopping store");
			printStatus(false);
		}
	}
	private static void addItem()
	{
		ShoppingStore.getStock();
		int choice=getChoice("add");
		int quantity=getQuantity("add");
		try
		{
			if(quantity+cart[choice][1]<=ShoppingStore.getQuantity(choice))
			{
				cart[choice][1]=cart[choice][1]+quantity;
				cart[choice][0]=Integer.parseInt(ShoppingStore.store[choice][0]);
				printStatus(true);
			}
			else
			{
				System.out.println("Item quantity can not be more than item quantity in store");
				printStatus(false);
			}
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("Item not present in shopping store");
			printStatus(false);
		}
	}
	public static int getChoice(String operation)
	{
		int choice;
		System.out.println("Enter the item's serial number to "+operation+"\t");
		try
		{
			choice=scanner.nextInt();
			if(choice<=0)
			{
				System.out.println("Enter positive integer only");
				scanner.nextLine();
				return getChoice(operation);
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Enter integer value only");
			scanner.nextLine();
			return getChoice(operation);
		}
		return choice-1;
	}
	public static int getQuantity(String operation)
	{
		int quantity;
		System.out.println("Enter the quantity to "+operation+"\t");
		try
		{
			quantity=scanner.nextInt();
			if(quantity<0)
			{
				System.out.println("Enter positive integer only");
				scanner.nextLine();
				return getQuantity(operation);
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Enter integer value only");
			scanner.nextLine();
			return getQuantity(operation);
		}
		return quantity;
	}
}