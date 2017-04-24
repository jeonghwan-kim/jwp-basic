//package next.dao;
//
//import core.jdbc.ConnectionManager;
//import next.model.User;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//public abstract class SelectJdbcTmplate {
//    public <T> ArrayList  query(String sql) throws SQLException {
//        Connection con = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            con = ConnectionManager.getConnection();
//            pstmt = con.prepareStatement(sql);
//            setValues(pstmt);
//
//            rs = pstmt.executeQuery();
//
//            return returnValue(rs);
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (pstmt != null) {
//                pstmt.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
//    }
//
//    public abstract <T> ArrayList returnValue(ResultSet rs) throws SQLException;
//    public abstract void setValues(PreparedStatement pstmt) throws SQLException;
//}
