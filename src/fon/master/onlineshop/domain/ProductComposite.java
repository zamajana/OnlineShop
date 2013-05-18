package fon.master.onlineshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ProductComposite extends ProductComponent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ProductComponent> products;
	
	public ProductComposite(int id, String name,
			String description, Category category) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
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
	public int getId() {
		return this.id;
	}
	
	@Override
	public String getName() {
		return this.name;
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
	public String getDescription() {
		return this.description;
	}
	
	@Override
	public Category getCategory() {
		return this.category;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	@Override
	public List<ProductComponent> getChildren() {
		return products;
	}

	@Override
	public ProductComponent getParent() {
		return this.parent;
	}
	
}
