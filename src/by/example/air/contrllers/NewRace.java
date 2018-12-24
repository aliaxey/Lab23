package by.example.air.contrllers;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.example.air.dao.RaceDAO;
@WebServlet("/newRace")
public class NewRace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewRace() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Post only <a href = \"add_race.jsp\">Добавить рейс</a>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RaceDAO raceDAO = new RaceDAO();
		raceDAO.writeRace(request);
		response.sendRedirect(request.getContextPath()+"/add_race.jsp");
	}
}
