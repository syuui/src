package cn.com.nttdatabj.h2.uq.window.menu.tools;

import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import cn.com.nttdatabj.h2.uq.LAMsg;
import cn.com.nttdatabj.h2.uq.window.menu.MenuItems;


public class MenuItemIPC extends MenuItems {

	public JMenuItem CreateMenuItem(){
		JMenuItem mntmOpen = new JMenuItem(LAMsg.MSG0301, KeyEvent.VK_I);
		mntmOpen.addActionListener(new MenuItemIPCAction());
		return mntmOpen;
	}

}
