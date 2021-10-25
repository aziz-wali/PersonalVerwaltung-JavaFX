package application;

public class Person {
	private String id;
	private String vorname;
	private String name;
	private String email;
	private String alt;
	private String addresse;
	private String  telefon;
	
	
	public Person() {
		super();
	}
	public Person( String vorname, String name, String email, String alt, String addresse, String telefon) {
		super();
		this.vorname = vorname;
		this.name = name;
		this.email = email;
		this.alt = alt;
		this.addresse = addresse;
		this.telefon = telefon;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", vorname=" + vorname + ", name=" + name + ", email=" + email + ", alt=" + alt
				+ ", addresse=" + addresse + ", telefon=" + telefon + "]";
	}
	
	
	
}
