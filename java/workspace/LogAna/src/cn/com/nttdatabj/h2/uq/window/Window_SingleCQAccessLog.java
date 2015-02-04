package cn.com.nttdatabj.h2.uq.window;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.com.nttdatabj.h2.uq.bean.BeanCqAccess;


public class Window_SingleCQAccessLog extends JPanel {
	protected static Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int _width = 480;
	private int _height = 640;
	private static int CONTROL_HEIGHT = 20;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblIPs;
	private JLabel lblIdMethod;
	private JLabel lblID;
	private JLabel lblDate;
	private JLabel lblRequest;
	private JLabel lblResCode;
	private JLabel lblResByte;
	private JTextField txtIPs;
	private JTextField txtMethod;
	private JTextField txtID;
	private JTextField txtDate;
	private JTextField txtRequest;
	private JTextField txtResCode;
	private JTextField txtResByte;

	/**
	 * Create the panel.
	 */
	public Window_SingleCQAccessLog() {
		setLayout(null);
		setBounds(0, 0, _width, _height);

		lblIPs = new JLabel("Client IP");
		lblIPs.setBounds(5, 5, 95, CONTROL_HEIGHT);

		lblIdMethod = new JLabel("Identity");
		lblIdMethod.setBounds(5, 30, 95, CONTROL_HEIGHT);

		lblID = new JLabel("ID");
		lblID.setBounds(5, 55, 95, CONTROL_HEIGHT);

		lblDate = new JLabel("DateTime");
		lblDate.setBounds(5, 80, 95, CONTROL_HEIGHT);

		lblRequest = new JLabel("Request");
		lblRequest.setBounds(5, 105, 95, CONTROL_HEIGHT);

		lblResCode = new JLabel("Response Code");
		lblResCode.setBounds(5, 130, 95, CONTROL_HEIGHT);

		lblResByte = new JLabel("Response Bytes");
		lblResByte.setBounds(5, 155, 95, CONTROL_HEIGHT);

		txtIPs = new JTextField();
		txtIPs.setBounds(100, 5, 530, CONTROL_HEIGHT);

		txtMethod = new JTextField();
		txtMethod.setBounds(100, 30, 530, CONTROL_HEIGHT);

		txtID = new JTextField();
		txtID.setBounds(100, 55, 530, CONTROL_HEIGHT);

		txtDate = new JTextField();
		txtDate.setBounds(100, 80, 530, CONTROL_HEIGHT);

		txtRequest = new JTextField();
		txtRequest.setBounds(100, 105, 530, CONTROL_HEIGHT);

		txtResCode = new JTextField();
		txtResCode.setBounds(100, 130, 530, CONTROL_HEIGHT);

		txtResByte = new JTextField();
		txtResByte.setBounds(100, 155, 530, CONTROL_HEIGHT);

		lblIPs.setLabelFor(txtIPs);
		lblIdMethod.setLabelFor(txtMethod);
		lblID.setLabelFor(txtID);
		lblDate.setLabelFor(txtDate);
		lblRequest.setLabelFor(txtRequest);
		lblResCode.setLabelFor(txtResCode);
		lblResByte.setLabelFor(txtResByte);

		add(lblIPs);
		add(lblIdMethod);
		add(lblID);
		add(lblDate);
		add(lblRequest);
		add(lblResCode);
		add(lblResByte);

		add(txtIPs);
		add(txtMethod);
		add(txtID);
		add(txtDate);
		add(txtRequest);
		add(txtResCode);
		add(txtResByte);
	}

	public void setData(BeanCqAccess in) {
		List<String> ips = in.get_clientIP();
		for (int i = 0; i < ips.size(); i++) {
			if (i == 0) {
				txtIPs.setText(ips.get(i));
			} else {
				txtIPs.setText(txtIPs.getText() + " - " + ips.get(i));
			}
		}

		txtMethod.setText(in.get_identity());
		txtID.setText(in.get_userID());
		txtDate.setText(format.format(in.get_dateTime()) + " "
				+ in.get_timeZone());
		txtRequest.setText(in.get_request() + " " + in.get_url() + " "
				+ in.get_httpVersion());
		txtResCode.setText(in.get_responseCode());
		txtResByte.setText(String.valueOf(in.get_bytes()));
	}	
}
