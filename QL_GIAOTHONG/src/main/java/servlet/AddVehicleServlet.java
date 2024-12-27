package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.DatabaseConnection;

@WebServlet("/addVehicle")
public class AddVehicleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  String vehicleName = request.getParameter("vehicleName");
          String licensePlate = request.getParameter("licensePlate");
          int userId = Integer.parseInt(request.getParameter("userId"));

          try (Connection conn = DatabaseConnection.getConnection()) {
              String sql = "INSERT INTO vehicles (vehicle_name, license_plate, user_id) VALUES (?, ?, ?)";
              try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                  stmt.setString(1, vehicleName);
                  stmt.setString(2, licensePlate);
                  stmt.setInt(3, userId);
                  stmt.executeUpdate();
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }

          response.sendRedirect("list.jsp");
      }
}
