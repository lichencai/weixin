package weixin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/web/article")
public class ArticleController {

	@RequestMapping(value = {"/show"}, method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView show(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ModelAndView mav = new ModelAndView("/goPay");
		return mav;
	}
	
}
