/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.*;
import javax.sql.DataSource;

/**
 *
 * @author roman
 */
public class ConnectionManager {
    
    private static final String DATASOURCE = "jdbc/akdb";
    private static ConnectionManager connMgrInst = null;
    private DataSource ds = null;


    public static synchronized ConnectionManager getInst() {
        if (connMgrInst == null) {
            connMgrInst = new ConnectionManager();
        }
        return connMgrInst;
    }

    
    private ConnectionManager() {
        try {
            Context ctx;
            ctx = new javax.naming.InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/" + DATASOURCE);
        } catch (NamingException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConn() {
        Connection retVal = null;
        try {
            retVal = ds.getConnection();  //get a connection from the pool

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retVal;
    }
    
}
