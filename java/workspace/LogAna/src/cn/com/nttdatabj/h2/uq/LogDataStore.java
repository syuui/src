package cn.com.nttdatabj.h2.uq;

import java.util.ArrayList;
import java.util.List;

public class LogDataStore {
	public static enum LogDataType {
		CQ5_ACCESS,
		CQ5_AUDIT,
		CQ5_ERROR,
		CQ5_HISTORY,
		CQ5_GC,
		CQ5_REQUEST,
		CQ5_STDERR,
		CQ5_STDOUT,
		CQ5_UNIQLO,
		CQ5_UPGRADE,
		HTTPD_ACCESS,
		HTTPD_DISPATCHER,
		HTTPD_ERROR,
		HTTPD_REWRITE,
		INFRA_APACHE_THREAD,
		INFRA_CQ5_THREAD,
		INFRA_NDEV_SAR,
		INFRA_NEDEV_SAR,
		INFRA_PS,
		INFRA_P_SAR,
		INFRA_R_SAR,
		INFRA_VMSTAT
	};
	
	private static LogDataStore instance = new LogDataStore();
	private List<String> _logData;
	private LogDataType _logType;
	private int current;
	
	private LogDataStore() {
		_logData = new ArrayList<String>();
		current = 0;
	}
	public static LogDataStore getInstance() {  
		return instance;  
	}
	
	public void SetLogData( List<String> LogData ) {
		ClearLogData();
		_logData.addAll(LogData);
	}
	public void SetLogData( List<String> LogData, LogDataType LogType ) {
		ClearLogData();
		_logData.addAll(LogData);
		_logType = LogType;
	}
	public void PushLogdata( String LogData ) {
		_logData.add(LogData);
	}
	public List<String> GetLogData() {
		return _logData;
	}
	public void ClearLogData() {
		_logData.clear();
	}
		
	public void SetLogType( LogDataType LogType ) {
		_logType = LogType;
	}
	public LogDataType GetLogType() {
		return _logType;
	}
	public void MoveFirst() {
		current = 0;
	}
	public void MoveLast() {
		if( _logData != null)
			current = _logData.size()-1;
	}
	public String GetNext() {
		if( _logData !=null && current < _logData.size()) {
			return _logData.get(current++);
		} else {
			return null;
		}
	}
	public boolean EndOfData() {
		return _logData==null || current >= _logData.size() ;
	}
}
