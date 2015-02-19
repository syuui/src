package cn.com.nttdatabj.h2.uq.window.menu.log;

import javax.swing.JMenu;

import cn.com.nttdatabj.h2.uq.LAMsg;
import cn.com.nttdatabj.h2.uq.window.menu.Menus;

public class MenuLog extends Menus {

	@Override
	public JMenu CreateMenu(){
		final JMenu mn = new JMenu(LAMsg.MSG0200);
		mn.setMnemonic('L');
			
		MenuItemSingleLog mntmSingleLog = new MenuItemSingleLog();
		mn.add(mntmSingleLog.CreateMenuItem());
		/*	
		mn.addSeparator();
		
		MenuItemExit mntmExit = new MenuItemExit();
		mn.add(mntmExit.CreateMenuItem());
		*/
		return mn;
	}
	
}
