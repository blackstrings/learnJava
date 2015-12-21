package com.xai.gui.jframe.rp.dao;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.xai.gui.jframe.rp.RpgUtil;
import com.xai.gui.jframe.rp.domain.Mon;

public class MonDaoImpl implements MonDao {
	
	private HashMap<Integer,Mon> monMap;
	
	public MonDaoImpl(){
		monMap = new HashMap<Integer, Mon>();
		populateMonRepo();
	}
	
	private void populateMonRepo(){
		JSONObject obj = new RpgUtil().getJsonObject("res/files/rpg/monData.txt");
		
		JSONArray jsArr = obj.getJSONArray("mons");
		for(int i=0; i<jsArr.length(); i++){
			String name = jsArr.getJSONObject(i).getString("name");
			Integer id = jsArr.getJSONObject(i).getInt("id");
			Integer lvl = jsArr.getJSONObject(i).getInt("lvl");
			Mon mon = new Mon(id, name, lvl);
			monMap.put(id, mon);
			
		}
		
	}
	
	@Override
	public int getSize(){
		return monMap.size();
	}
	
	@Override
	public Mon getMon(Integer id) {
		if(monMap.containsKey(id)){
			return monMap.get(id);
		}
		System.out.println("no match found for key: " + id);
		return null;
	}

	@Override
	public void add(Integer id, Mon mon) {
		if(!monMap.containsKey(id)){
			monMap.put(id, mon);
		}
		System.out.println("key is already in use");
	}
	
	
}
