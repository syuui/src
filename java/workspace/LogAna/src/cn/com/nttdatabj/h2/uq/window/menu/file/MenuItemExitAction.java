package cn.com.nttdatabj.h2.uq.window.menu.file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemExitAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// String buttonName = arg0.getActionCommand();
		Action();
		return;
	}

	private void Action() {
		System.exit(0);
		return;
	}
}
