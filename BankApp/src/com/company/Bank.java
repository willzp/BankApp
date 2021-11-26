package com.company;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer(String name, int ssn){
        Customer customer = new Customer(name, ssn);
        customers.add(customer);
    }

    public void removeCustomer(int ssn){
        for(int i = 0; i < customers.size(); i++){
            Customer customer = customers.get(i);
            if(ssn == customer.getSsn()){
                customers.remove(i);
            }
        }
    }

    public void changeCustomerName(int ssn, String newName){
        for(int i = 0; i < customers.size(); i++){
            Customer customer = customers.get(i);
            if(ssn == customer.getSsn()){
                customer.setName(newName);
            }
        }
    }
    public String GetCustomer(int ssn){
          for(int i = 0; i < customers.size(); i++){
              Customer customer = customers.get(i);
              if(ssn == customer.getSsn()){
                  return customer.getCustomer();
              }
          }
         return "Customer not found";
    }

    public String GetCustomers(){
        String allCustomersInfo = "";
        for(int i = 0; i < customers.size(); i++){
            Customer customer = customers.get(i);
            String customerInfo = "\n Kundens namn: " + customer.getName() + "Kundens personnummer" + customer.getSsn();
            allCustomersInfo += customerInfo;
        }
        return allCustomersInfo;
    }

    public Account GetAccount(int ssn, long accountNbr){
        for(int i = 0; i < customers.size(); i++){
            Customer customer = customers.get(i);
            if(ssn == customer.getSsn()){
                ArrayList<Account> accounts = customer.getAccounts();
                for(int j = 0; 1 < accounts.size(); j++){
                    Account account = accounts.get(j);
                    if(accountNbr == account.getAccountNbr()){
                        return account;
                    }
                }
            }
        }
        return null;
    }

    public String GetAccountInfo(int ssn, long accountNbr){
        Account account = GetAccount(ssn, accountNbr);
        if(account ==  null){
            return "Account not found";
        }
        return account.GetAccount();
    }

    public boolean Deposit(int ssn, long accountNbr, int amount){
        Account account = GetAccount(ssn, accountNbr);
        if(account == null){
            return false;
        }
        Long balance = account.getBalance();
        account.setBalance(balance + amount);
        return true;
    }

    public boolean Withdraw(int ssn, long accountNbr, int amount){
        Account account = GetAccount(ssn, accountNbr);
        if(account == null){
            return false;
        }
        Long balance = account.getBalance();
        account.setBalance(balance - amount);
        return true;
    }

    public boolean CloseAccount(int ssn, long accountNbr){
        for(int i = 0; i < customers.size(); i++){
            Customer customer = customers.get(i);
            if(ssn == customer.getSsn()){
                ArrayList<Account> accounts = customer.getAccounts();
                for(int j = 0; 1 < accounts.size(); j++){
                    Account account = accounts.get(j);
                    if(accountNbr == account.getAccountNbr()){
                        customer.removeAccount(account);
                        return true;
                    }
                }
            }
        }
        return false;
    }

}


