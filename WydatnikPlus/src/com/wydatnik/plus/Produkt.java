package com.wydatnik.plus;


public class Produkt {

	/**
	 * nazwa produktu, pobrana z bazy danych
	 * @uml.property  name="nazwa"
	 */
	private String nazwa;

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
	private int id;

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
	private double cena;

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
	private int jednostka;

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

}
