/**
 *   @author Kaz Cogswell
 *   @version 0.0.1
 *   @summary Project 7
 *   @todo Nothing
 */

import java.util.Scanner;

public class ATM{

    public int balance, sBalance, cBalance, menuResponse, account;
    public int withdrawal, deposit, transferNum, transfer;
    public int cardNum, pin, pinCount;
    Scanner scanner =  new Scanner(System.in);

    public void setCardName() {
        System.out.println("What is the cardholder's name?");
        String setCardName = scanner.nextLine();
        System.out.println("Welcome " +setCardName+ ".");
        setCardNum();
    }
    public void setCardNum() {
        System.out.println("What is the card number?");
        int setCardNum = scanner.nextInt();
        System.out.println("Thank you.");
        pinCount = 0;
        setPin();
    }

    public void setPin() {
        pin = 1111;
        if(pinCount == 3) {
            System.out.println("You have entered the incorrect pin number several times. Goodbye.");
            setCardName();
        } else {
            System.out.println("What is the pin number?");
            int pinNum = scanner.nextInt();
            if(pin == pinNum){
                System.out.println("Thank you.");
                setAccount();
            } else {
                pinCount++;
                System.out.println("That was the incorrect number. Please try again.");
                setPin();
            }
        }
    }

    public void setIntBalance() {
        sBalance = 1000;
        cBalance = 1000;
    }

    public void setAccount() {
        if (account == 1) {
            cBalance = balance;
        } else if (account == 2) {
            sBalance = balance;
        } else {
        }
        System.out.println("Which account would you like to access?: 1) Checking 2)Savings 3) Exit");
        int account = scanner.nextInt();
        if (account == 1) {
            balance = cBalance;
            menu();
        } else if (account == 2) {
            balance = sBalance;
            menu();
        } else if (account == 3) {
            System.out.println("Have a good day.");
        } else {
            System.out.println("Please enter an acceptable number.");
            setAccount();
        }
    }

    public void menu() {
        menuResponse = 0;
        System.out.println("What would you like to do today?: 1)Show balance 2)Deposit 3)Withdrawal 4)Transfer Funds 5)Set Account 6)Exit");
        int menuResponse = scanner.nextInt();
        if (menuResponse == 1) {
            showBalance();
        } else if (menuResponse == 2) {
            makeDeposit();
        } else if (menuResponse == 3) {
            makeWithdrawal();
        } else if (menuResponse == 4) {
            transferFunds();
        } else if (menuResponse == 5) {
            setAccount();
        } else if (menuResponse == 6) {
            exit();
        } else {
            System.out.println("Invalid value. Try again.");
            menu();
        }
    }

    public void showBalance() {
        System.out.println("Your balance is " + balance +".");
        menu();
    }

    public void makeDeposit() {
        System.out.println("How much would you like to deposit?");
        int amount = scanner.nextInt();
        balance += amount;
        System.out.println("Your balance is, " +balance+".");
        menu();
    }

    public void makeWithdrawal() {
        System.out.println("How much would you like to withdrawal?(Withdrawal are only allowed in $20) Enter 0 to cancel.");
        int requestedAmount = scanner.nextInt();
        if(requestedAmount == 0){
            menu();
        }
        int offeredAmount = requestedAmount / 20;
        offeredAmount = offeredAmount * 20;
        System.out.println("$" +offeredAmount+ "? 1)Yes 2)No");
        int confirmation = scanner.nextInt();
        if(confirmation == 1){
            if(offeredAmount <= balance){
                balance -= offeredAmount;
            } else {
                System.out.println("You cannot remove that much because you lack sufficient funds.");
                makeWithdrawal();
            }
        }
        else{
            makeWithdrawal();
        }
        menu();
    }

    public void transferFunds() {

        System.out.println("Which account would you like to transfer money from? 1)Savings 2)Checking");
        int transferNum = scanner.nextInt();
        System.out.println("How much would you like to transfer?");
        int amount = scanner.nextInt();
        if(transferNum == 1 && amount <= sBalance) {
            //To checking from savings
            cBalance =+ amount;
            sBalance =- amount;
        } else if(transferNum == 2 && amount <= cBalance) {
            //To savings from checking
            sBalance =+ amount;
            cBalance =- amount;
        } else {
            System.out.println("Error. That account does not exist or there is not enough money in the transfering account.");
        }
        menu();
    }

    public void exit() {
        System.out.println("Thank you, have a good day.");
    }
}
