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
        list = AccountDAO.getAccounts(0);
        try {
            for (Account account : list) {
            System.out.println(account.toString());
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("-------------------");
        list = AccountDAO.getAccounts("admin@gmailcom", "123456", 1);
        try {
            for (Account account : list) {
            System.out.println(account.toString());
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("-------------------");
        list = AccountDAO.insertAccounts( "ha@gmail.com", "123", "hanguyen", "456", 0, 1);
        try {
            for (Account account : list) {
            System.out.println(account.toString());
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
