package weixin.wxap.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLUtil {

	/**
	 * ����xml,���ص�һ��Ԫ�ؼ�ֵ�ԡ������һ��Ԫ�����ӽڵ㣬��˽ڵ��ֵ���ӽڵ��xml���ݡ�
	 * @param strxml
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	public static Map doXMLParse(String strxml) throws Exception {
		if(null == strxml || "".equals(strxml)) {
			return null;
		}
		
		Map m = new HashMap();
		InputStream in = HttpClientUtil.String2Inputstream(strxml);
		SAXReader reader = new SAXReader();
		Document doc = reader.read(in);
		Document document = reader.read(in);  
	    // �õ�xml��Ԫ��  
	    Element root = document.getRootElement();  
	    // �õ���Ԫ�ص������ӽڵ�  
	    List<Element> elementList = root.elements();  
	  
	    // ���������ӽڵ�  
	    for (Element e : elementList)  
	        m.put(e.getName(), e.getText());  
		
		//�ر���
		in.close();
		
		return m;
	}
	
	/**
	 * ��ȡ�ӽ���xml
	 * @param children
	 * @return String
	 */
	/*public static String getChildrenText(List children) {
		StringBuffer sb = new StringBuffer();
		if(!children.isEmpty()) {
			Iterator it = children.iterator();
			while(it.hasNext()) {
				Element e = (Element) it.next();
				String name = e.getName();
				String value = e.getTextNormalize();
				List list = e.getChildren();
				sb.append("<" + name + ">");
				if(!list.isEmpty()) {
					sb.append(XMLUtil.getChildrenText(list));
				}
				sb.append(value);
				sb.append("</" + name + ">");
			}
		}
		
		return sb.toString();
	}*/
	
	/**
	 * ��ȡxml�����ַ���
	 * @param strxml
	 * @return
	 * @throws IOException 
	 * @throws JDOMException 
	 */
	public static String getXMLEncoding(String strxml) throws Exception {
		InputStream in = HttpClientUtil.String2Inputstream(strxml);
		SAXReader reader = new SAXReader();
		Document doc = reader.read(in);
		in.close();
		return doc.getXMLEncoding();
		/*return (String)doc.getProperty("encoding");*/
	}
	
	
}
