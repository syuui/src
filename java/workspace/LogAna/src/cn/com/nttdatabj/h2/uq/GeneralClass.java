package cn.com.nttdatabj.h2.uq;

import cn.com.nttdatabj.h2.uq.window.MainWindow;


public class GeneralClass {
	
	private MainWindow _window = null;
	private static GeneralClass _instance = new GeneralClass();
	
	@SuppressWarnings("unused")
	private LogDataStore _dataStore = LogDataStore.getInstance();
	

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		@SuppressWarnings("unused")
		GeneralClass _Class = GeneralClass.getInstance();
		
	}
	public GeneralClass() {
		_window = new MainWindow();
		_window.setVisible(true);
		
	}	
	public MainWindow getMainWindowInstance() {
		return _window;
	}
	
	public static GeneralClass getInstance() {
		return _instance;
	}
}
