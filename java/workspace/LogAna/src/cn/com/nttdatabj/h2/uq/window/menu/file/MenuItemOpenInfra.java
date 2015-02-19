package cn.com.nttdatabj.h2.uq.window.menu.file;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import cn.com.nttdatabj.h2.uq.LAMsg;
import cn.com.nttdatabj.h2.uq.window.menu.MenuItems;

public class MenuItemOpenInfra extends MenuItems {
	
	MenuItemOpenInfra() {
		super();
	}
	
	@Override
	public JMenuItem CreateMenuItem(){
		JMenu mntmOpen = new JMenu(LAMsg.MSG0041);
		mntmOpen.setMnemonic('I');
		
		MenuItemOpenInfraApacheThread mntmOpenInfraApacheThread = 
			new MenuItemOpenInfraApacheThread();
		mntmOpen.add(mntmOpenInfraApacheThread.CreateMenuItem());
		
		MenuItemOpenInfraCq5Thread mntmOpenInfraCq5Thread =
			new MenuItemOpenInfraCq5Thread();
		mntmOpen.add(mntmOpenInfraCq5Thread.CreateMenuItem());
		
		MenuItemOpenInfraNdevSar mntmOpenInfraNdevSar =
			new MenuItemOpenInfraNdevSar();
		mntmOpen.add(mntmOpenInfraNdevSar.CreateMenuItem());
		
		MenuItemOpenInfraNedevSar mntmOpenInfraNedevSar = 
			new MenuItemOpenInfraNedevSar();
		mntmOpen.add(mntmOpenInfraNedevSar.CreateMenuItem());
		
		MenuItemOpenInfraPs mntmOpenInfraPs =
			new MenuItemOpenInfraPs();
		mntmOpen.add(mntmOpenInfraPs.CreateMenuItem());
		
		MenuItemOpenInfraPSar mntmOpenInfraPSar =
			new MenuItemOpenInfraPSar();
		mntmOpen.add(mntmOpenInfraPSar.CreateMenuItem());
		
		MenuItemOpenInfraRSar mntmOpenInfraRSar =
			new MenuItemOpenInfraRSar();
		mntmOpen.add(mntmOpenInfraRSar.CreateMenuItem());
		
		MenuItemOpenInfraVmstat mntmOpenInfraVmstat =
			new MenuItemOpenInfraVmstat();
		mntmOpen.add(mntmOpenInfraVmstat.CreateMenuItem());
		
		return mntmOpen;
	}
}
