package cn.com.nttdatabj.h2.uq.window.menu.file;

import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import cn.com.nttdatabj.h2.uq.LAMsg;
import cn.com.nttdatabj.h2.uq.window.menu.MenuItems;

public class MenuItemExit extends MenuItems {

	public JMenuItem CreateMenuItem(){
		JMenuItem mntmOpen = new JMenuItem(LAMsg.MSG0012, KeyEvent.VK_X);
		mntmOpen.addActionListener(new MenuItemExitAction());
		return mntmOpen;
	}

}
