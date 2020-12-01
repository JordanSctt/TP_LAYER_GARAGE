package fr.greta.java.box.facade;

import fr.greta.java.ConnectionFactory;
import fr.greta.java.box.domain.Box;
import fr.greta.java.box.domain.BoxService;
import fr.greta.java.box.persistence.BoxRepository;
import fr.greta.java.generic.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoxClearServletController extends HttpServlet {

    private ConnectionFactory connectionFactory = new ConnectionFactory();
    private BoxService service = new BoxService();

    private static final String PARAMETER_KEY_BOX_ID = "box_id";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Box box = findOrNull(request);
        if(box != null) {
            service.clear();
            response.sendRedirect(request.getContextPath() + "/box.jsp");
        } else {
            redirectClearError(request, response);
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

    private void redirectClearError(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/box?errorMessage=CLEAR_ERROR");
    }
}

