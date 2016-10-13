package com.xai.io.save;

import java.io.IOException;
import java.util.List;

public abstract class SaveControllerAbs {
	
	public abstract void save(String pathToFile, List<String> dataToSave);
	
}
