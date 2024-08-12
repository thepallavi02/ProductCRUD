package product.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import product.Model.Product;

@Repository
public class UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//add product
	@Transactional	
	public void addProduct(Product product) {
		hibernateTemplate.setCheckWriteOperations(false);
		this.hibernateTemplate.saveOrUpdate(product);
		System.out.println("addprpduct happened");
	}
	
	//get all products
	public List<Product>getProducts(){
	 List<Product>products =this.hibernateTemplate.loadAll(Product.class);
	 return products;
	}
	
	//delete single product
	@Transactional
	public void deleteProduct(int pid) {
	    Product product = this.hibernateTemplate.load(Product.class,pid);
		this.hibernateTemplate.delete(product);
	}
	
	
	//get single product
	public Product getProduct(int pid) {
	    Product product =this.hibernateTemplate.get(Product.class, pid);
	    return product;
	}
}
