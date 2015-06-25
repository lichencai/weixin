package weixin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

public class DateUtil {
	private static String pattern = "yyyy-MM-dd HH:mm:ss";
	
	public static String dateToString(Date date, String type){
		SimpleDateFormat sdf = null;
		if(StringUtils.isEmpty(type)){
			sdf = new SimpleDateFormat(pattern);
		}else{
			sdf = new SimpleDateFormat(type);
		}
		return sdf.format(date);
	}
	
	public static Date stringToDate(String string,String type){
		try{
			SimpleDateFormat sdf = null;
			if(StringUtils.isEmpty(type)){
				sdf = new SimpleDateFormat(pattern);
			}else{
				sdf = new SimpleDateFormat(type);
			}
			return sdf.parse(string);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
}
