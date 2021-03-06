package dao;

import domain.model.DutyStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DutyStatusDatabaseDAO implements DutyStatusDao{

    @Override
    public void add(DutyStatus status) {
        try {
            Connection connection = SQLiteDatabase.getConnection();
            PreparedStatement addStatement = connection.prepareStatement(
                    "INSERT INTO duty_status " +
                            "(duty_status_id, duty_status_value) " +
                            "VALUES (?, ?);"
            );
            addStatement.setInt( 1, status.getID() );
            addStatement.setString( 2, status.toString() );
            addStatement.executeUpdate();
            addStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(DutyStatus status) {
        try {
            Connection connection = SQLiteDatabase.getConnection();
            PreparedStatement removeStatement = connection.prepareStatement(
                    "DELETE FROM duty_status " +
                            "WHERE duty_status_id = ?;"
            );
            removeStatement.setInt( 1, status.getID() );
            removeStatement.executeUpdate();
            removeStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeAll() {
        try {
            Connection connection = SQLiteDatabase.getConnection();
            PreparedStatement removeAllStatement = connection.prepareStatement(
                    "DELETE FROM duty_status;"
            );
            removeAllStatement.executeUpdate();
            removeAllStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
