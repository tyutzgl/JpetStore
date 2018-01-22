package com.clps.jPet.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.clps.jPet.pojo.Cart;
import com.clps.jPet.pojo.Category;
import com.clps.jPet.pojo.Item;
import com.clps.jPet.pojo.Product;
import com.clps.jPet.pojo.Profile;
import com.clps.jPet.pojo.Signon;
import com.clps.jPet.service.CategoryService;
import com.clps.jPet.service.ShoppingService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 购物车类，查询购物车、添加购物车、更新购物车、从购物车移除
 * 
 * @author zhangguoliang
 *
 */
@Controller
@ParentPackage("json-default")
public class ShoppingAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ShoppingService shoppingService;
	@Autowired
	private CategoryService categoryService;

	private Category category = new Category();
	// 商品种类
	private Product product;
	// 商品
	private Item item;
	// 商品数量
	private Long qty;
	// 用户的登录信息
	private Signon signon;
	// 订单类
	private Cart cart;
	// 分页查询初始参数
	private int begin = 0;
	private int end = 10;
	private List<Cart> listcart;
	private List<Item> itemlist;
	private Map<String, Integer> cartMap;
	private Map<String, Item> itemMap;
	private List<Product> productlist;
	// 商品总价格
	private Double sumPrice;
	// 用户的喜好类
	private Profile profile;

	/**
	 * 根据用户id（name）查询购物车
	 * 
	 * @input:sigon.username
	 * @output:listcart
	 * @return /cart/Cart.jsp
	 */
	@Action(value = "queryShoppingAction", results = { @Result(name = "success", location = "/cart/Cart.jsp") })
	public String queryShopping() {
		// 广告植入部分
		category = new Category();
		category.setCatid("CATS");
		productlist = categoryService.query(category, 0, 10);

		// 查询用户喜欢的语言和动物类别
		profile = categoryService.queryProfile(signon.getUsername());

		// 查询用户的购物车内容
		listcart = shoppingService.queryShopping(signon.getUsername(), begin * end, end);
		return "success";
	}

	/**
	 * 将商品加入购物车，如果已经存在则修改购物车
	 * 
	 * @input item.itemid,signon.username
	 * @output listcart
	 * @return /cart/Cart.jsp
	 */
	@SuppressWarnings("unchecked")
	@Action(value = "saveShoppingAction", results = { @Result(name = "success", location = "/cart/Cart.jsp"),
			@Result(name = "error", location = "/account/SignonForm.jsp") })
	public String saveShopping() {

		// 判断用户session信息是否存在，不存在返回登录
		if (signon.getUsername().equals("null")) {
			return "error";
		} else {
			// 根据商品id查询商品数量
			qty = categoryService.queryInventory(item.getItemid());

			// 根据商品id查询商品详细信息
			item = categoryService.queryItemTwo(item.getItemid());

			// 查询用户购物车中是否存在改商品，如果存在则cart执行修改操作，不存在执行添加操作
			if (shoppingService.queryCountShopping(item.getItemid(), signon.getUsername()) > 0) {
				cart = shoppingService.queryOneShopping(signon.getUsername(), item.getItemid());
				shoppingService.updateQuantity((int) cart.getQuantity() + 1, item.getItemid(), signon.getUsername());
			} else {
				// 将商品保存到购物车中
				cart = new Cart();
				int id = (int) (Math.random() * 1000 + 1);
				cart.setId((long) id);
				cart.setItem(item);
				cart.setSignon(signon);
				cart.setQuantity(1);
				shoppingService.saveShopping(cart);
			}
			listcart = shoppingService.queryShopping(signon.getUsername(), begin * end, end);
		}
		return "success";
	}

	/**
	 * 从购物车删除
	 * 
	 * @input item.itemid,signon.username
	 * @output listcart
	 * @return /cart/Cart.jsp
	 */
	@Action(value = "deleteShoppingAction", results = { @Result(name = "success", location = "/cart/Cart.jsp") })
	public String deleteShopping() {
		// 防止购物车中出现莫名其妙的数据
		if ("0".equals(signon.getUsername())) {
			@SuppressWarnings("unchecked")
			Map<String, Item> itemMap = (Map<String, Item>) ActionContext.getContext().getSession().get("itemMap");
			itemMap.remove(item.getItemid());
			ActionContext.getContext().getSession().put("itemMap", itemMap);
			return "success";
		} else {
			// 执行删除操作
			int result = shoppingService.deleteShopping(item.getItemid(), signon.getUsername());
			// 返回购物车列表内容
			listcart = shoppingService.queryShopping(signon.getUsername(), begin * end, end);
			if (result > 0) {
				return "success";
			} else {
				return "error";
			}
		}
	}

	/**
	 * 查询订单明细
	 * @return /cart/Checkout.jsp
	 */
	@Action(value = "queryShoppingTwoAction", results = { @Result(name = "success", location = "/cart/Checkout.jsp") })
	public String queryShoppingTwo() {
		category = new Category();
		category.setCatid("CATS");
		productlist = categoryService.query(category, 0, 10);
		profile = categoryService.queryProfile(signon.getUsername());
		listcart = shoppingService.queryShopping(signon.getUsername(), begin * end, end);
		return "success";
	}

	// --------------------------------------------------------------------------------
	// 以下部分为get和set方法，请勿乱改动，不然有你吃的
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}

	@JSON(serialize = false)
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@JSON(serialize = false)
	public List<Item> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<Item> itemlist) {
		this.itemlist = itemlist;
	}

	@JSON(serialize = false)
	public List<Cart> getListcart() {
		return listcart;
	}

	public void setListcart(List<Cart> listcart) {
		this.listcart = listcart;
	}

	@JSON(serialize = false)
	public Map<String, Integer> getCartMap() {
		return cartMap;
	}

	public void setCartMap(Map<String, Integer> cartMap) {
		this.cartMap = cartMap;
	}

	@JSON(serialize = false)
	public Map<String, Item> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<String, Item> itemMap) {
		this.itemMap = itemMap;
	}

	public Double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
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

	public List<Product> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}
