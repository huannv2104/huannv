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

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id")); 
    	String username = request.getParameter("username");
         String password = request.getParameter("password");

         try (Connection conn = DatabaseConnection.getConnection()) {
             if (conn != null) {
                 String sql = "INSERT INTO users (id, username, password) VALUES (?, ?, ?)";
                 try (PreparedStatement ps = conn.prepareStatement(sql)) {
                     ps.setInt(1, id);
                     ps.setString(2, username);
                     ps.setString(3, password);
                     ps.executeUpdate();
                 }
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }

         response.sendRedirect("listUsers");
     }
}
