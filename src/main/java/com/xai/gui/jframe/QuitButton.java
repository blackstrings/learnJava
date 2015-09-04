package com.xai.gui.jframe;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

public class QuitButton extends JButton {

	public QuitButton(String name) {
		super(name);
		//this.setText(TOOL_TIP_TEXT_KEY);

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
	}

}
