package fon.master.onlineshop.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.util.BeanItemContainer;

import fon.master.onlineshop.domain.CartItem;
import fon.master.onlineshop.domain.Customer;
import fon.master.onlineshop.gui.cart.view.Observer;

public class CartContainer extends BeanItemContainer<CartItem> implements Serializable, Subject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8567625559131532875L;
	private List<Observer> observers = new ArrayList<Observer>();
	
	private Double totalAmount;
	private Customer customer;
	
	public static final Object[] NATURAL_COL_ORDER = new Object[] {
		"rb", "product", "quantity", "sumPrice" };
	
	public static final String[] COL_HEADERS_ENGLISH = new String[] {
		" ", "Product", "Quantity", "SUM" };
	
	public CartContainer(Class<? super CartItem> type, Customer customer)
			throws IllegalArgumentException {
		super(type);
		this.customer = customer;
		this.totalAmount = 0.00;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
		notifyObservers();
	}

	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	public void notifyObservers() {
		for (Observer ob : observers) {
            ob.update(this.totalAmount);
		}
	}

	
	


}
