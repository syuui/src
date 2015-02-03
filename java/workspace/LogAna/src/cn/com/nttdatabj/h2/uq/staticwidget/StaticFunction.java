package cn.com.nttdatabj.h2.uq.staticwidget;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.com.nttdatabj.h2.uq.bean.BeanCqAccess;

public class StaticFunction {
	/**
	 * 一行のCQ Accessログを解析し、各Fieldを返す
	 * 
	 * @param log
	 *            　一行のCQ Accessログ
	 * @return　FieldのBean
	 */
	public static BeanCqAccess AnalysisSingleCQAccessLog(String log) {
		if (log.trim().isEmpty())
			return null;

		BeanCqAccess rlt;

		// No.1: IPs
		String rIPs = "(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})+";
		// No.2: Protocol, Identity
		String rProtocal = "([^ ]+\\s[^ ]+)";
		// No.3: DateTime
		// No.4: TimeZone
		String rDate = "(\\d{2}/\\w{3}/\\d{4}:\\d{2}:\\d{2}:\\d{2})\\s(\\+\\d{4})";
		// No.5: Request Method
		String rRequest = "\"(GET|POST)";
		// No.6: Request URL
		String rUrl = "([^ ]*)";
		// No.7: Protocol Version
		String rProVer = "(HTTP/[^ ]*)\"";
		// No.8: Response Code
		String rResCode = "(\\d{3})";
		// No.9: Response Bytes
		String rResLen = "(\\d+)";
		// No.10: User Agent
		String rAgent = "\"([^ ]*)\"";
		String regex = "" + rIPs + "\\s*" + rProtocal + "\\s*" + rDate + "\\s*"
				+ rRequest + "\\s*" + rUrl + "\\s*" + rProVer + "\\s*"
				+ rResCode + "\\s*" + rResLen + "\\s*" + rAgent;

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(log);
		
// TODO: Remove 
System.out.println(log);
System.out.println(regex);
		if (m.find()) {
			rlt = new BeanCqAccess();

			rlt.set_clientIP(StaticFunction.getIPs(log));
			rlt.set_identity(m.group(2));

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.ENGLISH);
			Date dt = null;
			try {
System.out.println(m.group(3));
				dt = sdf.parse(m.group(3));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rlt.set_dateTime(dt);
			rlt.set_timeZone(m.group(4));
			rlt.set_request(m.group(5));
			rlt.set_url(m.group(6));
			rlt.set_httpVersion(m.group(7));
			rlt.set_responseCode(m.group(8));
			rlt.set_bytes(m.group(9));
			rlt.set_userAgent(m.group(10));
		} else {
			rlt = null;
		}
		return rlt;
	}

	public static List<String> getIPs(String log) {
		List<String> rlt = new ArrayList<>();
		String rIP = "(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}[\\s,]+)+";

		Pattern p = Pattern.compile(rIP);
		Matcher m = p.matcher(log);
		String subMatch = null;
		if (m.find()) {
			subMatch = m.group(0);
		} else {
			return null;
		}

		rIP = "(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})";
		p = Pattern.compile(rIP);
		m = p.matcher(subMatch);

		while (m.find()) {
			rlt.add(m.group(1));
		}

		return rlt;
	}
}
