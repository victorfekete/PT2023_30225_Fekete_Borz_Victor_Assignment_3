package Operations;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import Connection.ConnectionFactory;

public class Comenzi {

    public void addNewClient(String clientID, String clientName, String clientAddress) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            String query = "INSERT INTO clients (clientID, clientName, clientAddress) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, clientID);
            statement.setString(2, clientName);
            statement.setString(3, clientAddress);
            statement.executeUpdate();
        } finally {
            closeResources(connection, statement, null);
        }
    }

    public void deleteClient(String clientID) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            String query = "DELETE FROM clients WHERE clientID = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, clientID);
            statement.executeUpdate();
        } finally {
            closeResources(connection, statement, null);
        }
    }

    public void editClient(String clientID, String clientName, String clientAddress) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            String query = "UPDATE clients SET clientName = ?, clientAddress = ? WHERE clientID = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, clientName);
            statement.setString(2, clientAddress);
            statement.setString(3, clientID);
            statement.executeUpdate();
        } finally {
            closeResources(connection, statement, null);
        }
    }

    public ResultSet findAll() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            String query = "SELECT * FROM clients";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            throw e;
        }
    }

    public DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
        // Column names
        int columnCount = metaData.getColumnCount();
        Vector<String> columnNames = new Vector<>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            columnNames.add(metaData.getColumnLabel(columnIndex));
        }
        // Data
        Vector<Vector<Object>> data = new Vector<>();
        while (resultSet.next()) {
            Vector<Object> rowData = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                rowData.add(resultSet.getObject(columnIndex));
            }
            data.add(rowData);
        }
        return new DefaultTableModel(data, columnNames);
    }

    private void closeResources(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        ConnectionFactory.close(resultSet);
        ConnectionFactory.close(statement);
        ConnectionFactory.close(connection);
    }
}
