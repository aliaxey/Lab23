package by.example.air.beans;


public class Ticket {
	private int id;
	private String name;
	private String lastname;
	private int cost;
	private String date;
	private int raseId;
	
	public Ticket() {
		super();
	}
	
	public Ticket(int id, String name, String lastname, int cost, String date, int raseId) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.cost = cost;
		this.date = date;
		this.raseId = raseId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getRaceId() {
		return raseId;
	}

	public void setRaceId(int raceId) {
		this.raseId = raceId;
	}
}
