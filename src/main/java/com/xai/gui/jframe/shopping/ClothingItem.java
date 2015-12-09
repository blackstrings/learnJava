package com.xai.gui.jframe.shopping;

public class ClothingItem extends CatalogItem{

	private String size;
	
	//modify constructor
	public ClothingItem(String catNum, String desc, double cost, String imgPath){
		super(catNum, desc, cost, imgPath);
	}
	
	//copy constructor used to copy a catalog item into a clothing item
	public ClothingItem(CatalogItem item){
		super(item.getCatalogNumber(), item.getDescription(), item.getPrice(), item.getImgPath());
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	@Override
	public String toString(){
		return super.toString()
				+ ", size: " + size;
	}
	
	
}
