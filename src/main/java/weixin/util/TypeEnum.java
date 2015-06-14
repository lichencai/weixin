package weixin.util;

public class TypeEnum {
	
	public enum Type {
	   // ���ù��캯������
       NEWS ("01"), FINANCE ("02"), TODAYNEWS ("03"), INDEXNEWS ("04");
 
       // ����˽�б���
       private String nCode ;
 
       // ���캯����ö������ֻ��Ϊ˽��
       private Type( String _nCode) {
           this . nCode = _nCode;
       }
 
       @Override
       public String toString() {
           return this.nCode;
       }
	}
}
