package org.example.locks;

public class BankAccount {
    public int balance=100;

    public void withDraw(int amount) {
        System.out.println (Thread.currentThread ().getName ()+"  attempting to withdraw amount ="+ amount );
        if(balance>amount){
        System.out.println (Thread.currentThread ().getName ()+"  proceeding with withdrawals" );
            try {
                Thread.sleep ( 3000 );
            }
            catch ( InterruptedException e ) {

            }
            balance-=amount;

        System.out.println (Thread.currentThread ().getName ()+"  completing withdrawals remaining balance "+ balance );
        }
        else {
        System.out.println (Thread.currentThread ().getName ()+"  insufficient balance" );

        }
    }
}
