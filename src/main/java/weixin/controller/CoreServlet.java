package weixin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import weixin.service.CoreService;
import weixin.util.SignUtil;

@Controller
public class CoreServlet{  
  
    private static Logger logger = Logger.getLogger(CoreServlet.class);
    
    @Autowired
    private CoreService coreService;
    
    /** 
     * 确认请求来自微信服务器 
     */  
    @RequestMapping(value = {"/web/coreServlet"}, method = RequestMethod.GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        // 微信加密签名  
        String signature = request.getParameter("signature");  
        // 时间戳  
        String timestamp = request.getParameter("timestamp");  
        // 随机数  
        String nonce = request.getParameter("nonce");  
        // 随机字符串  
        String echostr = request.getParameter("echostr");  
  
        PrintWriter out = response.getWriter();  
        
        logger.debug(signature + "," + timestamp + "," + nonce + "," + echostr);
        
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
            out.print(echostr);  
        }  
        out.close(); 
        out = null;
    }  
  
    /** 
     * 处理微信服务器发来的消息 
     */  
    @RequestMapping(value = {"/web/coreServlet"}, method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    	
    	// 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        //request.setCharacterEncoding("UTF-8");  
        //response.setCharacterEncoding("UTF-8");  
    	logger.debug("into...");
    	
        // 调用核心业务类接收消息、处理消息  
        String respMessage = coreService.processRequest(request);  
          
        // 响应消息  
        PrintWriter out = response.getWriter();  
        out.print(respMessage);  
        out.close();
        
        logger.debug("outto...");
    }  
  
} 
