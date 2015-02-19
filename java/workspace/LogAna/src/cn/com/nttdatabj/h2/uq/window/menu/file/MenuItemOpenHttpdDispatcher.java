package cn.com.nttdatabj.h2.uq.window.menu.file;

import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;

import cn.com.nttdatabj.h2.uq.LAMsg;
import cn.com.nttdatabj.h2.uq.window.menu.MenuItems;


public class MenuItemOpenHttpdDispatcher extends MenuItems {

	@Override
	public JMenuItem CreateMenuItem() {
		JMenuItem mntm = new JMenuItem(LAMsg.MSG0033, KeyEvent.VK_D);
		mntm.setEnabled(false);
		mntm.addActionListener(new MenuItemOpenCQAccessAction());
		return mntm;
	}
}
