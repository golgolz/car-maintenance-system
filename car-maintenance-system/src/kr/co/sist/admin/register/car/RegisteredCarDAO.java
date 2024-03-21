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
            conn = dbConn.getLocalhostConnection("scott", "tiger");
            StringBuilder selectCarQuery = new StringBuilder(
                    "select carId, carYear, carModel, driveDistance, registrationDay, ownerId   from    registeredCar ");

            pstmt = conn.prepareStatement(selectCarQuery.toString());
            resultSet = pstmt.executeQuery();


            RegisteredCarVO rVO = null;
            while (resultSet.next()) {

                rVO = new RegisteredCarVO(resultSet.getString("carId"), "", resultSet.getString("ownerId"),
                        resultSet.getString("carModel"), null, resultSet.getDate("registrationDay"),
                        resultSet.getInt("carYear"), resultSet.getInt("driveDistance"), false);

                car.add(rVO);


            }
        } finally {
            dbConn.dbClose(conn, pstmt, resultSet);
        }
        return car;
    }
}
