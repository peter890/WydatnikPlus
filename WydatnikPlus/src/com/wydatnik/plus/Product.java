package com.wydatnik.plus;


public class Product {

	private String nazwa;
	private int id;
	private int jednostka;
	private double cena;
	private long kod;
	private String opis;
	

	public Product(String nazwa, double cena, int jednostka) {
		super();
		this.nazwa = nazwa;
		this.cena = cena;
		this.jednostka = jednostka;
	}

	public Product(int id, String nazwa, double cena, int jednostka, long kod, String opis) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		this.cena = cena;
		this.jednostka = jednostka;
		this.kod = kod;
		this.opis = opis;
	}

	/**
	 * nazwa produktu, pobrana z bazy danych
	 * @uml.property  name="nazwa"
	 */
	

	/**
	 * Getter of the property <tt>nazwa</tt>
	 * @return  Returns the nazwa.
	 * @uml.property  name="nazwa"
	 */
	public String getNazwa() {
		return nazwa;
	}

	/**
	 * Setter of the property <tt>nazwa</tt>
	 * @param nazwa  The nazwa to set.
	 * @uml.property  name="nazwa"
	 */
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	/**
	 * identyfikator produktu, pobrany z DB
	 * @uml.property  name="id"
	 */
	

	/**
	 * Getter of the property <tt>id</tt>
	 * @return  Returns the id.
	 * @uml.property  name="id"
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter of the property <tt>id</tt>
	 * @param id  The id to set.
	 * @uml.property  name="id"
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @uml.property  name="cena"
	 */
	

	/**
	 * Getter of the property <tt>cena</tt>
	 * @return  Returns the cena.
	 * @uml.property  name="cena"
	 */
	public double getCena() {
		return cena;
	}

	/**
	 * Setter of the property <tt>cena</tt>
	 * @param cena  The cena to set.
	 * @uml.property  name="cena"
	 */
	public void setCena(double cena) {
		this.cena = cena;
	}

	/**
	 * jednostka w jakich podawana jest ilosc produktu. "jednostka" zbudowana w oparciu o enumerator 
	 * @uml.property  name="jednostka"
	 */
	
	/**
	 * Getter of the property <tt>jednostka</tt>
	 * @return  Returns the jednostka.
	 * @uml.property  name="jednostka"
	 */
	public int getJednostka() {
		return jednostka;
	}

	/**
	 * Setter of the property <tt>jednostka</tt>
	 * @param jednostka  The jednostka to set.
	 * @uml.property  name="jednostka"
	 */
	public void setJednostka(int jednostka) {
		this.jednostka = jednostka;
	}
	
	public double getKod() {
		return kod;
	}

	public void setKod(long kod) {
		this.kod = kod;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

}
