package com.solvd.connectionPool;

import java.sql.SQLException;

public class Connection {
    private int idConnection;

    public Connection(int id) {
        this.idConnection = id;
    }

    public boolean closeConnection() throws SQLException {
        return true;
    }

    public int getIdConnection() {
        return idConnection;
    }

    public void setIdConnection(int idConnection) {
        this.idConnection = idConnection;
    }
}
