package com.xai.patterns.state2.state;

public interface IState {
	void execute();
	IState nextState();
}
