package by.example.air.contrllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.example.air.beans.Ticket;
import by.example.air.dao.RaceDAO;
import by.example.air.dao.TicketsDAO;
@WebServlet("/newTicket")
public class NewTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public NewTicket() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Post only <a href = \"register.jsp\">Регистрация</a>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			RaceDAO raceDAO = new RaceDAO();
			TicketsDAO ticketsDAO = new TicketsDAO();
			int id = Integer.parseInt(request.getParameter("id"));
			if(raceDAO.getRace(id) == null) {
				showError(response);
			}else {
				Ticket ticket = new Ticket(0,
						request.getParameter("name"), 
						request.getParameter("lastname"), 
						Integer.parseInt(request.getParameter("cost")), 
						request.getParameter("date"), 
						id);
				ticketsDAO.writeTicket(ticket);
				response.sendRedirect(request.getContextPath()+"/register.jsp?st=1");
			}
		}catch (NumberFormatException e) {
			showError(response);
		}
	}
	private void showError(HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("<h2>Неправильные данные</h2>");
		response.getWriter().append("<br<a href = \"register.jsp\">Регистрация</a>");
	}
}
