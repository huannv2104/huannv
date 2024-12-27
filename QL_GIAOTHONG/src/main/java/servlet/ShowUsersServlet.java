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
import com.model.User;

import java.util.ArrayList;
import java.util.List;

@WebServlet("/listUsers")
public class ShowUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> usersList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM users";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
                    usersList.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Set list of users as request attribute
        request.setAttribute("users", usersList);
        // Forward to the JSP page
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
