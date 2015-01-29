package cn.com.nttdatabj.h2.uq.bean;

import java.util.Date;
import java.util.List;

public class BeanCqAccess {
	private List<String> _clientIP;
	private String _identity;
	private String _userID;
	private Date _dateTime;
	private String _timeZone;
	private String _request;
	private String _url;
	private String _httpVersion;
	private String _responseCode;
	private long _bytes;
	private String _referer;
	private String _userAgent;
	
	public List<String> get_clientIP() {
		return _clientIP;
	}
	public void set_clientIP(List<String> _clientip) {
		_clientIP = _clientip;
	}
	public String get_identity() {
		return _identity;
	}
	public void set_identity(String _identity) {
		this._identity = _identity;
	}
	public String get_userID() {
		return _userID;
	}
	public void set_userID(String _userid) {
		_userID = _userid;
	}
	public Date get_dateTime() {
		return _dateTime;
	}
	public void set_dateTime(Date time) {
		_dateTime = time;
	}
	public String get_timeZone() {
		return _timeZone;
	}
	public void set_timeZone(String zone) {
		_timeZone = zone;
	}
	public String get_request() {
		return _request;
	}
	public void set_request(String _request) {
		this._request = _request;
	}
	public String get_url() {
		return _url;
	}
	public void set_url(String _url) {
		this._url = _url;
	}
	public String get_httpVersion() {
		return _httpVersion;
	}
	public void set_httpVersion(String version) {
		_httpVersion = version;
	}
	public String get_responseCode() {
		return _responseCode;
	}
	public void set_responseCode(String code) {
		_responseCode = code;
	}
	public long get_bytes() {
		return _bytes;
	}
	public void set_bytes(long _bytes) {
		this._bytes = _bytes;
	}
	public void set_types(String _bytes) {
		this._bytes = Long.parseLong(_bytes);
	}
	public String get_referer() {
		return _referer;
	}
	public void set_referer(String _referer) {
		this._referer = _referer;
	}
	public String get_userAgent() {
		return _userAgent;
	}
	public void set_userAgent(String agent) {
		_userAgent = agent;
	}
	
	
}
