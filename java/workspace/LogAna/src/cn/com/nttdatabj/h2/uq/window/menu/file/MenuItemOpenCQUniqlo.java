package cn.com.nttdatabj.h2.uq.window.menu.file;

import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;

import cn.com.nttdatabj.h2.uq.LAMsg;
import cn.com.nttdatabj.h2.uq.window.menu.MenuItems;


public class MenuItemOpenCQUniqlo extends MenuItems {

	@Override
	public JMenuItem CreateMenuItem() {
		JMenuItem mntm = new JMenuItem(LAMsg.MSG0022, KeyEvent.VK_U);
		mntm.setEnabled(false);
		mntm.addActionListener(new MenuItemOpenCQAccessAction());
		return mntm;
	}
}
