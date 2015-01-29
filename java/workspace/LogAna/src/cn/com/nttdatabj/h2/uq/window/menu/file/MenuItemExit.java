package cn.com.nttdatabj.h2.uq.window.menu.file;

import javax.swing.JMenuItem;

import cn.com.nttdatabj.h2.uq.window.menu.MenuItems;

import com.sun.glass.events.KeyEvent;

public class MenuItemExit extends MenuItems {

	public JMenuItem CreateMenuItem(){
		JMenuItem mntmOpen = new JMenuItem("終了(X)", KeyEvent.VK_X);
		mntmOpen.addActionListener(new MenuItemExitAction());
		return mntmOpen;
	}

}
