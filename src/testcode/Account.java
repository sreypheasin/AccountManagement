package testcode;

import java.util.*;

public class Account {
    private int id;
    private String name;
    private double balance;

    public Account(){}
    // todo add account
    public void addAccount(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter id: ");
        id = Integer.parseInt(input.nextLine());
        System.out.print("Enter name: ");
        name = input.nextLine();
        System.out.print("Enter balance: ");
        balance = input.nextDouble();
    }
    //todo Edit account
    public static void editAccount(List<Account> accounts, int accountId) {
        for (Account account : accounts) {
            if (account.getId() == accountId) {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter new name: ");
                String newName = input.nextLine();
                System.out.print("Enter new balance: ");
                double newBalance = input.nextDouble();
                account.setName(newName);
                account.setBalance(newBalance);
                System.out.println("Account updated successfully.");
                return;
            }
        }
        System.out.println("Account not found.");
    }

    // todo delete account
    public static boolean deleteAccount(List<Account> accounts, int accountId) {
        for (Account acc : accounts) {
            if (acc.getId() == accountId) {
                accounts.remove(acc);
                return true;
            }
        }
        return false;
    }
    // todo output
    public static void sortByBalance(List<Account> accounts) {
        // Sort the accounts by balance in descending order
        Collections.sort(accounts, new Comparator<Account>() {
            @Override
            public int compare(Account acc1, Account acc2) {
                if (acc1.getBalance() < acc2.getBalance()) {
                    return 1;
                } else if (acc1.getBalance() > acc2.getBalance()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for(Account acc : accounts){
            System.out.println("ID: " + acc.getId() + "| Name: " + acc.getName() + "| Balance: " + acc.getBalance());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
