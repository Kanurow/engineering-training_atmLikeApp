package com.rowland.engineering;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Account rowlandAccount = new Account("Rowland");
        rowlandAccount.createAccount();
        //rowlandAccount.deposit(5000);
        //rowlandAccount.withdrawal(3000);
        //rowlandAccount.withdrawal(4000);

        System.out.println("Your account balance is "+ rowlandAccount.getAccountBalance());
        System.out.println("Your account transaction history is "+ rowlandAccount.transactionHistory);
        System.out.println("Account info == " + rowlandAccount.accountInfo);
    }
}
