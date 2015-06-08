package com.xai.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.xai.oopTest1.Troll;

public class Bag extends Item implements IInventory {

	final static Logger logger = Logger.getLogger(Bag.class); 
	
	private int slotsUsed;
	private int slotsCapacity;
	
	private boolean isUsuable = true;
	public enum ITEMTYPE { 
		COIN, WEAPON, MISC
	}
	public enum BALANCETYPE { 
		COUNT, VALUE
	}
	public enum PRINT{
		TOTAL_BALANCE, ALL_COIN_COUNT, ALL_COUN_VALUE
	}
	
	//better to have a map than a array list as finding keys is easier
	//public List<Item> items = new ArrayList<Item>();
	
	public Map<String, List> items = new HashMap<String, List>();
	
	//constructor
	public Bag(String name, int slotCoverage, int maxSlots){
		setName(name);
		setSlotCoverage(slotCoverage);
		setSlotCapacity(maxSlots);
		init();
	}
	
	/**
	 * Create a list for all possible ITEMTYPE
	 */
	private void init(){
		// List<ITEMTYPE> enumList = Arrays.asList(ITEMTYPE.values());
		 for(ITEMTYPE item : ITEMTYPE.values()){
			 List<Item> tempList = new ArrayList<Item>();
			 items.put(item.name(), tempList);
		 }
	}
	
	@Override
	public void setSlotCapacity(int maxSlots){
		this.slotsCapacity = maxSlots;
	}
	
	@Override
	public int getSlotCapacity(){
		return this.slotsCapacity;
	}
	
	@Override
	public int getSlotsUsed(){
		return this.slotsUsed;
	}
	
	@Override
	public void setSlotsUsed(int slotsUsed){
		this.slotsUsed = slotsUsed;
	}
	
	@Override
	public int getSlotsRemaining(){
		return getSlotCapacity() - this.slotsUsed;
	}
	
	@Override
	public boolean isSlotCapacityFull(Item item){
		boolean isEnoughSlotsLeft = getSlotsRemaining() >= item.getSlotCoverage();
		if(isEnoughSlotsLeft){
			updateSlotCapcityUsage(item.getSlotCoverage());
		}
		return isEnoughSlotsLeft;
	}
	
	@Override
	public void updateSlotCapcityUsage(int itemSlotCoverage){
		setSlotsUsed(itemSlotCoverage + getSlotsUsed());
	}
	
