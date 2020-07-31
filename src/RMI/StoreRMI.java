
package RMI;

import Model.Store;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PHONG VU
 */
public class StoreRMI extends UnicastRemoteObject implements StoreService {

    public StoreRMI() throws RemoteException {

    }

    @Override
    public ArrayList<Store> searchByPhone(String phone) throws RemoteException {
        ArrayList<Store> list = new ArrayList<>();
        try {
            Connection conn;
            conn = Model.ConnectDB.getConnection();
            String sql = "Select * from Store_DE140042 Where Phone= N'" + phone + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String ID = rs.getString(1);
                String name = rs.getString(2);
                String add = rs.getString(3);
                String phoneNumber = rs.getString(4);
                list.add(new Store(ID, name, add, phoneNumber));
            }
            conn.close();
            return list;
        } catch (SQLException e) {
            System.out.println("Add failed");

        }
        return null;

    }
}
