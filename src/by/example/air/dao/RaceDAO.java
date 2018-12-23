package by.example.air.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.example.air.Connector;
import by.example.air.beans.Race;

public class RaceDAO {
	
	Statement st;
	public RaceDAO() {
		super();
		try {
			st = Connector.getDatabase().createStatement();
			st.execute("SET NAMES UTF8");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Race> getRaces() {
		String query = "SELECT * FROM `race`;";
		List<Race> list = new ArrayList<>();
		try {
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				list.add(new Race(
						rs.getInt("id"),
						rs.getString("plane"),
						rs.getString("source"),
						rs.getString("destanation")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	public Race getRace(int id) {
		Race race = null;
		String query = "SELECT * FROM `race` WHERE id = %d;";
		query = String.format(query,id);
		try {
			 ResultSet rs = st.executeQuery(query);
			 rs.next();
			 race = new Race(rs.getInt("id"), rs.getString("plane"), rs.getString("source"), rs.getString("destanation"));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return race;
	}
	public void writeRace(HttpServletRequest request) {
		String query = "INSERT INTO `race`(plane,source,destanation) VALUES('%s','%s','%s');";
		query = String.format(query, 
				request.getParameter("plane"),
				request.getParameter("source"),
				request.getParameter("destanation"));
		try {
			
			st.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		};
	}
}
