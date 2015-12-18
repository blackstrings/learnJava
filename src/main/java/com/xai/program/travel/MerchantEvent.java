package com.xai.program.travel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MerchantEvent extends TravelEvent {

	private List<Item> items;
	private int MAXITEM = 3;
	
	public MerchantEvent(User user){
		super(user);
		
		//populate with some random items
		items = new ArrayList<Item>();
		populateItems();
	}
	
	private void populateItems(){
		Random rand = new Random();
		ItemType[] itemType = ItemType.values();
		
		int counter = 0;
		int index = 0;
		
		while(counter < MAXITEM){
			index = rand.nextInt(itemType.length);			//rand up to the max size only
			items.add(new Item(itemType[index]));			//pick a random enum value
			counter++;
		}
	}
	
	@Override
	public void action() {
		Scanner sc = new Scanner(System.in);
		
		int key = 0;
		
		do{	//allow keys only within range
			TravelUtils.print("Pick item - use index - g:" + user.g);
			
			//System.out.println(items);
			printItems();
			
			key = sc.nextInt();
		}while(key < 0 || key >= items.size());
		
		int itemc = items.get(key).getCost();
		if( !(user.g - itemc < 0)){
			user.g -= items.get(key).getCost();
			user.add(items.remove(key));
		}else{
			System.out.println("too ex");
		}
		
		clearEvent();
	}
	
	private void printItems(){
		for(Item item : items){
			System.out.print(item + ",");
		}
	}

	
}
