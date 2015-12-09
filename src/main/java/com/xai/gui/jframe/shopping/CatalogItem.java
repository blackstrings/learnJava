package com.xai.gui.jframe.shopping;

public class CatalogItem {

	private String catalogNumber;
	private String description;
	private double price;
	private String imgPath;

	public CatalogItem(String catNum, String desc, double cost, String imgPath){
		this.catalogNumber = catNum;
		this.description = desc;
		this.price = cost;
		this.imgPath = imgPath;
	}
	
	public CatalogItem(CatalogItem item){
		this.catalogNumber = item.getCatalogNumber();
		this.description = item.getDescription();
		this.price = item.getPrice();
		this.imgPath = item.getImgPath();
	}
	
	public String getCatalogNumber() {
		return catalogNumber;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}
	
	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	public String toString(){
		return getClass().getSimpleName()
				+ ", catNum: " + catalogNumber
				+ ", desc: " + description
				+ ", price: " + price;
		//we do not need to print the image path name to string
		//as the path is use to load the image rather than print the image path
	}
}
