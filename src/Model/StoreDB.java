/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PHONG VU
 */
public class StoreDB {

    public static Store getStore(String id) {
        Store store = null;
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Select * from Store_DE140042 Where Store_ID ='" + id + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String ID = rs.getString(1);
                String name = rs.getString(2);
                String add = rs.getString(3);
                String phone = rs.getString(4);
                store = new Store(ID, name, add, phone);

            }
            conn.close();
            return store;
        } catch (SQLException e) {
            System.out.println("Add failed!");
        }
        return null;
    }

    public static void addNewStore(Store store) {
        Connection conn;
        conn = ConnectDB.getConnection();
        String sql = "Insert into Store_DE140042 values (?, ?, ?, ?)";
        try {
            PreparedStatement prs = conn.prepareStatement(sql);
            prs.setString(1, store.getStore_ID());
            prs.setString(2, store.getStore_Name());
            prs.setString(3, store.getAddress());
            prs.setString(4, store.getPhone());
            prs.execute();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Add failed!");
            e.printStackTrace();
        }
    }

    public static ArrayList<Store> getAll() {
        ArrayList<Store> list = new ArrayList();
        try {
            String sql = "Select * from Store_DE140042";
            Connection conn = ConnectDB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String ID = rs.getString(1);
                String name = rs.getString(2);
                String add = rs.getString(3);
                String phone = rs.getString(4);
                list.add(new Store(ID, name, add, phone));
            }
            conn.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
