package com.clps.jPet.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.clps.jPet.pojo.Category;
import com.clps.jPet.pojo.Item;
import com.clps.jPet.pojo.Product;
import com.clps.jPet.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage("json-default")
public class CategoryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(CategoryAction.class);

	@Autowired
	private CategoryService categoryService;

	private List<Product> productlist;
	private List<Item> itemlist;

	private Category category;
	private Product product;
	private Item item;
	private Long qty;
	private String value;

	// 分页查询参数
	private int begin = 0;
	private int end = 2;

	/**
	 * 获取产品类别
	 * 
	 * @return /catalog/Category.jsp
	 */
	@Action(value = "categoryAction", results = { @Result(name = "success", location = "/catalog/Category.jsp") })
	public String queryProduce() {
		productlist = categoryService.query(category, begin * end, end);
		return "success";
	}

	/**
	 * 查询每类产品的商品
	 * 
	 * @return /catalog/Product.jsp
	 */
	@Action(value = "queryItemAction", results = { @Result(name = "success", location = "/catalog/Product.jsp") })
	public String queryItem() {
		itemlist = categoryService.queryItem(product.getProductid());
		return "success";
	}

	/**
	 * 获取产品详细信息
	 * 
	 * @return /catalog/Item.jsp
	 */
	@Action(value = "queryQtyAction", results = { @Result(name = "success", location = "/catalog/Item.jsp") })
	public String queryQty() {
		qty = categoryService.queryInventory(item.getItemid());
		item = categoryService.queryItemTwo(item.getItemid());
		return "success";
	}

	/**
	 * 搜索/模糊查询
	 * 
	 * @return
	 */
	@Action(value = "queryLikeAction", results = { @Result(name = "success", location = "/catalog/SearchProducts.jsp") })
	public String queryLike() throws UnsupportedEncodingException {
		value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
		productlist = categoryService.queryLike(value, begin * end, end);
		return "success";
	}

	// --------------------------------------------------------
	// 以下为get和set方法，请勿乱动，后果自负

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public List<Item> getItemlist() {
		return itemlist;
	}


	public void setItemlist(List<Item> itemlist) {
		this.itemlist = itemlist;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

}
