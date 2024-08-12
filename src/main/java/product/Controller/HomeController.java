package product.Controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import product.Dao.UserDao;
import product.Model.Product;

@Controller
public class HomeController {
	
	@Autowired
	private UserDao user;

	 @RequestMapping("/home")	
	    public String home(Model m) {
			System.out.println("Inside Home");
		    List<Product>products = user.getProducts();
		    m.addAttribute("products",products);
			return "home";
		}
	 
	 @RequestMapping("/add_product")
	 public String add_product(Model m) {
		 System.out.println("Inside add_product");
		 m.addAttribute("title", "Prouct add page");
		 return "add_product";
	 }
	 
	 //handling add form
	 @RequestMapping(value="/handle-product",method=RequestMethod.POST)
	 public String handleProduct(@ModelAttribute Product product,HttpServletRequest session) {
//		 RedirectView redirectView = new RedirectView();
		 System.out.println("Product before save attempt: " + product);
		 user.addProduct(product);
		 System.out.println(product);
//		 redirectView.setUrl(request.getContextPath() + "/home");		 
		 return "redirect:/home";		 
	 }
	 
	 @RequestMapping("/delete/{productId}")
	 public String deleteProduct(@PathVariable("productId") int productId) {
		 System.out.println("product id to be deleted" + productId);
		 user.deleteProduct(productId);
		 return "redirect:/home";
		 
	 }
	 
	 @RequestMapping("/update/{productId}")
	 public String editProduct(@PathVariable("productId") int productId,Model m) {
		 System.out.println("product id to be edited:"+productId);
		 Product product= user.getProduct(productId);
		 m.addAttribute("products", product);		 
         return "update_form";
	 }
	 
//	 @GetMapping(value = "/total_price")
//	 @ResponseBody
//	    public double getTotalPrice() {
//	        List<Product> products = user.getProducts();
//	        double totalPrice = 0;
//	        for (Product product : products) {
//	            totalPrice += product.getPrice();
//	        }
//	        return totalPrice;
//	    }
}
