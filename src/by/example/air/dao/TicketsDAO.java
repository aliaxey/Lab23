package by.example.air.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.example.air.Connector;
import by.example.air.beans.Ticket;

public class TicketsDAO {
	Connection db;
	public TicketsDAO() {
		super();
		try {
			db = Connector.getDatabase();
			db.createStatement().execute("SET NAMES UTF8");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Ticket> getTickets() {
		String query = "SELECT * FROM `tickets`;";
		List<Ticket> list = new ArrayList<Ticket>();
		try {
			ResultSet rs = db.createStatement().executeQuery(query);
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
		String query = "INSERT INTO `tickets`(name,lastname,cost,date,rase_id) VALUES(?,?,?,?,?);";
		try {
			PreparedStatement statement = db.prepareStatement(query);
			statement.setString(1, ticket.getName());
			statement.setString(2, ticket.getLastname());
			statement.setInt(3, ticket.getCost());
			statement.setString(4, ticket.getDate());
			statement.setInt(5, ticket.getRaceId());		
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public Ticket getTicket(int id) {
		String query = "SELECT * FROM `tickets` WHERE id =?;";
		Ticket ticket = null;
		try {
			PreparedStatement st = db.prepareStatement(query);
			st.setInt(0, id);
			ResultSet rs = st.executeQuery();
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
