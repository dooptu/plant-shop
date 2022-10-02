/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DBUtils.MyLib;
import basicclass.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
//lop nay de chua cac function thuc hien cac cau query lay data trong DB
public class AccountDAO {

    //ham nay de lay tat ca cac account
    public static ArrayList<Account> getAccounts() throws Exception {
        ArrayList<Account> result = new ArrayList<>();
        //make connection
        try {
            Connection cn = MyLib.makeConnection();

            //viet cac query and exec
            if (cn != null) {
                String sql = "SELECT accID,email,password,fullname,phone,status,role\n"
                        + "FROM dbo.Accounts";
                Statement st = cn.createStatement();
                ResultSet table1 = st.executeQuery(sql);
                //xu ly dap an

                if (table1 != null) {
                    while (table1.next()) {
                        int accid = table1.getInt("accID");
                        String email = table1.getString("email");
                        String password = table1.getString("password");
                        String fullname = table1.getString("fullname");
                        String phone = table1.getString("phone");
                        int status = table1.getInt("status");
                        int role = table1.getInt("role");
                        Account acc = new Account(accid, email, password, fullname, phone, status, role);
                        result.add(acc);
                    }
                }
                //dong connecton
                cn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static Account getAccounts(String email, String password) throws Exception {
        Connection cn = null;
        Account acc = null;
        //make connection
        try {
             cn = MyLib.makeConnection();

            //viet cac query and exec
            if (cn != null) {
                String sql = "SELECT accID,email,password,fullname,phone,status,role\n"
                        + "FROM dbo.Accounts WHERE email = ? AND password = ? COLLATE Latin1_General_CS_AS;";
                PreparedStatement pstm = cn.prepareStatement(sql);
                pstm.setString(1, email);
                pstm.setString(2, password);
                ResultSet table = pstm.executeQuery();
                //xu ly dap an

                if (table != null && table.next()) {
//                    while (table.next()) {
                        int accid = table.getInt("accID");
                        email = table.getString("email");
                        password = table.getString("password");
                        String fullname = table.getString("fullname");
                        String phone = table.getString("phone");
                        int status = table.getInt("status");
                        int role = table.getInt("role");
                        acc = new Account(accid, email, password, fullname, phone, status, role);
                        
//                    }
                }
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null){
                try {
                    //dong connection
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return acc;
    }
    //ham nay de lay tat ca cac account voi role = 0/1

    public static ArrayList<Account> getAccounts(int role) throws Exception {
        ArrayList<Account> list = new ArrayList<>();
        try {
            Connection cn = MyLib.makeConnection();

            //viet cac query and exec
            if (cn != null) {
                String sql = "SELECT accID, email, password, fullname, phone, status, role\n"
                        + "FROM dbo.Accounts\n"
                        + "WHERE role =?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, role);
                ResultSet table = pst.executeQuery();
                //xu ly dap an

                if (table != null) {
                    while (table.next()) {
                        int accid = table.getInt("accID");
                        String email = table.getString("email");
                        String password = table.getString("password");
                        String fullname = table.getString("fullname");
                        String phone = table.getString("phone");
                        int status = table.getInt("status");
                        role = table.getInt("role");
                        Account acc = new Account(accid, email, password, fullname, phone, status, role);
                        list.add(acc);
                    }
                }
                //dong connecton
                cn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //ham nay de lay 1 account dua vao email, password va status=1(active)
    public static ArrayList<Account> getAccounts(String email, String password, int status) throws Exception {
        ArrayList<Account> list = new ArrayList<>();
        try {
            Connection cn = MyLib.makeConnection();

            //viet cac query and exec
            if (cn != null) {
                String sql = "SELECT accID, email, password, fullname, phone, status, role\n"
                        + "FROM dbo.Accounts\n"
                        + "WHERE email =  '" + email + "' AND password = '" + password + "' AND status = " + status;
                Statement st = cn.createStatement();
                ResultSet table = st.executeQuery(sql);
                //xu ly dap an

                if (table != null) {
                    while (table.next()) {
                        int accid = table.getInt("accID");
                        email = table.getString("email");
                        password = table.getString("password");
                        String fullname = table.getString("fullname");
                        String phone = table.getString("phone");
                        status = table.getInt("status");
                        int role = table.getInt("role");
                        Account acc = new Account(accid, email, password, fullname, phone, status, role);
                        list.add(acc);
                    }
                }
                //dong connecton
                cn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //ham nay de chen 1 account vao bang account
    public static ArrayList<Account> insertAccounts(String email, String password, String fullname, String phone, int status, int role) throws Exception {
        ArrayList<Account> list = new ArrayList<>();
        try {
            Connection cn = MyLib.makeConnection();

            //viet cac query and exec
            if (cn != null) {
                String sql = "INSERT INTO dbo.Accounts VALUES  (?,?,?,?,?,?) ";
                
                //xu ly dap an
                
                PreparedStatement pstm = cn.prepareStatement(sql);
                pstm.setString(1, email);
                pstm.setString(2, password);
                pstm.setString(3, fullname);
                pstm.setString(4, phone);
                pstm.setInt(5, status);
                pstm.setInt(6, role);
                int row = pstm.executeUpdate();
                System.out.println("Row inserted!");

                //dong connecton
                cn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //ham nay de sua status cua mot account khi biet accID
    public static ArrayList<Account> updateStatus(int accId, int status) throws Exception {
        ArrayList<Account> list = new ArrayList<>();
        try {
            Connection cn = MyLib.makeConnection();

            //viet cac query and exec
            if (cn != null) {
                String sql = "UPDATE dbo.Accounts \n"
                        + "SET status = '"+ status +"' \n"
                        + "WHERE accID = "+ accId +"; ";
                Statement st = cn.createStatement();
                int row = st.executeUpdate(sql);
                //xu ly dap an
                System.out.println("Row inserted!");

                //dong connecton
                cn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //ham nay de sua profile (sua cac cot ngoai tru accID)
    
    public static ArrayList<Account> updateAccount(int accId, String email, String password, String fullname, String phone, int status, int role) throws Exception {
        ArrayList<Account> list = new ArrayList<>();
        try {
            Connection cn = MyLib.makeConnection();

            //viet cac query and exec
            if (cn != null) {
                String sql = "UPDATE dbo.Accounts \n"
                        + "SET email = '"+ email +"' \n"
                        + "   ,password = '"+ password +"' \n"
                        + "   ,fullname = '"+ fullname +"' \n"
                        + "   ,phone = '"+ phone +"' \n"
                        + "   ,status = '"+ status +"' \n"
                        + "   ,role = '"+ role +"' \n"
                        + "WHERE accID = "+ accId +"; ";
                Statement st = cn.createStatement();
                int row = st.executeUpdate(sql);
                //xu ly dap an
                System.out.println("Row inserted!");

                //dong connecton
                cn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
