package com.xai.program.hero.inventory;

import java.util.ArrayList;
import java.util.List;

public class BasicUser extends User {

	private int hp = 0;
	public List<StatusType> statusList = new ArrayList<StatusType>();
	private List<Item> items;
	private int MAXITEMS = 5;
	Object currTarget = null;
	
	public BasicUser(){
		hp = 100;
		items = new ArrayList<Item>();
	}
	
	public BasicUser(int startingHP){
		this.hp = startingHP;
		items = new ArrayList<Item>();
	}
	
	@Override
	public void takeItem(Item item){
		if(items.size() < MAXITEMS){
			items.add(item);
		}else{
			System.out.println("items maxed");
		}
	}
	
	@Override
	public void removeItem(Item item){
		if( items.contains(item) ){
			items.remove(item);
		}
	}
	
	@Override
	public void applyHP(int amt){
		hp += amt;
	}
	
	@Override
	public void use(Item item, Object target){
		System.out.println("using " + item.name);
		boolean isItemFullyEmpty = item.useOn(target);
		if(isItemFullyEmpty){
			removeItem(item);
		}
	}
	
	@Override
	public void use(String searchKey, Object target){
		boolean itemFound = false;
		if(items.size() <= 0){
			System.out.println("items is empty");
			return;
		}
		
		for(int i=0; i<items.size(); i++){
			if(items.get(i).name.equals(searchKey)){
				use(items.get(i), target);	//consumes target item
				itemFound = true;
				break;	//once item is found, we stop searching the loop
			}
		}
		
		if(!itemFound){
			System.out.println("item: " + searchKey + " not found. Nothing will be used.");
			
		}
		
	}


	@Override
	public void applyTool(ToolItem toolItem) {
		if(toolItem.name.equals("Oxygen Tank")){
			System.out.println("Applying " + toolItem.name);
		}
	}
	
	@Override
	public boolean hasStatus(StatusType type){
		if(statusList.contains(type)){
			return true;
		}
		return false;
	}
	
	@Override
	public void applyStatus(StatusType type) {
		if(!statusList.contains(type)){
			statusList.add(type);
			System.out.println(type + " is applied");
		}else{
			System.out.println("status: " + type + " is already applied");
		}
	}
	
	@Override
	public void removeSatus(StatusType type) {
		if(statusList.contains(type)){
			statusList.remove(type);
		}
	}
	
	@Override
	public void getUserStatus(){
		System.out.println(this + "\n");
	}
	
	@Override
	public String toString(){
		
		return "HP:"+ hp + ", "
				+ "Items: " + items.size() + " ,"
				+ "statues: " + statusList.toString();
	}
	
}
