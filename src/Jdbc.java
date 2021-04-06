import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class Jdbc
{
	static Connection connection;
	static String user_name;
	static String password;
	static Scanner scanner = new Scanner(System.in);
	static final String url = "jdbc:mysql://localhost:3306/information_schema";

	public static void establishConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e)
		{
			System.out.println("Driver class not found.");
			System.exit(0);
		}
		while(true)
		{
			System.out.println("Please enter the user name");
			user_name = scanner.nextLine();
			System.out.println("Please enter the password");
			password = scanner.nextLine();
			// establish the connection
			try
			{
				connection = DriverManager.getConnection(url, user_name, password);
				break;
			}
			catch(Exception e)
			{
				System.out.println("Please enter correct credentials");
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
		if(connection == null)
		{
			System.out.println("Connection is not established");
			System.exit(0);
		}
		else
		{
			System.out.println("Connection successfully established");
		}
	}
	
	public static int takeUserInputForCustomerID()
	{
		int costumer_id;
		while (true)
		{
			System.out.println("Enter the customer id");
			try
			{
				costumer_id = Integer.parseInt(scanner.nextLine());
				break;
			}
			catch (Exception e)
			{
				System.out.println("Enter the correct customer id");
			}
		}
		return costumer_id;
	}
	
	public static ResultSet searchByCustomerID()
	{
		String query = "SELECT orders.ID, DATE(orders.OrderTime) AS 'Order Date', SUM(ProductQuantity * ProductPrice) AS 'Order Total' FROM orders JOIN order_detail ON orders.ID = order_detail.OrderID"
				+"WHERE orders.UserID = ? AND order_detail.status='SHIPPED'"
				+"GROUP BY orders.ID ORDER BY orders.OrderTime;";
		return null;	
	}

	public static void insertImagesInBatch() throws SQLException
	{
		String query = "";
	}

	public static ResultSet displayCategories() throws SQLException
	{
		String query = "SELECT c1.Title, COUNT(*) FROM category c1 JOIN category c2 WHERE c1.ParentID=c2.ID GROUP BY c1.ParentID HAVING c1.ParentID IN (SELECT category.ID FROM category where category.ID = category.ParentID);";
		PreparedStatement preparedStatementForCateogory = connection.prepareStatement(query);
		ResultSet result = preparedStatementForCateogory.executeQuery();
		return result;
	}

	public static void deleteProduct() throws SQLException
	{
		String query = "DELETE FROM product WHERE product.id NOT IN (SELECT p.ID FROM (SELECT p.ID FROM orders JOIN order_detail ON order.ID = order_details.OrderID JOIN product p on p.ID = order_detail.productID WHERE orders.OrderTime >= DATE_SUB(NOW(), INTERVAL 1 YEAR)";
		PreparedStatement statementForProducts = connection.prepareStatement(query);
		ResultSet result = statementForProducts.executeQuery();
	}

	public static void main(String[] args) throws Exception
	{
		establishConnection();
		System.out.println("Please select from the following options");
		System.out
				.println("1.Given the id of a user, fetch all orders (Id, Order Date, Order Total) of that user which are in shipped state. Orders should be sorted by order date column in chronological order");
		System.out
				.println("2.Insert five or more images of a product using batch insert technique.");
		System.out
				.println("3.Delete all those products which were not ordered by any Shopper in last 1 year. Return the number of products deleted.");
		System.out
				.println("4.Select and display the category title of all top parent categories sorted alphabetically and the count of their child categories.");
		System.out.println("5.Exit");
		while (true)
		{
			boolean checkLoop = false;
			System.out.println("Please enter your choice");
			int choice;
			try
			{
				choice = Integer.parseInt(scanner.nextLine());
			}
			catch (Exception e)
			{
				System.out.println("Please enter the correct choice");
				continue;
			}
			switch (choice)
			{
				case 1 :
						ResultSet result = searchByCustomerID();
						if (result == null || result.next() == false)
						{
							System.out.println("No results fetched for the given customer id");
							continue;
						}
						else
						{
							printResult(result);
						}
						break;
				case 2 :
						try
						{
							insertImagesInBatch();
						}
						catch (SQLException e)
						{
							System.out.println("Query Failed" + e);
						}
						break;
				case 3 :
						try
						{
							deleteProduct();
							System.out.println("Successfully executed the required operation");
						} 
						catch (SQLException e)
						{
							System.out.println("Incorrect Query" + e);
						}
						break;
				case 4 :
						try 
						{
							result = displayCategories();
						}
						catch (SQLException e)
						{
							System.out.println(e);
							continue;
						}
						printCategories(result);
				case 5 :
						checkLoop = true;
						break;
				default :
						System.out.println("Please enter the correct choice");
					break;
			}
			if (checkLoop)
			{
				break;
			}
		}
	}

	private static void printCategories(ResultSet result)
	{
		
	}
	private static void printResult(ResultSet result)
	{
		
	}
}