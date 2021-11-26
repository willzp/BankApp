package com.company;

public class Account {
    private Long balance;
    private Long accountNbr;
    private String accountType = "Debit";

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getAccountNbr() {
        return accountNbr;
    }

    public void setAccountNbr(Long accountNbr) {
        this.accountNbr = accountNbr;
    }

    public String GetAccount(){
        return "Account number: " + accountNbr +
                "\n Account type: " + accountType +
                "\n Balance: " + balance;
    }
}
