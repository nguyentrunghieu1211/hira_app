package org.buianhthang.apps.Helper;

public class Hiragana {
	int id;
	String cauhoi, dapan;

	// khoi tao
	public Hiragana(int id, String cauhoi, String dapan) {

		this.id = id;
		this.cauhoi = cauhoi;
		this.dapan = dapan;
	}

	public Hiragana() {

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the cauhoi
	 */
	public String getCauhoi() {
		return cauhoi;
	}

	/**
	 * @param cauhoi
	 *            the cauhoi to set
	 */
	public void setCauhoi(String cauhoi) {
		this.cauhoi = cauhoi;
	}

	/**
	 * @return the dapan
	 */
	public String getDapan() {
		return dapan;
	}

	/**
	 * @param dapan
	 *            the dapan to set
	 */
	public void setDapan(String dapan) {
		this.dapan = dapan;
	}

}
