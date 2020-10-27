package dao.impl;

import connection.InitConnection;
import dao.UserDao;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoIMPL  implements UserDao {

    public User findUser(String user) {
        String sql= "SELECT * FROM users AS u WHERE username = ? ";
        // mot query can co sql mau + maper+ cac tham so truyen vao query
        List<User> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            InitConnection initConnection =new InitConnection();
            connection = initConnection.getConnect();
            statement = connection.prepareStatement(sql);
            statement.setString(1,user);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                results.add(new User(resultSet));
            }
        } catch (SQLException | ClassNotFoundException e) {
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }

        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public List<User> findAll() throws SQLException {
        return null;
    }

    @Override
    public User findById(int id) throws SQLException {
        return null;
    }

    @Override
    public User insert(User user) throws SQLException {
        return null;
    }

    @Override
    public boolean update(User user) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }
}
