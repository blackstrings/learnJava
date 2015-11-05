package com.xai.program.hero.inventory;

import java.util.ArrayList;
import java.util.List;

public class Hero extends User{

	private int hp = 0;
	private List<Item> items;
	private int MAXITEMS = 5;
	Object currTarget = null;
	
	public Hero(){
		hp = 100;
		items = new ArrayList<Item>();
	}
	
	public Hero(int startingHP){
		this.hp = startingHP;
		items = new ArrayList<Item>();
	}
	
	public void takeItem(Item item){
		if(items.size() < MAXITEMS){
			items.add(item);
		}else{
			System.out.println("items maxed");
		}
	}
	
	public void removeItem(Item item){
		if( items.contains(item) ){
			items.remove(item);
		}
	}
	
	@Override
	public void modHP(int amt){
		hp += amt;
	}
	
	@Override
	public void useTool(ToolItem item){
		
	}
	
	public void use(Item item, Object target){
		boolean isItemFullyEmpty = item.useOn(target);
		if(isItemFullyEmpty){
			removeItem(item);
		}
	}
	
	public void use(String searchKey, Object target){
		
		if(items.size() <= 0){
			System.out.println("items is empty");
			return;
		}
		
		for(int i=0; i<items.size(); i++){
			if(items.get(i).name.equals(searchKey)){
				use(items.get(i), target);	//consumes target item
				break;	//once item is found, we stop searching the loop
			}
		}
		
		
	}
		
	
	public void getStatus(){
		System.out.println(this);
	}
	
	@Override
	public String toString(){
		return "HP:"+ hp + ", "
				+ "Items: " + items.size();
	}


	@Override
	public void applyTool(ToolItem toolItem) {
		if(toolItem.name.equals("Oxygen Tank")){
			System.out.println("Applying " + toolItem.name);
		}
	}
}
