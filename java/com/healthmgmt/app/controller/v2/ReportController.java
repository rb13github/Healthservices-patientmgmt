package com.healthmgmt.app.controller.v2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.healthmgmt.app.entity.Product;
import com.healthmgmt.app.entity.v1.Productv1;
import com.healthmgmt.app.entity.v2.ProductAllocationGroup;
import com.healthmgmt.app.service.ProductService;
import com.healthmgmt.app.service.v1.ProductServicev1;
import com.healthmgmt.app.service.v2.ProductAllocationGroupService;

@Controller
@RequestMapping("/healthmgmt/report")
public class ReportController {
 
   
    @Autowired
    ProductAllocationGroupService productAllocationGroupService;
     
    // handler methods...
    
    @GetMapping
	public String webget (Model model){
    	model.addAttribute("message", "Your rquest is handled by --- "+ReportController.class.getName());
		
    	
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        Calendar cal = Calendar.getInstance();
    	model.addAttribute("today",dateFormat.format(cal.getTime()));
    	
    	return "index";
	
	}
    
    @GetMapping("/fetch")
	public String  fetchProductAllocationGroupReport(Model model){
    	List<ProductAllocationGroup>  listProductAllocationGroup=new ArrayList<ProductAllocationGroup>();
		System.out.println("in the listProductAllocationGroup==================");
		listProductAllocationGroup=productAllocationGroupService.fetchProductAllocationGroupReport();
		 model.addAttribute("listProductAllocationGroup", listProductAllocationGroup);
		 return "fetch_productallocation_group";
	}
    
   
    

    @RequestMapping("/getProductsgroup")
    public String viewProductsGroupPage(Model model) {
        List<Object []> listProducts = productAllocationGroupService.groupBy();
        
        // List<ProductAllocationGroup> listProducts = productAllocationGroupService.groupBy();
       // listProducts.Select(function(i) i.ToString()).ToList();
        model.addAttribute("listProducts", listProducts);
        System.out.println("listproducts    :   "+listProducts);
         
        return "fetch_productallocation_group";
    }
   
   
}
