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

    public List<RegisteredCarVO> selectAllCar(String carId, String ownerId) throws SQLException {
        List<RegisteredCarVO> car = new ArrayList<RegisteredCarVO>();

        DBConnection dbConn = DBConnection.getInstance();

        try {
            conn = dbConn.getConnection();
            StringBuilder selectCarQuery =
                    new StringBuilder("select * from resisted_car where car_id=? and owner_id=? ");

            pstmt = conn.prepareStatement(selectCarQuery.toString());

            pstmt.setString(1, carId);
            pstmt.setString(2, ownerId);

            resultSet = pstmt.executeQuery();


            RegisteredCarVO rVO = null;
            while (resultSet.next()) {

                rVO = new RegisteredCarVO(resultSet.getString("car_id"), "", resultSet.getString("owner_id"),
                        resultSet.getString("car_model"), null, resultSet.getDate("registration_date"),
                        resultSet.getInt("car_year"), resultSet.getInt("drive_distance"), "", "");

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
        ResultSet resultSet = null;
        try {
            con = dbCon.getConnection();
            // 인서트하려면 차량번호, 모델f, 주행거리, 제조일자가 필요, 누구의 차인가 ownerid(F), 쿼리문이랑 똑같이 쓰기!!
            String insertCar =
                    "insert into resisted_car (CAR_ID, OWNER_ID, CAR_MODEL, PRODUCTION_DATE, DRIVE_DISTANCE) "
                            + "values(?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(insertCar);

            pstmt.setString(1, rVO.getCarId());
            pstmt.setString(2, rVO.getOwnerId());
            pstmt.setString(3, rVO.getCarModel());
            pstmt.setDate(4, rVO.getProductionDate());
            pstmt.setInt(5, rVO.getDriveDistance());


            pstmt.executeUpdate();

        } finally {
            dbCon.dbClose(con, pstmt, resultSet);
        } // end finally
    }// insertCar

    public void updateCar(RegisteredCarVO rVO) throws SQLException {
        DBConnection dbCon = DBConnection.getInstance();

        Connection con = null;
        PreparedStatement pstmt = null;
        try {

            con = dbCon.getConnection();

            StringBuilder updateCar = new StringBuilder();
            updateCar.append("update    resisted_car").append("   set drive_distance=?  ").append("   where car_id=? ");

            pstmt = con.prepareStatement(updateCar.toString());

            pstmt.setString(1, rVO.getCarId());
            pstmt.setString(2, rVO.getOwnerId());
            pstmt.setString(3, rVO.getCarModel());
            pstmt.setDate(4, rVO.getProductionDate());
            pstmt.setInt(5, rVO.getDriveDistance());

            pstmt.executeUpdate();
        } finally {
            dbCon.dbClose(con, pstmt, resultSet);
        } // end finally
    }// updateCar

    public boolean deleteCar(String carId) throws SQLException {
        int cnt = 0;
        DBConnection dbCon = DBConnection.getInstance();

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
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
            dbCon.dbClose(con, pstmt, null);
        }
    }// deleteCar
}// class
