package com.xai.gui.jframe.rp.dao;

import com.xai.gui.jframe.rp.domain.Mon;

public interface MonDao {
	public static final int BASE_ID = 1001;	//1000 will error if 0 is generated for randomizing
	public Mon getMon(Integer id);
	public void add(Integer id, Mon mon);
	public int getSize();
}
