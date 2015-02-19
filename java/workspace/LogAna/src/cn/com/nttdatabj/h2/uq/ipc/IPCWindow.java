package cn.com.nttdatabj.h2.uq.ipc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cn.com.nttdatabj.h2.uq.LAMsg;

public class IPCWindow extends JFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/***
	 * Controllers on the panel
	 */
	private JTextField txtNetDec;
	private JTextField txtSubDec;
	private JTextField txtMinDec;
	private JTextField txtMaxDec;
	private int _subnetMask = 0;
	private int _networkIP = 0;

	/**
	 * Create the frame.
	 */
	public IPCWindow() {
		setResizable(false);
		setTitle(LAMsg.MSG0050);
		setIcon();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 200);
		getContentPane().setLayout(null);
		setControllers();
	}

	private void calculate() {
		_subnetMask = 0;
		_networkIP = 0;

		if (blankValues())
			return;

		if (!getAddress()) {
			JOptionPane.showMessageDialog(txtNetDec, LAMsg.MSG0051);
			txtNetDec.grabFocus();
			return;
		}

		if (!getSubnetMask()) {
			JOptionPane.showMessageDialog(txtSubDec, LAMsg.MSG0052);
			txtSubDec.grabFocus();
			return;
		}

		int mn = _networkIP & _subnetMask;
		int mx = _networkIP | (~_subnetMask);

		int s1 = 0, s2 = 0, s3 = 0, s4 = 0;
		s1 = (mn >> 24) & 0x000000FF;
		s2 = (mn >> 16) & 0x000000FF;
		s3 = (mn >> 8) & 0x000000FF;
		s4 = (mn & 0x000000FF);
		txtMinDec.setText(s1 + "." + s2 + "." + s3 + "." + s4);

		s1 = (mx >> 24) & 0x000000FF;
		s2 = (mx >> 16) & 0x000000FF;
		s3 = (mx >> 8) & 0x000000FF;
		s4 = (mx & 0x000000FF);
		txtMaxDec.setText(s1 + "." + s2 + "." + s3 + "." + s4);

	}

	private boolean blankValues() {
		if (txtNetDec.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(txtNetDec, LAMsg.MSG0053);
			txtNetDec.grabFocus();
			return true;
		}

		if (txtSubDec.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(txtSubDec, LAMsg.MSG0054);
			txtSubDec.grabFocus();
			return true;
		}

		return false;
	}

	private boolean getSubnetMask() {
		String regex = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(txtSubDec.getText().trim());

		_subnetMask = 0;

		if (m.find()) {
			int tmp = 0;
			if ((tmp = (Integer.parseInt(m.group(1)))) > 255)
				return false;
			_subnetMask |= (tmp << 24);
			if ((tmp = (Integer.parseInt(m.group(2)))) > 255)
				return false;
			_subnetMask |= (tmp << 16);
			if ((tmp = (Integer.parseInt(m.group(3)))) > 255)
				return false;
			_subnetMask |= (tmp << 8);
			if ((tmp = (Integer.parseInt(m.group(4)))) > 255)
				return false;
			_subnetMask |= tmp;

			int binaryValueOfSubnetMask = 0;
			int FlagMask = 0x80000000;
			boolean networkFlag = true;
			for (int i = 0; i < 32; i++, FlagMask >>= 1) {
				if ((!networkFlag)
						&& ((FlagMask & binaryValueOfSubnetMask) == FlagMask))
					return false;
				if ((FlagMask & binaryValueOfSubnetMask) != FlagMask
						&& networkFlag)
					networkFlag = false;
			}
		} else {
			regex = "^(\\d{1,2})$";
			p = Pattern.compile(regex);
			m = p.matcher(txtSubDec.getText().trim());
			if (!m.find())
				return false;
			int bits = Integer.parseInt(txtSubDec.getText().trim());
			if (bits > 32)
				return false;

			for (int msk = 0x80000000; bits > 0; bits--, msk >>= 1) {
				_subnetMask |= msk;
			}
		}

		return true;
	}

	private boolean getAddress() {
		String regex = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(txtNetDec.getText().trim());
		if (!m.find())
			return false;

		_networkIP = 0;

		int tmp = 0;
		if ((tmp = (Integer.parseInt(m.group(1)))) > 255)
			return false;
		_networkIP |= (tmp << 24);
		if ((tmp = (Integer.parseInt(m.group(2)))) > 255)
			return false;
		_networkIP |= (tmp << 16);
		if ((tmp = (Integer.parseInt(m.group(3)))) > 255)
			return false;
		_networkIP |= (tmp << 8);
		if ((tmp = (Integer.parseInt(m.group(4)))) > 255)
			return false;
		_networkIP |= tmp;

		return true;
	}

	private void setControllers() {
		JLabel lblNet = new JLabel("Network Address");
		lblNet.setBounds(7, 5, 100, 20);
		lblNet.setHorizontalAlignment(SwingConstants.LEFT);

		txtNetDec = new JTextField();
		lblNet.setLabelFor(txtNetDec);
		txtNetDec.setBounds(150, 5, 250, 20);
		txtNetDec.setHorizontalAlignment(SwingConstants.LEFT);
		txtNetDec.setColumns(15);
		getContentPane().add(lblNet);
		getContentPane().add(txtNetDec);

		JLabel lblSub = new JLabel("Subnet Mask");
		lblSub.setHorizontalAlignment(SwingConstants.LEFT);
		lblSub.setBounds(7, 35, 100, 20);
		getContentPane().add(lblSub);

		txtSubDec = new JTextField();
		lblSub.setLabelFor(txtSubDec);
		txtSubDec.setHorizontalAlignment(SwingConstants.LEFT);
		txtSubDec.setColumns(15);
		txtSubDec.setBounds(150, 35, 250, 20);
		getContentPane().add(txtSubDec);

		JLabel lblA11 = new JLabel("Dec");
		lblA11.setHorizontalAlignment(SwingConstants.LEFT);
		lblA11.setBounds(110, 5, 30, 20);
		getContentPane().add(lblA11);

		JLabel label_1 = new JLabel("Dec");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setBounds(110, 35, 30, 20);
		getContentPane().add(label_1);

		JLabel lblMin = new JLabel("Min IP Address");
		lblMin.setHorizontalAlignment(SwingConstants.LEFT);
		lblMin.setBounds(7, 70, 100, 20);
		getContentPane().add(lblMin);

		JLabel label_3 = new JLabel("Dec");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setBounds(110, 70, 30, 20);
		getContentPane().add(label_3);

		txtMinDec = new JTextField();
		txtMinDec.setEditable(false);
		txtMinDec.setHorizontalAlignment(SwingConstants.LEFT);
		txtMinDec.setColumns(15);
		txtMinDec.setBounds(150, 70, 250, 20);
		getContentPane().add(txtMinDec);

		JLabel lblMax = new JLabel("Max IP Address");
		lblMax.setHorizontalAlignment(SwingConstants.LEFT);
		lblMax.setBounds(7, 100, 100, 20);
		getContentPane().add(lblMax);

		JLabel label_6 = new JLabel("Dec");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setBounds(110, 100, 30, 20);
		getContentPane().add(label_6);

		txtMaxDec = new JTextField();
		txtMaxDec.setEditable(false);
		txtMaxDec.setHorizontalAlignment(SwingConstants.LEFT);
		txtMaxDec.setColumns(15);
		txtMaxDec.setBounds(150, 100, 250, 20);
		getContentPane().add(txtMaxDec);

		JButton btnCalc = new JButton(LAMsg.VAR0002);
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calculate();
			}
		});
		btnCalc.setBounds(309, 130, 60, 20);
		getContentPane().add(btnCalc);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 65, 420, 1);
		getContentPane().add(separator);

		return;
	}
	
	private void setIcon() {
		ImageIcon icon = new ImageIcon(LAMsg.VAR0003);
		setIconImage(icon.getImage());
	}
}
