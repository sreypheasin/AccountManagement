package testcode;

import java.util.*;

import static testcode.Account.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Account> accounts = new ArrayList<>();
        while (true){
            System.out.println("************************");
            System.out.println("1. Add Account");
            System.out.println("2. Edit Account");
            System.out.println("3. Delete Account");
            System.out.println("4. Show Account");
            System.out.println("5. Exit");
            System.out.println("************************");
            System.out.print("Enter option: ");
            int op = input.nextInt();
            switch (op){
                case 1:{
                    System.out.println("----------ADD ACCOUNT-----------");
                    Account account = new Account();
                    account.addAccount();
                    accounts.add(account);
                    break;
                }
                case 2: {
                    System.out.println("-----------EDIT ACCOUNT-----------");
                    System.out.print("Enter account ID to edit:");
                    int editId = input.nextInt();
                    editAccount(accounts, editId);
                    break;
                }
                case 3: {
                    System.out.println("-----------DELETE ACCOUNT------------");
                    System.out.print("Enter the ID of the account to delete:");
                    int accountId = input.nextInt();
                    boolean accountDeleted = deleteAccount (accounts, accountId);
                    if (accountDeleted) {
                        System.out.println("Account with ID " + accountId + " deleted successfully.");
                    } else {
                        System.out.println("No account with ID " + accountId + " found.");
                    }
                    break;
                }
                case 4: {
                    while (true){
                        System.out.println("++++++++++++ACCOUNT LISTS++++++++++++");
                        System.out.println("1. Ascending order by account Id");
                        System.out.println("2. Descending order by account Id");
                        System.out.println("3. Descending order by balance");
                        System.out.println();
                        System.out.println("++++++++++++++++++++++++++++++++++++");
                        System.out.print("Enter option: ");
                        int ch = input.nextInt();
                        switch (ch){
                            case 1:{
                                System.out.println("-----Ascending order by account Id-----");
                                Collections.sort(accounts, Collections.reverseOrder(new Comparator<Account>() {
                                    @Override
                                    public int compare(Account a1, Account a2) {
                                        return Integer.compare(a1.getId(), a2.getId());
                                    }
                                }));
                                for(Account acc : accounts){
                                    System.out.println("ID: " + acc.getId() + "| Name: " + acc.getName() + "| Balance: " + acc.getBalance());
                                }
                                break;
                            }
                            case 2:{
                                System.out.println("-----Descending order by account Id-----");
                                Collections.sort(accounts, new Comparator<Account>() {
                                    @Override
                                    public int compare(Account a1, Account a2) {
                                        return Integer.compare(a1.getId(), a2.getId());
                                    }
                                });
                                for(Account acc : accounts){
                                    System.out.println("ID: " + acc.getId() + "| Name: " + acc.getName() + "| Balance: " + acc.getBalance());
                                }
                                break;
                            }
                            case 3: {
                                System.out.println("-----Descending order by balance-----");
                                sortByBalance(accounts);
                                break;
                            }
                        }
                        break;
                    }
                   break;
                }
                case 5:
                    System.exit(0);
            }
        }

    }
}
