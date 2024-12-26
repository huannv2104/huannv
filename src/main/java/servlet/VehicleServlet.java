package servlet;

import com.dao.VehicleDao;
import com.model.Vehicle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/VehicleServlet")
public class VehicleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VehicleDao vehicleDao;

    @Override
    public void init() throws ServletException {
        try {
            vehicleDao = new VehicleDao();
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Vehicle> vehicles = vehicleDao.getAllVehicles();
            request.setAttribute("vehicles", vehicles);
            request.getRequestDispatcher("vehicle.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("add".equals(action)) {
                String name = request.getParameter("name");
                String licensePlate = request.getParameter("license_plate");
                int userId = Integer.parseInt(request.getParameter("user_id"));
                Vehicle vehicle = new Vehicle();
                vehicle.setName(name);
                vehicle.setLicensePlate(licensePlate);
                vehicle.setUserId(userId);
                vehicleDao.addVehicle(vehicle);
            } else if ("update".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String licensePlate = request.getParameter("license_plate");
                int userId = Integer.parseInt(request.getParameter("user_id"));
                Vehicle vehicle = new Vehicle();
                vehicle.setId(id);
                vehicle.setName(name);
                vehicle.setLicensePlate(licensePlate);
                vehicle.setUserId(userId);
                vehicleDao.updateVehicle(vehicle);
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                vehicleDao.deleteVehicle(id);
            }
            response.sendRedirect("VehicleServlet");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}