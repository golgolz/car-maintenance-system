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
    }// getInstance

    public List<RegisteredCarVO> selectAllCar() throws SQLException {
        List<RegisteredCarVO> car = new ArrayList<RegisteredCarVO>();

        DBConnection dbConn = DBConnection.getInstance();

        try {
            conn = dbConn.getLocalhostConnection("scott", "tiger");
            StringBuilder selectCarQuery = new StringBuilder(
                    "select carId, carYear, carModel, driveDistance, registration_Date, ownerId   from    registeredCar ");

            pstmt = conn.prepareStatement(selectCarQuery.toString());
            resultSet = pstmt.executeQuery();


            RegisteredCarVO rVO = null;
            while (resultSet.next()) {

                rVO = new RegisteredCarVO(resultSet.getString("carId"), "", resultSet.getString("ownerId"),
                        resultSet.getString("carModel"), null, resultSet.getDate("registrationDate"),
                        resultSet.getInt("carYear"), resultSet.getInt("driveDistance"),
                        resultSet.getString("recallFlag"), resultSet.getString("deleteFlag"));

                car.add(rVO);

            }
        } finally {
            dbConn.dbClose(conn, pstmt, resultSet);
        } // end finally
        return car;
    }// selectAllCar

    public void insertCar(RegisteredCarVO rVO) throws SQLException {
        DBConnection dbCon = DBConnection.getInstance();
        // 1.드라이버 로딩
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            String id = "car";
            String pass = "golgol";
            con = dbCon.getConnection(id, pass);
            // 인서트하려면 차량번호, 모델f, 주행거리, 제조일자가 필요, 누구의 차인가 ownerid(F), 쿼리문이랑 똑같이 쓰기!!
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
            con = dbCon.getConnection(id, pass);

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

}// class
