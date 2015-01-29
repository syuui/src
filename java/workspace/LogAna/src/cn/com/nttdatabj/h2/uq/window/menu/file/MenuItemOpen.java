package cn.com.nttdatabj.h2.uq.window.menu.file;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import cn.com.nttdatabj.h2.uq.window.menu.MenuItems;

public class MenuItemOpen extends MenuItems {

	MenuItemOpen() {
		super();
	}

	@Override
	public JMenuItem CreateMenuItem() {
		JMenu mntmOpen = new JMenu("ファイルを開く(O)");
		mntmOpen.setMnemonic('O');

		MenuItemOpenCQ mntmOpenCQ = new MenuItemOpenCQ();
		mntmOpen.add(mntmOpenCQ.CreateMenuItem());

		MenuItemOpenHttpd mntmOpenHttpd = new MenuItemOpenHttpd();
		mntmOpen.add(mntmOpenHttpd.CreateMenuItem());

		MenuItemOpenInfra mntmOpenInfra = new MenuItemOpenInfra();
		mntmOpen.add(mntmOpenInfra.CreateMenuItem());

		return mntmOpen;
	}
}