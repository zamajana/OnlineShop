package fon.master.onlineshop.domain;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import fon.master.onlineshop.logic.CompositeIterator;


public abstract class ProductComponent extends BaseEntity implements Serializable{

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
	
	protected ProductComponent(){
		super();
	}

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
	
	public List<ProductComponent> getChildren(){
		return null;
	}
	
	@Override
	public String toString() {
		throw new UnsupportedOperationException();
	}
	
	public void print(){
		throw new UnsupportedOperationException();
	}

	public int getId() {
		throw new UnsupportedOperationException();
	}

	public void setId(int id) {
		throw new UnsupportedOperationException();
	}

	public String getName() {
		throw new UnsupportedOperationException();
	}

	public void setName(String name) {
		throw new UnsupportedOperationException();
	}

	public double getPrice() {
		throw new UnsupportedOperationException();
	}

	public void setPrice(double price) {
		throw new UnsupportedOperationException();
	}

	public String getDescription() {
		throw new UnsupportedOperationException();
	}

	public void setDescription(String description) {
		throw new UnsupportedOperationException();
	}

	public Category getCategory() {
		throw new UnsupportedOperationException();
	}

	public void setCategory(Category category) {
		throw new UnsupportedOperationException();
	}

	public ProductComponent getParent() {
		throw new UnsupportedOperationException();
	}

	public void setParent(ProductComponent productComponent){
		throw new UnsupportedOperationException();
	}

	public Iterator<ProductComponent> createIterator() {
		throw new UnsupportedOperationException();
	}
	
	
}
