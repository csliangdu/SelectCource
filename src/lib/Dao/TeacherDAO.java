package lib.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ttop5 on 15-9-21.
 */
public class TeacherDAO {
    public String getCource() throws SQLException{
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>课程号</th><th>课程名称</th><th>授课教师</th><th>教室</th><th>上课时间</th></tr>";
        try{
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select cource_id, cource_name, name, location, schooltime from cource, user, classroom where teacher=user_id and classroom=classroom_id" + ";";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getInt("cource_id") + "</td>" + "<td>" + rs.getString("cource_name") + "</td>" + "<td>" + rs.getString("name") + "</td>" + "<td>" + rs.getString("location") + "</td>" + "<td>" + rs.getString("schooltime") + "</td>" + "</tr>";
            }
            return str + "</table>";
        }catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getScore() throws SQLException{
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>课程号</th><th>课程名</th><th>学分</th><th>学号</th><th>姓名</th><th>平时成绩</th><th>期末成绩</th><th>最终成绩</th></tr>";
        try{
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select cource_id, cource_name, credit, school_num, name, pingshi_score, qimo_score, final_score from score, user, cource where student=user_id and cource=cource_id" + ";";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getInt("cource_id") + "</td>" + "<td>" + rs.getString("cource_name") + "</td>" + "<td>" + rs.getString("credit") + "</td>" + "<td>" + rs.getString("school_num") + "</td>" + "<td>" + rs.getString("name") + "</td>" + "<td>" + rs.getString("pingshi_score") + "</td>" + "<td>" + rs.getString("qimo_score") + "</td>" + "<td>" + rs.getString("final_score") + "</td>" + "</tr>";
            }
            return str + "</table>";
        }catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getScource() throws SQLException{
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>课程号</th><th>课程名称</th><th>学分</th><th>学号</th><th>学生姓名</th><th>上课时间</th><th>上课地点</th></tr>";
        try{
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select cource_id, cource_name, credit, school_num, name, schooltime, location from score, user, cource, classroom where student=user_id and cource=cource_id and classroom=classroom_id" + ";";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getInt("cource_id") + "</td>" + "<td>" + rs.getString("cource_name") + "</td>" + "<td>" + rs.getString("credit") + "</td>" + "<td>" + rs.getString("school_num") + "</td>" + "<td>" + rs.getString("name") + "</td>" + "<td>" + rs.getString("schooltime") + "</td>" + "<td>" + rs.getString("location") + "</td>" + "</tr>";
            }
            return str + "</table>";
        }catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getUser() throws SQLException {
        Statement stmt = null;
        Dbutil dbutil = new Dbutil();
        Connection con = null;
        ResultSet rs = null;
        String str = "<table class=\"table table-bordered\" id=\"outside\">" +
                "<tr><th>工号</th><th>姓名</th><th>性别</th><th>学院</th><th>QQ</th><th>电话</th><th>邮箱</th><th>地址</th><th>角色</th></tr>";
        try{
            con = dbutil.getCon();
            stmt = con.createStatement();
            String sql = "select * from user" + ";";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                str = str + "<tr>" + "<td>" + rs.getString("school_num") + "</td>" + "<td>" + rs.getString("name") + "</td>" + "<td>" + rs.getString("sex") + "</td>" + "<td>" + rs.getString("school") + "</td>" + "<td>" + rs.getString("qq") + "</td>" + "<td>" + rs.getString("phone") + "</td>" + "<td>" + rs.getString("email") + "</td>" + "<td>" + rs.getString("adress") + "</td>" + "<td>" + rs.getString("role") + "</td>" + "</tr>";
            }
            return str + "</table>";
        }catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
