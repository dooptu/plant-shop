/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vui;

import basicclass.Account;
import dao.AccountDAO;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class tester {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
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
        System.out.println("Insert");
        String gmail;
        String psw;
        String name;
        String phone;
        int status;
        int role;
        
        System.out.print("Email: ");
        gmail = sc.nextLine();
        System.out.print("Password: ");
        psw = sc.nextLine();
        System.out.print("Full name: ");
        name = sc.nextLine();
        System.out.print("Phone: ");
        phone = sc.nextLine();
        System.out.print("Status: ");
        status = Integer.parseInt(sc.nextLine());
        System.out.print("Role: ");
        role = Integer.parseInt(sc.nextLine());
        
        list = AccountDAO.insertAccounts(gmail, psw, name, phone, status, role);
        try {
            for (Account account : list) {
            System.out.println(account.toString());
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("-------------------");
        System.out.println("Update status");
        int idUp;
        int statusUp;
        System.out.print("Account ID: ");
        idUp = Integer.parseInt(sc.nextLine());
        System.out.print("Status: ");
        statusUp = Integer.parseInt(sc.nextLine());
        list = AccountDAO.updateStatus(idUp, statusUp);
        try {
            for (Account account : list) {
            System.out.println(account.toString());
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
