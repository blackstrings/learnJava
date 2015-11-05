package com.xai.program.hero.inventory;

import java.util.ArrayList;
import java.util.List;

public class Hero extends User{

	private int hp = 0;
	private List<Item> items;
	private int MAXITEMS = 5;
	
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
	
	public void modHP(int amt){
		hp += amt;
	}
	
	public void consume(Item item){
		boolean isItemFullyEmpty = item.use(this);
		if(isItemFullyEmpty){
			removeItem(item);
		}
	}
	
	public void consume(){
		if(!items.isEmpty()){	//check we have items to consume
			consume(items.get(0));	//consumes first item in sack
		}else{
			System.out.println("no items are avaliable to consume");
		}
	}
	
	public void getStatus(){
		System.out.println(this);
	}
	
	public String toString(){
		return "HP:"+ hp + ", "
				+ "Items: " + items.size();
	}
}
