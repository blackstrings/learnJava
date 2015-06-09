package com.xai.oopTest2.phases;

import com.xai.oopTest2.Phase;

public interface IPhase {
	public void setNextPhase(IPhase phase);
	public void execute();
}
