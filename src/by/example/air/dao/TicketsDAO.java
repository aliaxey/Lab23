package by.example.air.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.example.air.Connector;
import by.example.air.beans.Ticket;

public class TicketsDAO {

	Statement st;
	public TicketsDAO() {
		super();
		try {
			st = Connector.getDatabase().createStatement();
			st.execute("SET NAMES UTF8");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Ticket> getTickets() {
		String query = "SELECT * FROM `tickets`;";
		List<Ticket> list = new ArrayList<Ticket>();
		try {
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				list.add(new Ticket(
						rs.getInt("id"),rs.getString("name"), 
						rs.getString("lastname"), 
						rs.getInt("cost"),
						rs.getString("date") , 
						rs.getInt("rase_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	public void writeTicket(Ticket ticket) {
		String query = "INSERT INTO `tickets`(name,lastname,cost,date,rase_id) VALUES('%s','%s',%d,'%s',%d);";
		query = String.format(query,
				ticket.getName(),
				ticket.getLastname(),
				ticket.getCost(),
				ticket.getDate(),
				ticket.getRaceId()
				);
		try {
			st.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public Ticket getTicket(int id) {
		String query = "SELECT * FROM `tickets` WHERE id = %d;";
		query = String.format(query,id);
		Ticket ticket = null;
		try {
			 ResultSet rs = st.executeQuery(query);
			 ticket = new Ticket(
						rs.getInt("id"),rs.getString("name"), 
						rs.getString("lastname"), 
						rs.getInt("cost"),
						rs.getString("date") , 
						rs.getInt("rase_id"));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ticket;
	}
}
