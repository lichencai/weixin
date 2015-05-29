package weixin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import weixin.service.CoreService;
import weixin.util.SignUtil;

@Controller
public class CoreServlet{  
  
    private static Logger logger = Logger.getLogger(CoreServlet.class);
    
    /** 
     * ȷ����������΢�ŷ����� 
     */  
    @RequestMapping(value = {"/coreServlet"}, method = RequestMethod.GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        // ΢�ż���ǩ��  
        String signature = request.getParameter("signature");  
        // ʱ���  
        String timestamp = request.getParameter("timestamp");  
        // �����  
        String nonce = request.getParameter("nonce");  
        // ����ַ���  
        String echostr = request.getParameter("echostr");  
  
        PrintWriter out = response.getWriter();  
        
        logger.debug(signature + "," + timestamp + "," + nonce + "," + echostr);
        
        // ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
            out.print(echostr);  
        }  
        out.close();  
        out = null;
    }  
  
    /** 
     * ����΢�ŷ�������������Ϣ 
     */  
    @RequestMapping(value = {"/coreServlet"}, method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    	
    	// ��������Ӧ�ı��������ΪUTF-8����ֹ�������룩  
        //request.setCharacterEncoding("UTF-8");  
        //response.setCharacterEncoding("UTF-8");  
    	logger.debug("into...");
    	
        // ���ú���ҵ���������Ϣ��������Ϣ  
        String respMessage = CoreService.processRequest(request);  
          
        // ��Ӧ��Ϣ  
        PrintWriter out = response.getWriter();  
        out.print(respMessage);  
        out.close();
        
        logger.debug("outto...");
    }  
  
} 
