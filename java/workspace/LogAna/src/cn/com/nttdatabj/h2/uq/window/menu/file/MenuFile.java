package cn.com.nttdatabj.h2.uq.window.menu.file;

import javax.swing.JMenu;

import cn.com.nttdatabj.h2.uq.window.menu.Menus;

public class MenuFile extends Menus {

	@Override
	public JMenu CreateMenu(){
		final JMenu mn = new JMenu("ファイル(F)");
		mn.setMnemonic('F');
		
		MenuItemOpen mntmOpen = new MenuItemOpen();
		mn.add(mntmOpen.CreateMenuItem());
		
		mn.addSeparator();
		
		MenuItemExit mntmExit = new MenuItemExit();
		mn.add(mntmExit.CreateMenuItem());
		
		return mn;
	}
	
}
