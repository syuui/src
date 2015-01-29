package cn.com.nttdatabj.h2.uq.window.menu.file;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import cn.com.nttdatabj.h2.uq.window.menu.MenuItems;

public class MenuItemOpenHttpd extends MenuItems {
	
	MenuItemOpenHttpd() {
		super();
	}
	
	@Override
	public JMenuItem CreateMenuItem(){
		JMenu mntmOpen = new JMenu("HTTPD");
		mntmOpen.setMnemonic('H');
		
		MenuItemOpenHttpdAccess mntmOpenHttpdAccess = 
			new MenuItemOpenHttpdAccess();
		mntmOpen.add(mntmOpenHttpdAccess.CreateMenuItem());
		
		MenuItemOpenHttpdDispatcher mntmOpenHttpdDispatcher =
			new MenuItemOpenHttpdDispatcher();
		mntmOpen.add(mntmOpenHttpdDispatcher.CreateMenuItem());
		
		MenuItemOpenHttpdError mntmOpenHttpdError =
			new MenuItemOpenHttpdError();
		mntmOpen.add(mntmOpenHttpdError.CreateMenuItem());
		
		MenuItemOpenHttpdRewrite mntmOpenHttpdRewrite =
			new MenuItemOpenHttpdRewrite();
		mntmOpen.add(mntmOpenHttpdRewrite.CreateMenuItem());
		
		return mntmOpen;
	}
}
