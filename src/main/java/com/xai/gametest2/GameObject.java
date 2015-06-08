package com.xai.gametest2;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Currently, all dynamic properties are stored on game object as a hashmap
 * that way any subclass of GameObject can store properties of any type values with string keys
 * may be better to move properties elsewhere, not sure, but since properties is here, all objects can have unique properties
 * 
 */
public abstract class GameObject {

	/**
	 * 1st attempt
	 * properties is the object's core center of properties
	 * name, speed, age, durability, rarity, price, etc.
	 * this map is dynamic and should be able to hold values of
	 * different types
	 * every object can have different value types and quantity of properties
	 */
	private Map<Prop, Object> properties;
	
	
	
	/**
	 * 2nd attempt in progress - not sure if 1st attempt is efficient enough
	 */
	/*
	private Map<String, List<Property>> properties2;
	Property p = new Property();
	p.put("name", "Tommy");
	p.put("speed", 5.0);
	p.put("durability", 5);
	p.put("helath", 100);
	
	-- later in the program when I need an object's property, I should be able to do this
	-- without have to up cast to a type like
	-- int hp = (int) anyObject1.getProperty("heath");  // not want I want to go with
	
	-- I sholud be able to do this instead // what I would perfer to go with
	int hp = anyObject1.getProperty("health");
	string name = anyObject1.getName("name");
	
	*/

	public enum Prop{
		MIN_RARITY, MAX_RARITY, RARITY, 
		MAX_STACK, STACK,STACKABLE, 
		NAME,
		DURABILITY,MAX_DURABILITY,
		MIN_PRICE,MAX_PRICE,PRICE,
		MIN_SIZE, MAX_SIZE, SIZE, 
		LBS_PER_FOOT, WEIGHT;
	}
	
	public GameObject(){
		
	}
	
	/**
	 * Setters allows you to put any object type
	 */
	public boolean setProp(Prop key, Object value){
		if(properties == null){
			properties = new EnumMap<Prop, Object>(Prop.class);
		}
		properties.put(key, value);
		return true;
	}
	
	/**
	 * get the property value from the map returned with the proper type cast
	 * @param prop
	 * @return
	 */
	public <E> E getProp(Prop prop){
		Object result = properties.get(prop);
		
		//shorter way
		if(result instanceof Boolean){ return (E) (Boolean) result; }
		if(result instanceof String){ return (E) (String) result; }
		if(result instanceof Integer){ return (E) (Integer) result; }
		if(result instanceof Double){ return (E) (Double) result; }
		if(result instanceof Byte){ return (E) (Byte) result;}
		
		return null;	//the stored type is not yet implemented in here
		
		//longer way
		/*
		if(result instanceof Boolean){
			Boolean val = (Boolean) result;
			return (E) val;
		}
		*/
	}
	
	
	/**
	 * Getters GetP = getProperty
	 * the design pattern issue here is that
	 * you have to know the return value type
	 * to call the properties you want
	 *
	 */
	/* ----- old way of doing
	public String getPString(String key){
		if(properties != null){
			return (String) properties.get(key);
		}else{
			return null;
		}
	}
	
	public Integer getPInt(String key){
		if(properties != null){
			return (Integer) properties.get(key);
		}else{
			return null;
		}
	}*/
	
	
	public EnumMap<Prop, Object> getPropertyMap(){
		return (EnumMap<Prop, Object>) properties;
	}
	public void setPropertyMap(EnumMap<Prop, Object> properties){
		this.properties = properties;
	}
	
	/**
	 * Looks up if the property exist
	 * @param key
	 * @return
	 */
	public boolean hasProp(Prop key){
		if(properties != null){
			if(properties.containsKey(key)){
				return true;
			}
		}
		return false;
	}
	
	// remove
	public boolean removeProp(Prop key){
		if(properties != null){
			if(properties.containsKey(key)){
				properties.remove(key);
				return true;
			}
			return false;
		}else{
			return false;
		}
	}
	
	/* Helper functions */
	public String getName(){
		return getProp(Prop.NAME);
	}
	public void setName(String name){
		setProp(Prop.NAME, name);
	}
	
}
