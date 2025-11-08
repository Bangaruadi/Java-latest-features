package com.modernjava.features.realExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BankTransfer {

    public static void main(String[] args) {
        AccountFactory accountFactory = BankAccount::new;
        BankAccount studentBankAccount = accountFactory.getBankAccount(1, 50000, "StudentA");
        BankAccount universityBankAccount = accountFactory.getBankAccount(2, 100000, "University");

        BiPredicate<Double, Double> p1 = (balance, amount) -> balance > amount;
        BiConsumer<String, Double> printer = (x, y) -> System.out.println(x + y);
        BiConsumer<BankAccount, BankAccount> printer2 = (student, university) ->
                System.out.println("Ending balance of student account: " + studentBankAccount.getBalance() +
                        " University account: " + universityBankAccount.getBalance());

        ExecutorService service = Executors.newFixedThreadPool(10);

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " says :: Executing Transfer");
            try {
                double amount = 1000;
                if (!p1.test(studentBankAccount.getBalance(), amount)) {
                    printer.accept(Thread.currentThread().getName() + "says :: balance insufficient, ", amount);
                    return;
                }
                while (!studentBankAccount.transfer(universityBankAccount, amount)) {
                    TimeUnit.MILLISECONDS.sleep(100);
                    continue;
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            printer.accept(Thread.currentThread().getName() + " says transfer is successful: Balance in account ",
                    universityBankAccount.getBalance());
        });

        for (int i = 0; i < 20; i++) {
            service.submit(t1);
        }
        service.shutdown();

        try {
            while (!service.awaitTermination(24L, TimeUnit.HOURS)) {
                System.out.println("Not Yet. Still waiting for termination");
            }
        } catch (InterruptedException iee) {
            iee.printStackTrace();
        }
        printer2.accept(studentBankAccount, universityBankAccount);
    }
}

interface AccountFactory{
    public abstract BankAccount getBankAccount(int id, double balance, String accountName);
}

class BankAccount{
    private int id;
    private double balance;
    private String accountName;
    final Lock lock = new ReentrantLock();
    BiFunction<Double, Double, Double> subtractFunction = (a, b) -> a-b;
    BiFunction<Double, Double, Double> addFunction = (a,b) -> a + b;

    public BankAccount (int id, double balance, String accountName){
        this.id = id;
        this.balance=balance;
        this.accountName = accountName;
    }

    public boolean withdraw (double amount) throws InterruptedException {
        if(this.lock.tryLock()){
            Thread.sleep(100);
            balance = subtractFunction.apply(balance, amount);
            this.lock.unlock();
            return true;
        }
        return false;
    }

    public boolean deposit (double amount) throws InterruptedException {
        if(this.lock.tryLock()){
            Thread.sleep(100);
            balance= addFunction.apply(balance,amount);
            this.lock.unlock();
            return true;
        }
        return false;
    }


    public boolean transfer (BankAccount to, double amount) throws InterruptedException {
        if(withdraw(amount)){
            System.out.println("Withdrawing amount: " + amount + " from: " + getAccountName());
            if(to.deposit(amount)){
                System.out.println("Depositing amount:" + amount + " to: " + to.getAccountName());
                return true;
            }else{
                System.out.println("Failed to acquire both locks: refunding " + amount + " to: " + accountName);
                while (!deposit(amount))
                    continue;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", balance=" + balance +
                ", accountName='" + accountName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
