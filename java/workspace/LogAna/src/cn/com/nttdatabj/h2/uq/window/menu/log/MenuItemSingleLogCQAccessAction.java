package cn.com.nttdatabj.h2.uq.window.menu.log;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import cn.com.nttdatabj.h2.uq.GeneralClass;
import cn.com.nttdatabj.h2.uq.bean.BeanCqAccess;
import cn.com.nttdatabj.h2.uq.staticwidget.StaticFunction;
import cn.com.nttdatabj.h2.uq.window.MainWindow;
import cn.com.nttdatabj.h2.uq.window.Window_SingleCQAccessLog;

public class MenuItemSingleLogCQAccessAction implements ActionListener {

	private final String _Title = "ログ解析";
	private final String _ButtonName = "解析";

	private JTextField txtLog = null;
	private JButton btnAna = null;
	private JFrame inputWindow;

	MenuItemSingleLogCQAccessAction() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Action();
		return;
	}

	private void Action() {
		inputWindow = new JFrame();
		inputWindow.setTitle(_Title);
		inputWindow.setBounds(200, 200, 660, 100);
		inputWindow.getContentPane().setLayout(null);
		inputWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		txtLog = new JTextField();
		txtLog.setBounds(5, 5, 635, 20);
		inputWindow.getContentPane().add(txtLog);

		btnAna = new JButton();
		btnAna.setText(_ButtonName);
		btnAna.setBounds(490, 30, 150, 30);
		btnAna.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAnaPushed();
			}
		});
		inputWindow.getContentPane().add(btnAna);
		inputWindow.setVisible(true);
	}

	private void btnAnaPushed() {
		BeanCqAccess rlt = StaticFunction.AnalysisSingleCQAccessLog(txtLog
				.getText());
		if( rlt == null) {
			// TODO: Log here
			return;
		}
		
		GeneralClass gc = GeneralClass.getInstance();
		MainWindow mw = gc.getMainWindowInstance();

		Window_SingleCQAccessLog view = new Window_SingleCQAccessLog();
		view.setData(rlt);
		
		mw.setJPanel(view);
		inputWindow.setVisible(false);
	}
}
