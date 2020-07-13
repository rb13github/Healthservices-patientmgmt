package com.healthmgmt.app.controller.v2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.healthmgmt.app.entity.Product;
import com.healthmgmt.app.entity.v1.Productv1;
import com.healthmgmt.app.entity.v2.ProductAllocationGroup;
import com.healthmgmt.app.service.ProductService;
import com.healthmgmt.app.service.v1.ProductServicev1;
import com.healthmgmt.app.service.v2.ProductAllocationGroupService;

@Controller

public class AppErrorController implements ErrorController {
 
   
	 @RequestMapping("/error")
	  @ResponseBody
	  public String handleError(HttpServletRequest request) {
	      Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
	      Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
	      return String.format("<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>"
	                      + "<div>Exception Message: <b>%s</b></div><body></html>",
	              statusCode, exception==null? "N/A": exception.getMessage());
	  }

	  @Override
	  public String getErrorPath() {
	      return "/error";
	  }
	  
}
