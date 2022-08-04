package banking;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankDetails C = new BankDetails();
		int ch;
		do {
			System.out.println("\n**Banking Syatem Application**");
			System.out.println("1. Create Account\n 2. Check Balance\n 3. Deposit the Amount\n 4. Withdrawl the amount\n 5. Exit");
			System.out.println("Enter your Choice");
			ch = sc.nextInt();
			switch(ch) {
				case 1:
					C.openAccount();
					break;
				case 2:
					C.checkBalance();
					break;
				case 3:
					C.deposit();
					break;
				case 4:
					C.withdraw();
					break;
				case 5:
					System.out.println("See you soon...");
					break;
			}
		}
		while(ch!=5);

	}

}
