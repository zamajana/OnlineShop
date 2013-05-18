package fon.master.onlineshop.domain;

import java.io.Serializable;
import java.util.List;


public abstract class ProductComponent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int id;
	protected String name;
	protected double price;
	protected String description;
	protected Category category;
	
	protected ProductComponent parent;

	public void addChildProduct(ProductComponent productComponent){
		throw new UnsupportedOperationException();
	}
	
	public void removeChildProduct(ProductComponent productComponent){
		throw new UnsupportedOperationException();
	}
	
	public ProductComponent change(String name, double price, String description, Category category){
		throw new UnsupportedOperationException();
	}
	
	public ProductComponent getChildProduct(int id){
		throw new UnsupportedOperationException();
	}
	
	public int getId() {
		throw new UnsupportedOperationException();
	}
	
	public String getName(){
		throw new UnsupportedOperationException();
	}
	
	public double getPrice() {
		throw new UnsupportedOperationException();
	}
	
	public String getDescription() {
		throw new UnsupportedOperationException();
	}
	
	public Category getCategory() {
		throw new UnsupportedOperationException();
	}
	
	public List<ProductComponent> getChildren(){
		return null;
	}
	
	public ProductComponent getParent(){
		return null;
	}
	
	public void setParent(ProductComponent productComponent){
		this.parent = productComponent;
	}
	
	@Override
	public String toString() {
		throw new UnsupportedOperationException();
	}
	
	public void print(){
		throw new UnsupportedOperationException();
	}
}
