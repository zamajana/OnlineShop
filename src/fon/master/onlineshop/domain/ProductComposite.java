package fon.master.onlineshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fon.master.onlineshop.logic.CompositeIterator;


public class ProductComposite extends ProductComponent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ProductComponent> products;
	
	public ProductComposite(int id, String name,
			String description, Category category) {
		setId(id);
		setName(name);
		setDescription(description);
		setCategory(category);
		this.products = new ArrayList<ProductComponent>();
	}

	@Override
	public void addChildProduct(ProductComponent productComponent) {
		productComponent.setParent(this);
		products.add(productComponent);
	}
	
	@Override
	public void removeChildProduct(ProductComponent productComponent) {
		products.remove(productComponent);
	}
	
	@Override
	public ProductComponent getChildProduct(int id) {
		return products.get(id);
	}
	
	@Override
	public ProductComponent change(String name, double price, String description,
			Category category) {
		this.name = name;
		this.description = description;
		this.category = category;
		return this;
	}
	
	@Override
	public void print() {
		System.out.println("-----------------------------------------------");
		System.out.println(" ------ "+getName()+", price:"+getPrice() +" ------");
		System.out.println("     ------ " +getDescription());
		System.out.println("-----------------------------------------------");
		Iterator<ProductComponent> iterator = products.iterator();
		while(iterator.hasNext()){
			ProductComponent productComponent = iterator.next();
			productComponent.print();
		}
	}
	
	@Override
	public List<ProductComponent> getChildren() {
		return products;
	}
	
	@Override
	public Iterator<ProductComponent> createIterator() {
		return new CompositeIterator(products.iterator());
	}
	
	@Override
	public double getPrice() {
		if(!products.isEmpty()){
			this.price = 0.0;
			for (ProductComponent productComponent : products) {
				this.price += productComponent.getPrice();
			}
		}
		return this.price;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ProductComponent getParent() {
		return parent;
	}

	public void setParent(ProductComponent productComponent){
		this.parent = productComponent;
	}

	
}
