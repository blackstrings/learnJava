package com.xai.patterns.state.phase;

import com.xai.patterns.state.Phase;

public interface IPhase {
	public void setNextPhase(IPhase phase);
	public void execute();
}
