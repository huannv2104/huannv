package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.DatabaseConnection;
import com.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

@WebServlet("/listVehicles")
public class ShowVehiclesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = -1;
        
        // Check if userId parameter is present in the request
        String userIdParam = request.getParameter("userId");
        if (userIdParam != null && !userIdParam.isEmpty()) {
            try {
                userId = Integer.parseInt(userIdParam);
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid userId");
                return;
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "userId parameter is missing");
            return;
        }

        List<Vehicle> vehiclesList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM vehicles WHERE user_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, userId);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Vehicle vehicle = new Vehicle(rs.getInt("id"), rs.getString("vehicle_name"), rs.getString("license_plate"), rs.getInt("user_id"));
                        vehiclesList.add(vehicle);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Set list of vehicles as request attribute
        request.setAttribute("vehicles", vehiclesList);
        // Forward to the JSP page
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
