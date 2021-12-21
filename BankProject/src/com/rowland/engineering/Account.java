package com.rowland.engineering;

import java.time.LocalDate;
import java.util.*;


public class Account {
    String accountName;
    private int accountBalance = 0;
    ArrayList<Integer> transactionHistory;
    ArrayList<String> accountInfo;
    private String defaultAccount = "081234";
    public String defaultPassword = "1234";


    Scanner scanner = new Scanner(System.in);
    Calendar date = new GregorianCalendar();
    LocalDate calendar = LocalDate.of(date.get(Calendar.YEAR),date.get(Calendar.MONTH) + 1,date.get(Calendar.DAY_OF_MONTH));

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
            System.out.println("Login Successful \nWelcome " + accountName);
            startBankActivities();
        } else {
            System.out.println("Invalid Account Details");
        }
    }


    public void startBankActivities() {
        System.out.println("How can we help you today?");
        System.out.println("""
                1) Make Deposit\s
                2) Make Withdrawal\s
                3) View Account Balance\s
                4) Fixed Deposit\s
                5) View Transaction History\s
                6)Exit To Main Menu""");
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
            getAccountBalance();
            performAnotherTransaction();
        } else if( customerResponse == 4) {
            fixedDeposit();
        } else if (customerResponse == 5) {
            viewTransactionHistory();
            performAnotherTransaction();
        } else if (customerResponse == 6){
            createAccount();
        } else {
            System.out.println("Invalid Option Selected");
        }
    }

    public void viewTransactionHistory() {
        System.out.println("Your account transaction history is "+ transactionHistory);
    }

    public void createAccount() {
        System.out.println("WELCOME TO ROW BANK OF AFRICA");
        System.out.println("Do you have an account with us? \n Enter 1 if yes \n Enter 2 if no");
        int response = scanner.nextInt();
        if (response == 1) {
            login();
        } else if (response == 2) {
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


    public void getAccountBalance() {
        System.out.println("Your account balance is  " + accountBalance);
        performAnotherTransaction();
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

    public void fixedDeposit() {
        System.out.println("Enter Duration Of Your Fixed Deposit And Amount To Fix " +
                "\nHow Many Months Do You Wish To Fix");
        int fixedDuration = scanner.nextInt();
        System.out.println("Enter Your Fixed Deposit Amount");
        System.out.println("""
                1) At 5% - 7% annually ($500 - $5000)\s
                2) At 8% - 12% annually ($5001 and above)
                 Enter Amount You Wish To Fix""");
        int fixedAmount = scanner.nextInt();
        if (this.accountBalance < fixedAmount) {
            System.out.println("Insufficient fund to fix");
            performAnotherTransaction();
        } else {
            if (fixedAmount >= 500 && fixedAmount <= 5000) {
                if (fixedAmount <= 1000) {
                    System.out.println("You will earn at the rate of 5% annually");
                    double profitEarned = (fixedAmount * .05);
                    double profitEarnedPlusCapital = profitEarned + fixedAmount;
                    System.out.println("Fixed Date (yy/mm/dd) :: "+ date.get(Calendar.YEAR)+ " " + (date.get(Calendar.MONTH) + 1) + " "
                            + date.get(Calendar.DAY_OF_MONTH));
                    System.out.println("Maturity Date (yy/mm/dd) :: ");
                    System.out.println(calendar.plusMonths(fixedDuration));
                    System.out.println("Your capital will earn interest of $"+profitEarned+ " and total amount payable" +
                            " after maturity is $" + profitEarnedPlusCapital);
                    this.accountBalance -= fixedAmount;
                    this.transactionHistory.add(-fixedAmount);
                    performAnotherTransaction();
                } else if (fixedAmount  <= 3000) {
                    System.out.println("You will earn at the rate of 6% annually");
                    double profitEarned = (fixedAmount * .06);
                    double profitEarnedPlusCapital = profitEarned + fixedAmount;
                    System.out.println("Fixed Date (yy/mm/dd) :: "+ date.get(Calendar.YEAR)+ " " + (date.get(Calendar.MONTH) + 1) + " "
                            + date.get(Calendar.DAY_OF_MONTH));
                    System.out.println("Maturity Date (yy/mm/dd) :: ");
                    System.out.println(calendar.plusMonths(fixedDuration));
                    System.out.println(" Your capital will earn interest of $"+profitEarned+ " and total amount payable" +
                            " after maturity is $" + profitEarnedPlusCapital);
                    this.accountBalance -= fixedAmount;
                    this.transactionHistory.add(-fixedAmount);
                    performAnotherTransaction();
                } else if (fixedAmount <= 5000) {
                    System.out.println("You will earn at the rate of 7% annually");
                    double profitEarned = (fixedAmount * .07);
                    double profitEarnedPlusCapital = profitEarned + fixedAmount;
                    System.out.println("Fixed Date (yy/mm/dd) :: "+ date.get(Calendar.YEAR)+ " " + (date.get(Calendar.MONTH) + 1) + " "
                            + date.get(Calendar.DAY_OF_MONTH));
                    System.out.println("Maturity Date (yy/mm/dd) :: " + calendar.plusMonths(fixedDuration));
                    System.out.println("Your capital will earn interest of $"+profitEarned+ " and total amount payable" +
                            " after maturity is $" + profitEarnedPlusCapital);
                    this.accountBalance -= fixedAmount;
                    this.transactionHistory.add(-fixedAmount);
                    performAnotherTransaction();
                }
            } else if (fixedAmount > 5000) {
                System.out.println("You will earn at the rate of 9% annually");
                double profitEarned = (fixedAmount * .09);
                double profitEarnedPlusCapital = profitEarned + fixedAmount;
                System.out.println("Fixed Date (yy/mm/dd) :: "+ date.get(Calendar.YEAR)+ " " + (date.get(Calendar.MONTH) + 1) + " "
                        + date.get(Calendar.DAY_OF_MONTH));
                System.out.println("Maturity Date (yy/mm/dd) :: ");
                System.out.println(calendar.plusMonths(fixedDuration));
                System.out.println(" Your capital will earn interest of $"+profitEarned+ " and total amount payable" +
                        " after maturity is $" + profitEarnedPlusCapital);
                this.accountBalance -= fixedAmount;
                this.transactionHistory.add(-fixedAmount);
                performAnotherTransaction();
            }
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
        System.out.println("Your Row Bank Account Number is " + customerAccountNumber + ".\n Please " +
                "keep it safe for log in. \n You can now deposit into your account");
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
