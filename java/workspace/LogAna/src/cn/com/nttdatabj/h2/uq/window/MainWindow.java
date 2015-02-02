package cn.com.nttdatabj.h2.uq.window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import cn.com.nttdatabj.h2.uq.window.menu.file.MenuFile;
import cn.com.nttdatabj.h2.uq.window.menu.log.MenuLog;
import cn.com.nttdatabj.h2.uq.window.menu.tools.MenuTools;

public class MainWindow extends JFrame{

	private static String WINDOW_NAME = "UFO（UQ Fast Operation）";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setWindow();
		setIcon();
		setMenu();
	}

	/**
	 * Create the window
	 */
	private void setWindow() {
		setCustomTitle();
		setBounds(100, 100, 960, 640);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Set title for the window
	 */
	public void setCustomTitle(String winTitle) {
		setTitle(MainWindow.WINDOW_NAME + " - " + winTitle);
	}
	public void setCustomTitle() {
		setTitle(MainWindow.WINDOW_NAME);
	}
	
	/**
	 * Set icon for the window
	 */
	private void setIcon() {
		ImageIcon icon = new ImageIcon("./img/logo.jpg");
		setIconImage(icon.getImage());
	}
	
	/**
	 * Set menu bar for the window
	 */
	private void setMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		final MenuFile mnFile = new MenuFile();
		menuBar.add(mnFile.CreateMenu());

		final MenuLog mnLog = new MenuLog();
		menuBar.add(mnLog.CreateMenu());
		
		final MenuTools mnTools = new MenuTools();
		menuBar.add(mnTools.CreateMenu());
	}
}
