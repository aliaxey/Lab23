package by.example.air.beans;

public class Race {
	
	private int id;
	private String plane;
	private String source;
	private String destanation;
	public Race() {
		super();
	}
	public Race(int id, String plane, String source, String destanation) {
		super();
		this.id = id;
		this.plane = plane;
		this.source = source;
		this.destanation = destanation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlane() {
		return plane;
	}
	public void setPlane(String plane) {
		this.plane = plane;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestanation() {
		return destanation;
	}
	public void setDestanation(String destanation) {
		this.destanation = destanation;
	}
	@Override
	@Deprecated
	public String toString() {
		String form = "%-3d%n: %-30s%n -> %-30s%n";
		return String.format(form, id,source,destanation);
	}
	public String getRow() {
		StringBuffer string = new StringBuffer();
		string.append("<tr>");
		string.append("<td>");
		string.append(id);
		string.append("</td>");
		string.append("<td>");
		string.append(source);
		string.append("</td>");
		string.append("<td>");
		string.append(destanation);
		string.append("</td>");
		string.append("</tr>");
		return string.toString();		
	}
}
