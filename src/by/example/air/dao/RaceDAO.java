package by.example.air.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.example.air.Connector;
import by.example.air.beans.Race;

public class RaceDAO {
	Connection db;
	public RaceDAO() {
		super();
		try {
			db = Connector.getDatabase();
			db.createStatement().execute("SET NAMES UTF8");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Race> getRaces() {
		String query = "SELECT * FROM `race`;";
		List<Race> list = new ArrayList<>();
		try {
			ResultSet rs = db.createStatement().executeQuery(query);
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
		String query = "SELECT * FROM `race` WHERE id =?;";
		try {
			 PreparedStatement statement = db.prepareStatement(query);
			 statement.setInt(1, id);
			 ResultSet rs = statement.executeQuery();
			 rs.next();
			 race = new Race(rs.getInt("id"), rs.getString("plane"), rs.getString("source"), rs.getString("destanation"));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return race;
	}
	public void writeRace(HttpServletRequest request) {
		String query = "INSERT INTO `race`(plane,source,destanation) VALUES(?,?,?);";
		try {
			PreparedStatement statement = db.prepareStatement(query);
			statement.setString(1, request.getParameter("plane"));
			statement.setString(2, request.getParameter("source"));
			statement.setString(3, request.getParameter("destanation"));
			statement.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		};
	}
}
