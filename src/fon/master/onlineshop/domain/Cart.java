package fon.master.onlineshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private double totalPrice;
	private Customer customer;
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	
	public Cart() {
		super();
	}

	public Cart(int id, double totalPrice, Customer customer,
			List<CartItem> cartItems) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.customer = customer;
		this.cartItems = cartItems;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	@Override
	public String toString() {
		return String.valueOf(id);
	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!super.equals(obj))
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Cart other = (Cart) obj;
//		if (customer == null) {
//			if (other.customer != null)
//				return false;
//		} else if (!customer.equals(other.customer))
//			return false;
//		return true;
//	}
	
	
}
