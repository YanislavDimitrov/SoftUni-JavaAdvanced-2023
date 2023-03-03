package definingclasses.BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        String input = sc.nextLine();

        while (!input.equals("End")) {
            String[] inputArgs = input.split("\\s+");
            String output = "";
            switch (inputArgs[0]) {
                case "Create":
                    BankAccount.id++;
                    accounts.add(new BankAccount());
                    output = String.format("Account ID%d created", BankAccount.id);
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(inputArgs[1]));
                    break;
                case "Deposit":
                    int accountId = Integer.parseInt(inputArgs[1]);
                    double amount = Double.parseDouble(inputArgs[2]);
                    if (accounts.size() < accountId) {
                        output = "Account does not exist";
                    } else {
                        accounts.get(accountId - 1).deposit(amount);
                        output = String.format("Deposited %.0f to ID%d", amount, accountId);
                    }
                    break;
                case "GetInterest":
                    accountId = Integer.parseInt(inputArgs[1]);
                    if (accounts.size() < accountId) {
                        System.out.println("Account does not exist");
                    } else {
                        int years = Integer.parseInt(inputArgs[2]);
                        output = String.format("%.2f", accounts.get(accountId - 1).getInterest(years));

                    }
                    break;
            }
            if(!output.isEmpty())
            {
                System.out.println(output);
            }
            input = sc.nextLine();
        }
    }
}