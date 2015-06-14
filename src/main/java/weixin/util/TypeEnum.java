package weixin.util;

public class TypeEnum {
	
	public enum Type {
	   // 利用构造函数传参
       NEWS ("01"), FINANCE ("02"), TODAYNEWS ("03"), INDEXNEWS ("04");
 
       // 定义私有变量
       private String nCode ;
 
       // 构造函数，枚举类型只能为私有
       private Type( String _nCode) {
           this . nCode = _nCode;
       }
 
       @Override
       public String toString() {
           return this.nCode;
       }
	}
}
