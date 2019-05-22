package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DBCPTest {

    public static List<String> query(List<String> list) throws Exception {

        //获取连接
        Connection conn = JDBC_Util.getConn();

        String sql = "select * from Score_name ORDER BY score DESC ";

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            int score = rs.getInt("score");
            if (name == null || name.length() == 0) {
                name = "一位不愿意透露姓名的玩家";
            }
            list.add(name + " " + String.valueOf(score));
        }
        JDBC_Util.close(conn, ps, rs);
        return list;
    }
    public static void update(String newName, int newScore) throws Exception {

        //获取连接
        Connection conn = JDBC_Util.getConn();

        String sql = "INSERT  INTO Score_name(name,score) VALUES (?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, newName);
        ps.setInt(2, newScore);
        ps.executeUpdate();
        JDBC_Util.close(conn, ps, null);
    }
}
