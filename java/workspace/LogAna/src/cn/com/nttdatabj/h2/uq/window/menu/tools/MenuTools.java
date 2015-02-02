package cn.com.nttdatabj.h2.uq.window.menu.tools;

import javax.swing.JMenu;

import cn.com.nttdatabj.h2.uq.window.menu.Menus;

public class MenuTools extends Menus {

	@Override
	public JMenu CreateMenu(){
		final JMenu mn = new JMenu("ツール(T)");
		mn.setMnemonic('T');
		
		MenuItemIPC mntmIPC = new MenuItemIPC();
		mn.add(mntmIPC.CreateMenuItem());
/*		
		MenuItemOpen mntmOpen = new MenuItemOpen();
		mnFile.add(mntmOpen.CreateMenuItem());
		
		mnFile.addSeparator();
		
		MenuItemExit mntmExit = new MenuItemExit();
		mnFile.add(mntmExit.CreateMenuItem());
		*/
		return mn;
	}
	
}
