package hjs.util;

public class StrUtil {
	/*
	 ÅĞ¶ÏÊÇ·ñÎª¿Õ
	 @param str
	 @return
	 */
	public static boolean isEmpty(String str){
		if(str == null||"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	/*
	 ÅĞ¶Ï²»Îª¿Õ
	 @param str
	 @return
	 */
	public static boolean isNotEmpty(String str){
		if(str != null&&!"".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
}

