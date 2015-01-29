package cn.com.nttdatabj.h2.uq.window.menu.file;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import cn.com.nttdatabj.h2.uq.window.menu.MenuItems;

public class MenuItemOpenCQ extends MenuItems {
	
	MenuItemOpenCQ() {
		super();
	}
	
	@Override
	public JMenuItem CreateMenuItem(){
		JMenu mntmOpen = new JMenu("CQ");
		mntmOpen.setMnemonic('C');
		
		MenuItemOpenCQAccess mntmOpenCQAccess = 
			new MenuItemOpenCQAccess();
		mntmOpen.add(mntmOpenCQAccess.CreateMenuItem());
		
		MenuItemOpenCQAudit mntmOpenCQAudit =
			new MenuItemOpenCQAudit();
		mntmOpen.add(mntmOpenCQAudit.CreateMenuItem());
		
		MenuItemOpenCQError mntmOpenCQError =
			new MenuItemOpenCQError();
		mntmOpen.add(mntmOpenCQError.CreateMenuItem());
		
		MenuItemOpenCQGc mntmOpenCQGc = 
			new MenuItemOpenCQGc();
		mntmOpen.add(mntmOpenCQGc.CreateMenuItem());
		
		MenuItemOpenCQHistory mntmOpenCQHistory =
			new MenuItemOpenCQHistory();
		mntmOpen.add(mntmOpenCQHistory.CreateMenuItem());
		
		MenuItemOpenCQRequest mntmOpenCQRequest = 
			new MenuItemOpenCQRequest();
		mntmOpen.add(mntmOpenCQRequest.CreateMenuItem());
		
		MenuItemOpenCQStderr mntmOpenCQStderr = 
			new MenuItemOpenCQStderr();
		mntmOpen.add(mntmOpenCQStderr.CreateMenuItem());
		
		MenuItemOpenCQStdout mntmOpenCQStdout =
			new MenuItemOpenCQStdout();
		mntmOpen.add(mntmOpenCQStdout.CreateMenuItem());
		
		MenuItemOpenCQUniqlo mntmOpenCQUniqlo = 
			new MenuItemOpenCQUniqlo();
		mntmOpen.add(mntmOpenCQUniqlo.CreateMenuItem());
		
		MenuItemOpenCQUpgrade mntmOpenCQUpgrade = 
			new MenuItemOpenCQUpgrade();
		mntmOpen.add(mntmOpenCQUpgrade.CreateMenuItem());
		
		return mntmOpen;
	}
}
