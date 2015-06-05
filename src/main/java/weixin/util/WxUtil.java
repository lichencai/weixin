package weixin.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import weixin.wxap.util.MD5Util;
import weixin.wxap.util.TenpayUtil;

public class WxUtil {
	
	public static String getOut_trade_no(){
		//��ǰʱ�� yyyyMMddHHmmss
		String currTime = TenpayUtil.getCurrTime();
		//8λ����
		String strTime = currTime.substring(8, currTime.length());
		//��λ�����
		String strRandom = TenpayUtil.buildRandom(4) + "";
		//10λ���к�,�������е�����
		String strReq = strTime + strRandom;
		//�����ţ��˴���ʱ�����������ɣ��̻������Լ����������ֻҪ����ȫ��Ψһ����
		String out_trade_no = strReq;
		return out_trade_no;
	}
	
	/**
	 * ͳһ֧���ӿ����ɵ�sign
	 */
	public static String createSign(String characterEncoding, SortedMap<Object,Object> parameters){
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + SystemUtil.API_KEY);
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        return sign;
    }
	
	/**
	 * ת��xml��ʽ
	 */
	public static String getRequestXml(SortedMap<Object,Object> parameters){
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if ("attach".equalsIgnoreCase(k)||"body".equalsIgnoreCase(k)||"sign".equalsIgnoreCase(k)) {
                sb.append("<"+k+">"+"<![CDATA["+v+"]]></"+k+">");
            }else {
                sb.append("<"+k+">"+v+"</"+k+">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }
	
	
	/**
     * ����xml,���ص�һ��Ԫ�ؼ�ֵ�ԡ������һ��Ԫ�����ӽڵ㣬��˽ڵ��ֵ���ӽڵ��xml���ݡ�
     * @param strxml
     * @return
     * @throws JDOMException
     * @throws IOException
     */
    public static Map doXMLParse(String strxml) throws Exception {
        strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");

        if(null == strxml || "".equals(strxml)) {
            return null;
        }
        
        Map m = new HashMap();
        
        InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
        SAXReader reader = new SAXReader();
        Document document = reader.read(in);  
	    // �õ�xml��Ԫ��  
	    Element root = document.getRootElement();  
	    // �õ���Ԫ�ص������ӽڵ�  
	    List<Element> elementList = root.elements();  
	  
	    // ���������ӽڵ�  
	    for (Element e : elementList)  
	        m.put(e.getName(), e.getText());  
	  
	    // �ͷ���Դ  
	    in.close();  
	    in = null;  
	  
	    return m;  
    }
}
