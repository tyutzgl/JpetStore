package com.clps.jPet.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.clps.jPet.pojo.Account;
import com.clps.jPet.pojo.Cart;
import com.clps.jPet.pojo.Inventory;
import com.clps.jPet.pojo.Lineitem;
import com.clps.jPet.pojo.LineitemId;
import com.clps.jPet.pojo.Orders;
import com.clps.jPet.pojo.Orderstatus;
import com.clps.jPet.pojo.OrderstatusId;
import com.clps.jPet.pojo.Signon;
import com.clps.jPet.service.OrderService;
import com.clps.jPet.service.ShoppingService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 订单查询
 *
 * @author zhangguoliang
 */
@Controller
@ParentPackage("json-default")
public class OrderAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private Account account;
    private Signon signon;
    private Orders orders;
    private Lineitem lineitem;
    private Orderstatus orserstatus;
    private LineitemId lineitemId;
    private OrderstatusId orderstatusId;
    private List<Cart> cartlist;
    private List<Orders> orderslist;
    private int begin = 0;
    private int end = 4;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShoppingService shoppingService;

    /**
     * 查询历史订单、已完成订单
     *
     * @return /order/ListOrders.jsp
     * @input signon.username, begin, end
     * @output orderslist
     */
    @Action(value = "historyOrdersAction", results = {@Result(name = "success", location = "/order/ListOrders.jsp")})
    public String historyOrders() {
        orderslist = orderService.queryOrder(signon.getUsername(), begin * end, end);
        return "success";
    }

    /**
     * 填写支付信息界面
     *
     * @return /order/NewOrderForm.jsp
     * @input signon.username
     * @output account
     */
    @Action(value = "queryAccountAction", results = {@Result(name = "success", location = "/order/NewOrderForm.jsp")})
    public String queryAccount() {
        account = orderService.queryAccount(signon.getUsername());
        return "success";
    }


    /**
     * 信息确认界面
     *
     * @return /order/ConfirmOrder.jsp
     */
    @Action(value = "queryAccountTwoAction", results = {
            @Result(name = "success", location = "/order/ConfirmOrder.jsp")})
    public String queryAccountTwo() {
        account = orderService.queryAccount(signon.getUsername());
        return "success";
    }

    /**
     * 向数据库中保存订单 输入signon.username
     * 输出：cartlist
     *
     * @return /order/ViewOrder.jsp
     */
    @Action(value = "saveOrderAction", results = {@Result(name = "success", location = "/order/ViewOrder.jsp")})
    public String saveOrder() {
        account.setUserid(signon.getUsername());
        orders.setUserid(signon.getUsername());
        int id = (int) (Math.random() * 9999 + 1);
        orders.setOrderid(id);
        orders.setOrderdate(new Date());

        cartlist = shoppingService.queryShopping(signon.getUsername(), begin * end, end);
        double sum = 0;

        for (Cart cart2 : cartlist) {
            double price = cart2.getItem().getListprice();
            long count = cart2.getQuantity();
            sum = sum + price * count;
        }

        orders.setTotalprice(sum);
        orderService.saveOrders(orders);

        lineitem = new Lineitem();
        lineitemId = new LineitemId();
        int linenum = 0;
        for (Cart cart : cartlist) {
            lineitemId.setOrderid(orders.getOrderid());
            lineitemId.setLinenum(++linenum);
            lineitem.setId(lineitemId);
            lineitem.setItemid(cart.getItem().getItemid());
            lineitem.setQuantity(cart.getQuantity());
            lineitem.setUnitprice(cart.getItem().getListprice());
            orderService.saveLineitem(lineitem);
        }

        orserstatus = new Orderstatus();
        orderstatusId = new OrderstatusId();
        orderstatusId.setOrderid(orders.getOrderid());
        orderstatusId.setLinenum(1);
        orserstatus.setId(orderstatusId);
        orserstatus.setTimestamp(orders.getOrderdate());
        orserstatus.setStatus("p");
        orderService.saveOrderstatus(orserstatus);

        List<Inventory> inventorylist = orderService.queryInventory();
        for (Cart cart3 : cartlist) {
            for (Inventory i : inventorylist) {
                if (i.getItemid().equals(cart3.getItem().getItemid())) {
                    i.setQty(i.getQty() - cart3.getQuantity());
                    orderService.updateInventory(i);
                }
            }
        }
        return "success";
    }

    /**
     * 浏览订单信息
     *
     * @return /order/ViewOrder.jsp
     */
    @Action(value = "saveOrderTwoAction", results = {@Result(name = "success", location = "/order/ViewOrder.jsp")})
    public String queryOrders() {
        account = orderService.queryAccount(signon.getUsername());
        cartlist = shoppingService.queryShopping(signon.getUsername(), begin * end, end);
        orders = orderService.queryOrdersOne(orders.getOrderid());
        return "success";
    }


    // -------------------------------------------------------
    // 一下为get和set方法
    public Signon getSignon() {
        return signon;
    }

    public void setSignon(Signon signon) {
        this.signon = signon;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Lineitem getLineitem() {
        return lineitem;
    }

    public void setLineitem(Lineitem lineitem) {
        this.lineitem = lineitem;
    }

    public Orderstatus getOrserstatus() {
        return orserstatus;
    }

    public void setOrserstatus(Orderstatus orserstatus) {
        this.orserstatus = orserstatus;
    }

    public LineitemId getLineitemId() {
        return lineitemId;
    }

    public void setLineitemId(LineitemId lineitemId) {
        this.lineitemId = lineitemId;
    }

    public OrderstatusId getOrderstatusId() {
        return orderstatusId;
    }

    public void setOrderstatusId(OrderstatusId orderstatusId) {
        this.orderstatusId = orderstatusId;
    }

    public List<Cart> getCartlist() {
        return cartlist;
    }

    public void setCartlist(List<Cart> cartlist) {
        this.cartlist = cartlist;
    }

    public List<Orders> getOrderslist() {
        return orderslist;
    }

    public void setOrderslist(List<Orders> orderslist) {
        this.orderslist = orderslist;
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

}
