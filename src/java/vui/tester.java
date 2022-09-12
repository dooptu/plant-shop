/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vui;

import basicclass.Account;
import dao.AccountDAO;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class tester {
    public static void main(String[] args) throws Exception {
        ArrayList<Account> list = AccountDAO.getAccounts();
        try {
            for (Account account : list) {
            System.out.println(account.toString());
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("-------------------");
        ArrayList<Account> list2 = AccountDAO.getAccounts(0);
        try {
            for (Account account : list2) {
            System.out.println(account.toString());
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("-------------------");
        ArrayList<Account> list3 = AccountDAO.getAccounts("admin@gmailcom", "123456", 1);
        try {
            for (Account account : list3) {
            System.out.println(account.toString());
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }
}
