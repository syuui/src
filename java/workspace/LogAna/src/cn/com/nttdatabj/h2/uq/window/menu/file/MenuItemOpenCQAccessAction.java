package cn.com.nttdatabj.h2.uq.window.menu.file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JLabel;

import cn.com.nttdatabj.h2.uq.GeneralClass;
import cn.com.nttdatabj.h2.uq.LogDataStore;
import cn.com.nttdatabj.h2.uq.bean.BeanCqAccess;
import cn.com.nttdatabj.h2.uq.staticwidget.StaticFunction;
import cn.com.nttdatabj.h2.uq.window.MainWindow;

public class MenuItemOpenCQAccessAction implements ActionListener {
	private final int _FileSelectionMode = JFileChooser.FILES_ONLY;
	private final String _Title = "Open Log File";
	private final String _ButtonName = "Open";
	private final boolean _MultiSelectionEnabled = false;
	LogDataStore store = null;

	MenuItemOpenCQAccessAction() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Action();
		return;
	}

	private void Action() {

		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(_FileSelectionMode);
		jfc.setMultiSelectionEnabled(_MultiSelectionEnabled);
		jfc.showDialog(new JLabel(_Title), _ButtonName);

		if (!_MultiSelectionEnabled) {

			store = LogDataStore.getInstance();

			File f = jfc.getSelectedFile();
			FileReader fr = null;
			BufferedReader br = null;
			String data = null;

			GeneralClass g = GeneralClass.getInstance();
			MainWindow w = g.getMainWindowInstance();
			w.setTitle(f.getName());

			try {
				fr = new FileReader(f);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			br = new BufferedReader(fr);
			try {
				while ((data = br.readLine()) != null) {
					store.PushLogdata(data);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			store.MoveFirst();
			while (!store.EndOfData()) {
				@SuppressWarnings("unused")
				BeanCqAccess tmp = StaticFunction
						.AnalysisSingleCQAccessLog(store.GetNext());
				// TODO: Next

			}
		}
	}
}
