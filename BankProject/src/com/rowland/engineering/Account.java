package com.rowland.engineering;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Account {
    public String accountName;
    public int accountBalance = 0;
    public ArrayList<Integer> transactionHistory;
    public ArrayList<String> accountInfo;
    public String defaultAccount = "81234";
    public String defaultPassword = "1234";
    
    
    Scanner scanner = new Scanner(System.in);

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactionHistory = new ArrayList<>();
        this.accountInfo = new ArrayList<>();
    }

    public void login() {
        System.out.println("Enter account number: ");
        String inputAccountNumber = scanner.next();
        System.out.println("Enter password");
        String inputPassword = scanner.next();
        if (defaultAccount.equals(inputAccountNumber) && defaultPassword.equals(inputPassword)) {
            System.out.println("Login Successful");
            startBankActivities();
        } else {
            System.out.println("Invalid Account Details");
        }
    }



    public void startBankActivities() {
        System.out.println("How can we help you today?");
        System.out.println("1) Make Deposit \n2) Make Withdrawal \n3) View Account Balance \n4) Exit To Main Menu");
        int customerResponse = scanner.nextInt();
        if (customerResponse == 1) {
            System.out.println("How much do you want to deposit?");
            int depositAmount = scanner.nextInt();
            deposit(depositAmount);
        } else if ( customerResponse == 2) {
            System.out.println("How much do you wish to withdraw?");
            int withdrawalAmount = scanner.nextInt();
            withdrawal(withdrawalAmount);
        } else if ( customerResponse == 3) {
            System.out.println("Your total money balance is ");
            getAccountBalance();
        } else if( customerResponse == 4) {
            createAccount();
        } else {
            System.out.println("Invalid Option Selected");
        }
    }

    public void createAccount() {
        System.out.println("WELCOME TO ROW BANK OF AFRICA");
        System.out.println("Do you have an account with us? \n Enter 1 if yes \n Enter 2 if no");
        int response = scanner.nextInt();
        if (response == 1) {
            // Login and perform some operations
            login();

        } else if (response == 2) {
            // register then login
            registerAccount();

        } else {
            System.out.println("Invalid Input");
        }
    }

    public void performAnotherTransaction() {
        System.out.println("Do you wish to perform another transaction? \n1) Yes \n2) No");
        int choice = scanner.nextInt();
        if (choice == 1) {
            startBankActivities();
        } else if (choice == 2) {
            createAccount();
        } else {
            System.out.println("Invalid option selected");
        }
    }


    public int getAccountBalance() {
        return accountBalance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            transactionHistory.add(amount);
            this.accountBalance += amount;
            System.out.println("You just made a deposit of " + amount + " into your account");
            performAnotherTransaction();
        } else {
            System.out.println("You cannot deposit negative amount");
        }
    }

    

    public void registerAccount() {
        System.out.println("<=========REGISTRATION=======>");
        System.out.println("First Name");
        String firstName = scanner.next();
        accountInfo.add(firstName);

        System.out.println("Last Name");
        String lastName = scanner.next();
        accountInfo.add(lastName);

        System.out.println("Phone Number");
        String phoneNumber = scanner.next();
        accountInfo.add(phoneNumber);

        System.out.println("Password");
        String firstPassword = scanner.next();
        accountInfo.add(firstPassword);

        System.out.println("Confirm Password");
        String confirmPassword = scanner.next();
        accountInfo.add(confirmPassword);
        
        if (accountInfo.get(3).equals(accountInfo.get(4)) ) {
            System.out.println("Registration Successful");
            generateAccountNumber();
            System.out.println("Your account info ==> " + accountInfo);
            defaultAccount = accountInfo.get(5);
            defaultPassword = accountInfo.get(4);
            login();
        } else {
            System.out.println("Password does not match \nRe-enter Details");
            // Delete both password and tell them to re-enter it
            accountInfo.clear();
            registerAccount();
        }

    }

    public void generateAccountNumber() {
        Random random = new Random();
        int randomAccountNumber = random.nextInt(999999999);
        String customerAccountNumber = Integer.toString(randomAccountNumber);
        accountInfo.add(customerAccountNumber);
        System.out.println("Your Row Bank Account Number is " + customerAccountNumber + ". Please " +
                "keep it safe for log in");
    }

    public void withdrawal(int amount) {
        int withdrawal = -amount;

        if (amount > this.accountBalance) {
            System.out.println("Insufficient Fund");
            return;
        }

        if (withdrawal < 0) {
            this.transactionHistory.add(withdrawal);
            this.accountBalance += withdrawal;
            System.out.println(amount + " has been withdrawn from your account");
            performAnotherTransaction();
        } else {
            System.out.println("Your can't withdraw negative amount");
        }
    }
}