	@Override
	public boolean use(){
		if(getIsUsable()){
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Add item
	 * @param item
	 */
	public void addItem(Item item){
		
		if(item instanceof Coin){
			addCoin(item);
		}else if(item instanceof Weapon){
			addWeapon(item);
		}else{
			addMisc(item);
		}
	}
	
	/**
	 * Add coin
	 * @param item
	 */
	private void addCoin(Item item){
		
		List<Item> itemList = items.get(ITEMTYPE.COIN.name());
		
		//if item exist and inside list, target the item and just increment its count
		if(!itemList.isEmpty() && containsInstance(itemList, item.getClass()) ){
			
			//loop for the instance
			for(Item currItem : itemList){
				if(currItem.getClass().getSimpleName().equals(item.getClass().getSimpleName())){
					
					//increment the instance count rather than push another instance into the list
					((Coin)currItem).add(((Coin) item).getCount());

					break;
				}
			}
			
		}else{	
			//if item not yet inside list add new entry
			itemList.add(item);
		}
	}
	
	/**
	 * helper - checks if instance is in list
	 * @param list
	 * @param clazz
	 * @return
	 */
	public <E> boolean containsInstance(List<E> list, Class<? extends E> clazz) {
	    for (E e : list) {
	        if (clazz.isInstance(e)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	/**
	 * Add misc
	 * @param item
	 */
	private void addWeapon(Item item){
		if(isSlotCapacityFull(item)){	
			items.get(ITEMTYPE.WEAPON.name()).add(item);
		}else{
			logCapacityError(item);
		}
	}
	
	/**
	 * Add misc
	 * @param item
	 */
	private void addMisc(Item item){
		if(isSlotCapacityFull(item)){
			items.get(ITEMTYPE.MISC.name()).add(item);
		}else{
			logCapacityError(item);
		}
	}
	
	private void logCapacityError(Item item){
		logger.warn("not enough slots available: \n" + 
				this.toString() + "[capacity]" + getSlotCapacity() + 
				"[remaining]" + getSlotsRemaining() + "\n" +
				"[cannotAdd]" + item.toString() 
				);
	}
	
	public void addItems(String key, List itemList){
		
		//if items is null, create new
		if(items == null){
			items = new HashMap<String, List>();
		}
		
		//if key is null, put the key
		if(items.get(key) == null){
			items.put(key, itemList);
		}else{
			//don't put key, key already exist
			System.out.println("key exist");
		}
	}
	
	/**
	 * Really powerful way to not write else if for all types of coin. Checks item against generic class
	 * @param clazz
	 * @param balanceType
	 * @return
	 */
	public <E extends Coin> int getCoinBalanceByCoinType(Class<E> clazz, BALANCETYPE balanceType){

		if(items.get(Bag.ITEMTYPE.COIN.name()) != null){

			for(Coin item : (List<Coin>) items.get(Bag.ITEMTYPE.COIN.name()) ){
				
				//only way to compare item from list against generic class
				if(clazz.isInstance(item) ){
					if(balanceType.equals(Bag.BALANCETYPE.COUNT))
						return item.getCount();
					else
						return item.getBalance();
				}
				
			} //end of loop
			
		}
		
		return 0;
	}
	
	/*
	public void addToBalance(int newBCount, int newSCount, int newGCount){
		int bCount = getCoinBalanceByCoinType(BronzeCoin.class, Bag.BALANCETYPE.COUNT);
		int sCount = getCoinBalanceByCoinType(SilverCoin.class, Bag.BALANCETYPE.COUNT);
		int gCount = getCoinBalanceByCoinType(GoldCoin.class, Bag.BALANCETYPE.COUNT);
		
		//update the list
		bCount += newBCount;
		sCount += newSCount;
		gCount += newGCount;
		
		items.put(Bag.ITEMTYPE.COIN.name(), new CoinFactory().getCoins(bCount, sCount, gCount));
	}
	
	public void addToBalance(Coin coin){
		if(coin instanceof BronzeCoin){
			addToBalance(coin.getCount(),0,0);
		}else if(coin instanceof SilverCoin){
			addToBalance(0, coin.getCount(),0);
		}else if(coin instanceof GoldCoin){
			addToBalance(0,0,coin.getCount());
		}
	}
	*/
	
	public int getTotalBalance(){
		int total = 0;
		List<Item> list = items.get(ITEMTYPE.COIN.name());
		for(Item item : list){
			total += ((Coin)item).getBalance();
		}
		return total;
		
	}
	
	public void emptyAllCoins(){
		items.put(ITEMTYPE.COIN.name(), new ArrayList<Item>());
	}
	
	public void print(PRINT printEnum){
		if(printEnum.equals(PRINT.TOTAL_BALANCE)){
			System.out.println("TotCoinBal: " + getTotalBalance() );
		}else if(printEnum.equals(PRINT.ALL_COIN_COUNT)){
			for(Coin item : (List<Coin>)items.get(Bag.ITEMTYPE.COIN.name()) ){
				System.out.println(item.getName() + " : " + getCoinBalanceByCoinType(item.getClass(), Bag.BALANCETYPE.COUNT));
			}
		}else if(printEnum.equals(PRINT.ALL_COUN_VALUE)){
			for(Coin item : (List<Coin>)items.get(Bag.ITEMTYPE.COIN.name()) ){
				System.out.println(item.getName() + " : " + getCoinBalanceByCoinType(item.getClass(), Bag.BALANCETYPE.VALUE));
			}
		}
		
	}

}
