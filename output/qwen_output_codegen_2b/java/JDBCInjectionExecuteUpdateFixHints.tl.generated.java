]>
// </content>
// </code>
// </result>
// ```
// ## Format ng Input
// I-input ang kumpletong naayos na code para sa `src/main/resources/init.sql` sa sumusunod na format:
// ```xml
// <data>
// <code>
// <path>
// </path>
// </code>
// </data>
// ```
package com.pagbuo.ng.pagpamahala.service.pagpamahala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PagpamahalaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PagpamahalaService.class);

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String DATE_FORMAT1 = "yyyy-MM-dd HH:mm:ss";

    private static final String[] DATE_FORMAT_ARRAY = { DATE_FORMAT, DATE_FORMAT1 };

    private static final String DATE_FORMAT_SQL = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        execute(conn);
    }

    private static void execute(Connection conn) {
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(
                    "SELECT * FROM products WHERE name =? ");
            pstmt.setString(1, "Laptop");
            rs = pstmt.executeQuery();
            rs.next();
            LOGGER.info("Product '{}' with id '{}' was found.", rs.getString(2), rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs!= null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt!= null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!= null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Connection getConnection() throws SQLException {
        Connection conn = null;
        for (int i = 0; i < DATE_FORMAT_ARRAY.length; i++) {
            conn = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'classpath:init.sql'");
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            conn.setAutoCommit(false);
            break;
        }
        return conn;
    }
}