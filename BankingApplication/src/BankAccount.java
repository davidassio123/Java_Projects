import java.util.Scanner;

public class BankAccount 
{
	double balance;
	double previousTransaction;
	String customerName;
	String customerId;
	static int MAX_NUMBER_OF_DECIMALS = 2;
	
	BankAccount(String name, String id)
	{
		customerName = name;
		customerId = id;
	}
	
	void deposit(double amount) 
	{
		if(amount != 0) 
		{
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(double amount)
	{
		if(amount != 0)
		{
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	void getPreviousTransaction()
	{
		if(previousTransaction > 0)
		{
			System.out.printf("You just deposited $%.2f.%n", previousTransaction);
		}
		else if(previousTransaction < 0)
		{
			System.out.printf("You just withdrew $%.2f.%n", Math.abs(previousTransaction));
		}
		else
		{
			System.out.println("No transaction occured.");
		}
	}
	
	void showMenu()
	{
		String option;
		Scanner in = new Scanner(System.in);
		
		System.out.printf("Welcome %s.%n", customerName);
		System.out.printf("Your ID is %s.%n", customerId);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("A. Check Balance.");
		System.out.println("B. Deposit.");
		System.out.println("C. Withdraw.");
		System.out.println("D. View Previous Transaction");
		System.out.println("E. Exit.");
		
		System.out.println("-------------------------------------------------");
		System.out.print("Enter an option: ");
		while(in.hasNext())
		{
			
			option = in.next();
			
			if(option.compareToIgnoreCase("a") == 0)
			{
				System.out.printf("Current balance: $%.2f.%n", balance);
				System.out.println("-------------------------------------------------");
				System.out.print("Enter an option: ");
			}
			else if(option.compareToIgnoreCase("b") == 0)
			{
				System.out.print("Enter an amount to deposit: ");
				
				double amount = in.nextDouble();
				String s = "" + amount;
				String[] result = s.split("\\.");
				while(result[1].length() > MAX_NUMBER_OF_DECIMALS)
				{
					System.out.println("Invalid amount! Amount must have no more than two decimals.");
					System.out.print("Try again: ");
					amount = in.nextDouble();
					s = "" + amount;
					result = s.split("\\.");
				}
				deposit(amount);
				
				System.out.printf("$%.2f deposited.%n", amount);
				System.out.println("-------------------------------------------------");
				System.out.print("Enter an option: ");
			}
			else if(option.compareToIgnoreCase("c") == 0)
			{
				System.out.print("Enter an amount to withdraw: ");
				
				double amount = in.nextDouble();
				String s = "" + amount;
				String[] result = s.split("\\.");
				while(result[1].length() > MAX_NUMBER_OF_DECIMALS)
				{
					System.out.println("Invalid amount! Amount must have no more than two decimals.");
					System.out.print("Try again: ");
					amount = in.nextDouble();
					s = "" + amount;
					result = s.split("\\.");
				}
				withdraw(amount);
				
				System.out.printf("$%.2f withdrawn.%n", amount);
				System.out.println("-------------------------------------------------");
				System.out.print("Enter an option: ");
			}
			else if(option.compareToIgnoreCase("d") == 0)
			{
				getPreviousTransaction();
				System.out.println("-------------------------------------------------");
				System.out.print("Enter an option: ");
			}
			else if(option.compareToIgnoreCase("e") == 0)
			{
				System.out.println("Thank you for using our services.");
				System.exit(0);
			}
			else
			{
				System.out.print("Invalid input! Please enter a valid option: ");
			}
		}
	}
}
