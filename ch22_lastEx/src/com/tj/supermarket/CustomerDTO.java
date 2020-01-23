package com.tj.supermarket;

public class CustomerDTO {
	private String	ctel;
	private String	cname;
	private int		point;
	private int		amount;
	private String	levelname;
	private int	levelup;
	
	public CustomerDTO() {}
	
	public CustomerDTO(String ctel, String cname, int point, int amount, String levelname, int levelup) {
		this.ctel = ctel;
		this.cname = cname;
		this.point = point;
		this.amount = amount;
		this.levelname = levelname;
		this.levelup = levelup;
	}

	@Override
	public String toString() {
		return ctel + "\t" + cname + "\t" + point + "\t" + amount + "\t" + levelname + "\t" + levelup;
	}
	
	
	
}
