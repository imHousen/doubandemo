package hjs.model;

public class Fruitltem {
	private String number;// ���
	private String unitPrice;// ����
	private String remarks;// ��ע
	private String fruitname;// ˮ������
	private String placeofOrigin;// ����

	public Fruitltem() {
		super();
	}

	public Fruitltem(String number, String unitPrice, String remarks,
			String fruitname, String placeofOrigin) {
		super();
		this.fruitname = fruitname;
		this.number = number;
		this.placeofOrigin = placeofOrigin;
		this.remarks = remarks;
		this.unitPrice = unitPrice;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String string) {
		this.unitPrice = string;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getFruitname() {
		return fruitname;
	}

	public void setFruitname(String fruitname) {
		this.fruitname = fruitname;
	}

	public String getPlaceofOrigin() {
		return placeofOrigin;
	}

	public void setPlaceofOrigin(String placeofOrigin) {
		this.placeofOrigin = placeofOrigin;
	}
}
