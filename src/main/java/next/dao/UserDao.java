package next.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import next.model.User;

public class UserDao {
    public void insert(User user) throws SQLException {
        JdbcTemplate tpl = new JdbcTemplate() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, user.getUserId());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getName());
                pstmt.setString(4, user.getEmail());
            }

            @Override
            public <T> ArrayList<User> run(PreparedStatement pstmt) throws SQLException {
                pstmt.executeUpdate();
                return null;
            }
        };
        tpl.query("INSERT INTO USERS VALUES (?, ?, ?, ?)");
    }

    public void update(User user) throws SQLException {
        JdbcTemplate tpl = new JdbcTemplate() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, user.getPassword());
                pstmt.setString(2, user.getName());
                pstmt.setString(3, user.getEmail());
                pstmt.setString(4, user.getUserId());
            }

            @Override
            public <T> ArrayList<User> run(PreparedStatement pstmt) throws SQLException {
                pstmt.executeUpdate();
                return null;
            }
        };
        tpl.query("UPDATE USERS SET PASSWORD=?, NAME=?, EMAIL=? WHERE USERID = ?");
    }

    public List<User> findAll() throws SQLException {
        JdbcTemplate tpl = new JdbcTemplate() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
            }

            @Override
            public ArrayList<User> run(PreparedStatement pstmt) throws SQLException {
                ResultSet rs = pstmt.executeQuery();
                ArrayList<User> users = new ArrayList<>();
                while(rs.next()) {
                    User user = new User(rs.getString("userId"), rs.getString("password"),
                            rs.getString("name"), rs.getString("email"));
                    users.add(user);
                }

                return users;
            }
        } ;

        return tpl.queryAndData("SELECT * FROM USERS");
    }

    public User findByUserId(String userId) throws SQLException {
        JdbcTemplate tpl = new JdbcTemplate() {
            @Override
            public void setValues(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, userId);
            }

            @Override
            public ArrayList<User> run(PreparedStatement pstmt) throws SQLException {
                ResultSet rs = pstmt.executeQuery();
                ArrayList<User> users = new ArrayList<>();
                while(rs.next()) {
                    User user = new User(rs.getString("userId"), rs.getString("password"),
                            rs.getString("name"), rs.getString("email"));
                    users.add(user);
                }

                return users;
            }
        } ;

        return (User) tpl.queryAndData("SELECT userId, password, name, email FROM USERS WHERE userid=?").get(0);
    }
}
