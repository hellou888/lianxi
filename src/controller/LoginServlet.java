package controller;

import dao.UserDao;
import entity.UserInfo;
import tookit.JsonConvert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    private UserDao userDao=new UserDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("inner LoginServlet dopost");
//        String jsonStr="{"+"\"userId\":\"2\","+"\"userName\":\"小明\","+"\"age\":\"22\","+"}";
//        UserInfo userInfo= JsonConvert.JsonToObject(jsonStr,UserInfo.class);
//        UserInfo userInfo1=new UserInfo();
//        userInfo1.setUserId(1);
//        userInfo1.setUserName("小红");
//        userInfo1.setAge(22);
//        String s=JsonConvert.ObjectToJsonString(userInfo1);
//        System.out.println("s="+s);
//        System.out.println(userInfo);
//        String userName=req.getParameter("userName");
//        System.out.println("--------"+userName+"-----------");
        BufferedReader bufferedReader=req.getReader();
        String str;
        StringBuffer jsonBuffer=new StringBuffer("");
        while((str=bufferedReader.readLine())!=null){
            jsonBuffer.append(str);
        }
        String jsonStr1=jsonBuffer.toString();
        System.out.println("jsonStr="+jsonStr1);
        UserInfo userInfo2=JsonConvert.JsonToObject(jsonStr1,UserInfo.class);
        boolean flg=false;
        try {
            flg=userDao.loginCheck(userInfo2);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(flg){
            System.out.println("登陆成功");
        }else{
            System.out.println("登陆失败");
        }


    }
}
