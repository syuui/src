package cn.com.nttdatabj.h2.uq.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * BeanCqAccess; CQ Access log Bean
 * 
 * @author zhouw
 *
 */
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

	/**
	 * クライアントIPリスト
	 * 
	 * @return List<String>
	 */
	public List<String> get_clientIP() {
		return _clientIP;
	}

	/**
	 * クライアントIPリスト
	 * 
	 * @param _clientip
	 */
	public void set_clientIP(List<String> _clientip) {
		this._clientIP = _clientip;
	}

	/**
	 * ID認証フィールド、通常は"http"
	 * 
	 * @return
	 */
	public String get_identity() {
		return _identity;
	}

	/**
	 * ID認証フィールド、通常は"http"
	 * 
	 * @param _identity
	 */
	public void set_identity(String _identity) {
		this._identity = _identity;
	}

	/**
	 * ユーザID、通常は‐
	 * 
	 * @return
	 */
	public String get_userID() {
		return _userID;
	}

	/**
	 * ユーザID、通常は‐
	 * 
	 * @param _userid
	 */
	public void set_userID(String _userid) {
		this._userID = _userid;
	}

	/**
	 * 処理完了時刻
	 * 
	 * @return
	 */
	public Date get_dateTime() {
		return _dateTime;
	}

	/**
	 * 処理完了時刻
	 * 
	 * @param time
	 */
	public void set_dateTime(Date time) {
		this._dateTime = time;
	}
	
	/**
	 * 処理完了時刻
	 * 
	 * @param Y
	 * @param M
	 * @param D
	 * @param H
	 * @param I
	 * @param S
	 */
	public void set_dateTime(int Y, int M, int D, int H, int I, int S) {
		Calendar cal = Calendar.getInstance();
		cal.set(Y, M, D, H, I, S);
		this._dateTime = cal.getTime();
	}

	/**
	 * タイムゾーン
	 * 
	 * @return
	 */
	public String get_timeZone() {
		return _timeZone;
	}

	/**
	 * タイムゾーン
	 * 
	 * @param zone
	 */
	public void set_timeZone(String zone) {
		this._timeZone = zone;
	}

	/**
	 * リクエストメゾッド（GETかPOST）
	 * 
	 * @return
	 */
	public String get_request() {
		return _request;
	}

	/**
	 * リクエストメゾッド（GETかPOST）
	 * 
	 * @param _request
	 */
	public void set_request(String _request) {
		this._request = _request;
	}

	/**
	 * リクエストURL
	 * 
	 * @return
	 */
	public String get_url() {
		return _url;
	}

	/**
	 * リクエストURL
	 * 
	 * @param _url
	 */
	public void set_url(String _url) {
		this._url = _url;
	}

	/**
	 * HTTPバージョン
	 * 
	 * @return
	 */
	public String get_httpVersion() {
		return _httpVersion;
	}

	/**
	 * HTTPバージョン
	 * 
	 * @param version
	 */
	public void set_httpVersion(String version) {
		this._httpVersion = version;
	}

	/**
	 * HTTPレスポンスコード
	 * 
	 * @return
	 */
	public String get_responseCode() {
		return _responseCode;
	}

	/**
	 * HTTPレスポンスコード
	 * 
	 * @param code
	 */
	public void set_responseCode(String code) {
		this._responseCode = code;
	}

	/**
	 * 返却バイト数
	 * 
	 * @return
	 */
	public long get_bytes() {
		return _bytes;
	}

	/**
	 * 返却バイト数
	 * 
	 * @param _bytes
	 */
	public void set_bytes(long _bytes) {
		this._bytes = _bytes;
	}

	/**
	 * 返却バイト数
	 * 
	 * @param _bytes
	 */
	public void set_bytes(String _bytes) {
		this._bytes = Long.parseLong(_bytes);
	}

	/**
	 * ユーザリファラField
	 * 
	 * @return
	 */
	public String get_referer() {
		return _referer;
	}

	/**
	 * ユーザリファラField
	 * 
	 * @param _referer
	 */
	public void set_referer(String _referer) {
		this._referer = _referer;
	}

	/**
	 * ユーザエージェントField
	 * 
	 * @return
	 */
	public String get_userAgent() {
		return _userAgent;
	}

	/**
	 * ユーザエージェントField
	 * 
	 * @param agent
	 */
	public void set_userAgent(String agent) {
		this._userAgent = agent;
	}

}
