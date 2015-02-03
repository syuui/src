package cn.com.nttdatabj.h2.uq.window;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import cn.com.nttdatabj.h2.uq.window.menu.file.MenuFile;
import cn.com.nttdatabj.h2.uq.window.menu.log.MenuLog;
import cn.com.nttdatabj.h2.uq.window.menu.tools.MenuTools;

public class MainWindow extends JFrame{

	public static String SINGLE_CQ_ACCESS_LOG_VIEW = "SINGLE_CQ_ACCESS_LOG_VIEW";
	public static String BLANK_VIEW = "BLANK_VIEW";
	private static String WINDOW_NAME = "UFO（UQ Fast Operation）";

	private JPanel _WorkingPanel = new JPanel();
	private CardLayout _WPLayout = new CardLayout();
	
	/**
	 * JPanel of Working Area
	 * @return
	 */
	public JPanel get_WorkingPanel() {
		return _WorkingPanel;
	}
	/**
	 * JPanel of Working Area
	 * @param _WorkingPanel
	 */
	public void set_WorkingPanel(JPanel _WorkingPanel) {
		this._WorkingPanel = _WorkingPanel;
	}
	/**
	 * Card Layout of Working Area
	 * @return
	 */
	public CardLayout get_WPLayout() {
		return _WPLayout;
	}
	/**
	 * Card Layout of Working Area
	 * @param _WPLayout
	 */
	public void set_WPLayout(CardLayout _WPLayout) {
		this._WPLayout = _WPLayout;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		super();
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
	
	/**
	 * Set JPanel
	 */
	public void setJPanel(JPanel panel) {
		getContentPane().add(panel);
		setVisible(true);
	}
}
