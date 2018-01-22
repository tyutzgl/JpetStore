  package com.clps.jPet.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import com.clps.jPet.dao.ItemDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.clps.jPet.pojo.Item;

  @Repository
  public class ItemDaoImpl implements ItemDao{

  //	@Autowired
  //	private HibernateTemplate hibernateTemplate;

      @Autowired
      private SessionFactory sessionFactory;

      public List<Item> getItems() {
          Session session = sessionFactory.openSession();
          String hql = "FROM Item";
          Query query = session.createQuery(hql);
          List<Item> items = query.list();
          System.out.println(items.get(1).getItemid());
          session.close();
          // List<Item> items = (List<Item>) hibernateTemplate.find("from item");
          return items;
      }

      public List<Item> getItemList() {
          Session session = sessionFactory.openSession();
          String hql = "FROM Item";
          Query query = session.createQuery(hql);
          List<Item> items = query.list();
          System.out.println(items.get(1).getItemid());
          session.close();
          // List<Item> items = (List<Item>) hibernateTemplate.find("from item");
          return items;
      }
  }
