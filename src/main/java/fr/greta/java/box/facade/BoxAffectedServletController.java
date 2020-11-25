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

@WebServlet("/box/affect")
public class BoxAffectedServletController extends HttpServlet {

    private static final String PARAMETER_KEY_BOX_ID = "box_id";
    private static final String PARAMETER_KEY_VEHICLE_BRAND = "vehicle_brand";
    private static final String PARAMETER_KEY_VEHICLE_IMMATRICULATION = "vehicle_immatriculation";

    private BoxService service = new BoxService();

    private BoxDTOWrapper wrapper = new BoxDTOWrapper();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Box box = findOrNull(request);
        if(box != null) {
            request.setAttribute("box", wrapper.toDTO(box));
            request.getRequestDispatcher("/box-affected.jsp").forward(request, response);
        } else {
            redirectAffectedError(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Box box = findOrNull(request);
        try {
            if(box != null) {
                Vehicle vehicle = new Vehicle();
                vehicle.setBrand(request.getParameter(PARAMETER_KEY_VEHICLE_BRAND));
                vehicle.setImmatriculation(request.getParameter(PARAMETER_KEY_VEHICLE_IMMATRICULATION));
                service.affectedNewVehicle(box, vehicle);
                response.sendRedirect(request.getContextPath() + "/box?successMessage=AFFECTED_CREATED");
            } else {
                redirectAffectedError(request, response);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            redirectAffectedError(request, response);
        }

    }

    private Box findOrNull(HttpServletRequest request) {
        try {
            String boxIdStr = request.getParameter(PARAMETER_KEY_BOX_ID);
            if(boxIdStr != null && !boxIdStr.isEmpty()) {
                int boxId = Integer.parseInt(boxIdStr);
                return service.findById(boxId);
            }
        } catch (ServiceException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

	private void redirectAffectedError(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/box?errorMessage=AFFECTED_ERROR");
	}

}
