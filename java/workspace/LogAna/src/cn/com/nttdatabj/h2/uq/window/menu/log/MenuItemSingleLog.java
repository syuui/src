package cn.com.nttdatabj.h2.uq.window.menu.log;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import cn.com.nttdatabj.h2.uq.LAMsg;
import cn.com.nttdatabj.h2.uq.window.menu.MenuItems;

public class MenuItemSingleLog extends MenuItems {

	MenuItemSingleLog() {
		super();
	}

	@Override
	public JMenuItem CreateMenuItem() {
		JMenu mntmOpen = new JMenu(LAMsg.MSG0100);
		mntmOpen.setMnemonic('A');

		MenuItemSingleLogCQAccess mntmOpenCQ = new MenuItemSingleLogCQAccess();
		mntmOpen.add(mntmOpenCQ.CreateMenuItem());

		return mntmOpen;
	}
}
