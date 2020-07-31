/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author PHONG VU
 */
public class Store implements Serializable {

    private static final long serialversionUID = 1L;
    private String Store_ID;
    private String Store_Name;
    private String Address;
    private String Phone;

    public Store() {
    }

    public Store(String Store_ID, String Store_Name, String Address, String Phone) {
        this.Store_ID = Store_ID;
        this.Store_Name = Store_Name;
        this.Address = Address;
        this.Phone = Phone;
    }

    public String getStore_ID() {
        return Store_ID;
    }

    public void setStore_ID(String Store_ID) {
        this.Store_ID = Store_ID;
    }

    public String getStore_Name() {
        return Store_Name;
    }

    public void setStore_Name(String Store_Name) {
        this.Store_Name = Store_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "Store{" + "Store_ID=" + Store_ID + ", Store_Name=" + Store_Name + ", Address=" + Address + ", Phone=" + Phone + '}';
    }
    
}
