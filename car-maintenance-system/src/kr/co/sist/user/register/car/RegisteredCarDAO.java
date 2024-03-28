package kr.co.sist.user.register.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import kr.co.sist.admin.register.car.RegisteredCarVO;
import kr.co.sist.dao.DBConnection;

public class RegisteredCarDAO {
    private static RegisteredCarDAO userRegisteredCarDAO;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;

    private RegisteredCarDAO() {}

    public static RegisteredCarDAO getInstance() {
        if (userRegisteredCarDAO == null) {
            userRegisteredCarDAO = new RegisteredCarDAO();
        }
        return userRegisteredCarDAO;
    }// getInstance



    public void insertCar(RegisteredCarVO rVO) throws SQLException {
        DBConnection dbCon = DBConnection.getInstance();

        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = dbCon.getConnection();

            String insertCar =
                    "insert into resisted_car(car_Id, caridentity_number,owner_id,  car_Model, car_year, drive_Distance) "
                            + "values(?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(insertCar);

            pstmt.setString(1, rVO.getCarId());
            pstmt.setString(2, rVO.getCarIdentityNumber());
            pstmt.setString(3, rVO.getOwnerId());
            pstmt.setString(4, rVO.getCarModel());
            pstmt.setInt(5, rVO.getCarYear());
            pstmt.setInt(6, rVO.getDriveDistance());

            pstmt.executeUpdate();
        } finally {
            dbCon.dbClose(con, pstmt, resultSet);
        } // end finally
    }// insertCar

    public boolean deleteCar(String carId) throws SQLException {
        int cnt = 0;
        DBConnection dbCon = DBConnection.getInstance();

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            String id = "car";
            String pass = "golgol";
            con = dbCon.getConnection();

            String deleteCar = "delete from resisted_car where car_id=?";
            pstmt = con.prepareStatement(deleteCar);
            pstmt.setString(1, carId);

            cnt = pstmt.executeUpdate();

            if (cnt == 1) {
                return true;
            }
            return false;
        } finally {
            dbCon.dbClose(con, pstmt, resultSet);
        }
    }// deleteCar

}
