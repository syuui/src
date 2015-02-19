package cn.com.nttdatabj.h2.uq.window.menu.file;

import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;

import cn.com.nttdatabj.h2.uq.LAMsg;
import cn.com.nttdatabj.h2.uq.window.menu.MenuItems;


public class MenuItemOpenCQStdout extends MenuItems {

	@Override
	public JMenuItem CreateMenuItem() {
		JMenuItem mntm = new JMenuItem(LAMsg.MSG0021, KeyEvent.VK_O);
		mntm.setEnabled(false);
		mntm.addActionListener(new MenuItemOpenCQAccessAction());
		return mntm;
	}
}
