package com.clps.jPet.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.clps.jPet.dao.ItemDao;
import com.clps.jPet.domain.Item;
import com.clps.jPet.domain.ItemJson;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage("json-default")
@Namespace("/item")
public class ItemAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ItemDao itemDao;

	private List<Item> items;

	private List<ItemJson> itemsJson;

	/**
	 * link:/item/itemList (return json)
	 */
	@Override
	@Action(value = "itemList", results = @Result(name = "success", type = "json", params = { "root", "itemsJson" }))
	public String execute() throws Exception {
		// TODO /item/itemList

		itemsJson = new ArrayList<ItemJson>();
		items = itemDao.getItemList();

		for (int i = 0; i < items.size(); i++) {
			itemsJson.add(i, new ItemJson(items.get(i).getItemid(), items.get(i).getSupplier().getSuppid(),
					items.get(i).getProduct().getProductid(), items.get(i).getListprice(), items.get(i).getUnitcost(),
					items.get(i).getStatus(), items.get(i).getAttr1(), items.get(i).getAttr2(), items.get(i).getAttr3(),
					items.get(i).getAttr4(), items.get(i).getAttr5()));
		}
		return SUCCESS;
	}

	public List<ItemJson> getItemsJson() {
		return itemsJson;
	}

	public void setItemsJson(List<ItemJson> itemsJson) {
		this.itemsJson = itemsJson;
	}

}
