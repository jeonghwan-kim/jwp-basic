//package next.dao;
//
//import core.jdbc.ConnectionManager;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
///**
// * Created by woowahan on 2017. 4. 20..
// */
//public abstract class UpdateJdbcTemplate  {
//    public void update(String sql) throws SQLException {
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        try {
//            con = ConnectionManager.getConnection();
//            pstmt = con.prepareStatement(sql);
//            setValues(pstmt);
//
//            pstmt.executeUpdate();
//        } finally {
//            if (pstmt != null) {
//                pstmt.close();
//            }
//
//            if (con != null) {
//                con.close();
//            }
//        }
//    }
//
//    public abstract void setValues(PreparedStatement pstmt) throws SQLException;
//
//
//}
