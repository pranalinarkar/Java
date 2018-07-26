package assign2;

import java.util.*;
import java.util.stream.Collectors;

import collection.Test;

public class App {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Branch b = new Branch();
		b.openNewAccount(AccountType.SAVINGS, 50000, "Pranali");
		b.openNewAccount(AccountType.CURRENT, 10000, "Priyal");
		b.openNewAccount(AccountType.CURRENT, 40000, "Nikhil");
		b.openNewAccount(AccountType.SAVINGS, 30000, "Shreyas");
		b.openNewAccount(AccountType.SAVINGS, 50000, "Payal");
		b.openNewAccount(AccountType.CURRENT, 10000, "Akshata");
		b.openNewAccount(AccountType.CURRENT, 35000, "Nivedita");
		b.openNewAccount(AccountType.SAVINGS, 20000, "Diksha");
		b.openNewAccount(AccountType.SAVINGS, 19800, "Megha");
		b.openNewAccount(AccountType.CURRENT, 13000, "Sonali");

		Set set = b.searchByHolderName("Priyal");
		Iterator<Account> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}

		LinkedList list = b.getALL();
		Iterator<Account> it1 = list.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next().toString());
		}
		Transaction t = new Transaction(b);
		System.out.println("Withdrawing 5000 from priyal");
		t.withdraw(100437L, 5000);
		System.out.println("Withdrawing 5000 from shreyas");
		t.withdraw(100439L, 5000);

		System.out.println("Transfering 3000 from priyal to shreyas");
		t.transfer(100437L, 100439L, 3000);
		Set set1 = b.searchByHolderName("Priyal");
		Iterator<Account> it2 = set1.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next().toString());
		}
		Set set2 = b.searchByHolderName("Shreyas");
		Iterator<Account> it3 = set2.iterator();
		while (it3.hasNext()) {
			System.out.println(it3.next().toString());
		}
		LinkedList list1 = b.getALL();
		Collections.sort(list1);
		System.out.println("Sorting according to Holder name in ascending order");
		Iterator<Account> it4 = list1.iterator();
		while (it4.hasNext()) {
			System.out.println(it4.next().toString());
		}
		Collections.sort(list1, new Comparator<Account>() {
			@Override
			public int compare(Account a1, Account a2) {
				return (int) (a1.getBalance()-a2.getBalance());
			}
		});
		System.out.println("Sorting according to Balance in ascending order");
		Iterator<Account> it5 = list1.iterator();
		while (it5.hasNext()) {
			System.out.println(it5.next().toString());
		}
		
		
		b.closeAccount(100437L);
		b.closeAccount(100440L);
		System.out.println("filtering out closed accounts");
		b.people.values().stream().filter((x) -> x.getStatus() == Status.ACTIVE).forEach(System.out::println);
		System.out.println("Closed Accounts with balance greater than 5000");
		b.people.values().stream().filter((x) -> x.getStatus() == Status.CLOSED && x.getBalance() > 5000)
				.forEach(System.out::println);

	}

}
