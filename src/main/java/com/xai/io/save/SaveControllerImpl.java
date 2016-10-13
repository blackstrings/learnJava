package com.xai.io.save;

import java.io.IOException;
import java.util.List;

import com.xai.io.IOUtils;


public class SaveControllerImpl extends SaveControllerAbs {

	public boolean isSave;
	
	public SaveControllerImpl() {
		
	}
	
	@Override
	public void save(String pathToFile, List<String> dataToSave) {
		IOUtils.writeLargerTextFile(pathToFile, dataToSave);
	}

	
}
