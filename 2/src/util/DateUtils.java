package util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateUtils {

	private static String format = "yyyyMMddHHmmss";
	private static String format1 = "yyyy-MM-dd HH:mm:ss";
	private static String format2 = "yyyy-MM-dd HH:mm";
	private static String format3 = "yyyy-MM-dd";
	private static String format4 = "yyyy年MM月dd日";
	private static String format5 ="yyyyMMdd";
	private static String format6 ="HH:mm:ss";
	private static String format7 ="HHmmss";

	/**
	 * 根据用户自定义时间格式获取系统当前时间
	 * @param fmt
	 * @return
	 */
	public static String getCurrentTimeByFormat(String fmt) {
		SimpleDateFormat sft = new SimpleDateFormat(fmt);
		return sft.format(new Date());
	}

	/**
	 * 以yyyyMMddHHmmss时间格式获取系统当前时间
	 * @param fmt
	 * @return
	 */
	public static String getCurrentTime() {
		SimpleDateFormat sft = new SimpleDateFormat("yyyyMMddHHmmss");
		return sft.format(new Date());
	}

	/**
	 * 格式化日期：yyyy-MM-dd HH:mm:ss
	 * @param time
	 * @param fmt
	 * @return
	 */
	public static String getTimeAs19String(String time) {
		Date date = parseToDateTime(time, format);
		SimpleDateFormat sft = new SimpleDateFormat(format1);
		if(date==null) {
			return null;
		}else {
			return sft.format(date);
		}
	}

	/**
	 * 格式化日期：yyyy-MM-dd HH:mm
	 * @param time
	 * @param fmt
	 * @return
	 */
	public static String getTimeAs16String(String time) {
		Date date = parseToDateTime(time, format);
		SimpleDateFormat sft = new SimpleDateFormat(format2);
		if(date==null) {
			return null;
		}else {
			return sft.format(date);
		}
	}

	/**
	 * 格式化日期：yyyy-MM-dd
	 * @param time
	 * @param fmt
	 * @return
	 */
	public static String getTimeAs10String(String time) {
		Date date = parseToDateTime(time, format);
		SimpleDateFormat sft = new SimpleDateFormat(format3);
		if(date==null) {
			return null;
		}else {
			return sft.format(date);
		}
	}

	/**
	 * 格式化时间：HH:mm:ss
	 * @param time
	 * @return
	 */
	public static String getTimeAs8String1(String time) {
		Date date = parseToDateTime(time, format7);
		SimpleDateFormat sft = new SimpleDateFormat(format6);
		if(date==null) {
			return null;
		}else {
			return sft.format(date);
		}
	}

	/**
	 * 将yyyyMMdd格式化日期：yyyy-MM-dd
	 * @param time
	 * @param fmt
	 * @return
	 */
	public static String getTimeAs10String1(String time) {
		time+="000000";
		Date date = parseToDateTime(time, format);
		SimpleDateFormat sft = new SimpleDateFormat(format3);
		if(date==null) {
			return null;
		}else {
			return sft.format(date);
		}
	}
	/**
	 * 格式化日期：yyyyMMdd
	 * @param time
	 * @return
	 */
	public static String getTimeAs8String(String time) {
		Date date;
		if(time.length()<11) {
			date= parseToDateTime(time, format3);
		}else {
			date = parseToDateTime(time, format);
		}
		SimpleDateFormat sft = new SimpleDateFormat(format5);
		if(date==null) {
			return null;
		}else {
			return sft.format(date);
		}
	}

	/**
	 * 格式化日期：yyyy年MM月dd日
	 * @param time
	 * @param fmt
	 * @return
	 */
	public static String getTimeAs11String(String time) {
		Date date;
		if(time.length()<11) {
			date= parseToDateTime(time, format5);
		}else {
			date = parseToDateTime(time, format);
		}
		SimpleDateFormat sft = new SimpleDateFormat(format4);
		if(date==null) {
			return null;
		}else {
			return sft.format(date);
		}
	}

	/**
	 * 时间格式String转Date
	 * @param date 字符串时间
	 * @param fmt 字符串格式
	 * @return
	 */
	public static Date parseToDateTime(String date,String fmt) {
		try {
			return StringUtils.isBlank(date) ? null : new SimpleDateFormat(fmt).parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
