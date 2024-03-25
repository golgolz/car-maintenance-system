package kr.co.sist.admin.register.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kr.co.sist.dao.DBConnection;

public class RegisteredCarDAO {
    private static RegisteredCarDAO registeredCarDAO;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;

    private RegisteredCarDAO() {}

    public static RegisteredCarDAO getInstance() {
        if (registeredCarDAO == null) {
            registeredCarDAO = new RegisteredCarDAO();
        }
        return registeredCarDAO;
    }

    public List<RegisteredCarVO> selectAllCar() throws SQLException {
        List<RegisteredCarVO> car = new ArrayList<RegisteredCarVO>();

        DBConnection dbConn = DBConnection.getInstance();

        try {
            conn = dbConn.getConnection();
            StringBuilder selectCarQuery = new StringBuilder(
                    "select car_id, car_year, car_model, drive_distance, registration_day, owner_id   from    registeredCar ");

            pstmt = conn.prepareStatement(selectCarQuery.toString());
            resultSet = pstmt.executeQuery();


            RegisteredCarVO rVO = null;
            while (resultSet.next()) {

                rVO = new RegisteredCarVO(resultSet.getString("car_id"), "", resultSet.getString("owner_id"),
                        resultSet.getString("car_model"), null, resultSet.getDate("registration_day"),
                        resultSet.getInt("car_year"), resultSet.getInt("drive_distance"), false);

                car.add(rVO);


            }
        } finally {
            dbConn.dbClose(conn, pstmt, resultSet);
        }
        return car;
    }
}
