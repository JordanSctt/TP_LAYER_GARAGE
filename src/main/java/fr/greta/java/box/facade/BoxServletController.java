package fr.greta.java.box.facade;

import fr.greta.java.generic.exception.ServiceException;
import fr.greta.java.box.domain.Box;
import fr.greta.java.box.domain.BoxService;
import fr.greta.java.vehicle.domain.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/box")
public class BoxServletController extends HttpServlet {

    private BoxService service = new BoxService();

    private BoxDTOWrapper wrapper = new BoxDTOWrapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Box> boxes = service.findAllWithVehicle();
            request.setAttribute("boxes", wrapper.toDTOS(boxes));
            request.getRequestDispatcher("boxes.jsp").forward(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
