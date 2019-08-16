package dao;

import entity.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends BaseDao{

    public  boolean loginCheck(UserInfo userInfo) throws SQLException, ClassNotFoundException {
        Connection conn=this.getConnection();
        PreparedStatement preparedStatement=conn.prepareStatement("select * from userinfo where userName=? and password=?");
        preparedStatement.setString(1,userInfo.getUserName());
        preparedStatement.setString(2,userInfo.getPassword());
        ResultSet resultSet=preparedStatement.executeQuery();
        if(resultSet.next()){
            return true;
        }
        return  false;

    }
}
