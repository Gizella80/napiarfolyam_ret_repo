package pti.sb_napiarfolyam_rest.dto;

public class ChangeRateDto {
	private String name;
	private int rate;
	
	public ChangeRateDto(int rate, String name) {
		super();
		this.name = name;
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "ChangeRateDto [name=" + name + ", rate=" + rate + "]";
	}

	

}
