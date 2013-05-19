package fon.master.onlineshop.domain;

import java.io.Serializable;

public class CartItem extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer rb;
	private Cart cart;
	private Product product;
	private double sumPrice;
	private int quantity;
	
	public CartItem() {
		super();
	}

	public CartItem(Integer rb, Cart cart, Product product, double sumPrice,
			int quantity) {
		super();
		this.rb = rb;
		this.cart = cart;
		this.product = product;
		this.sumPrice = sumPrice;
		this.quantity = quantity;
	}

	public Integer getRb() {
		return rb;
	}

	public void setRb(Integer rb) {
		this.rb = rb;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return this.rb+" "+this.product.toString()+" * "+this.quantity+" = "+this.sumPrice;
	}

	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
//		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
//		CartItem other = (CartItem) obj;
//		if (cart == null) {
//			if (other.cart != null)
//				return false;
//		} else if (!cart.equals(other.cart))
//			return false;
//		if (product == null) {
//			if (other.product != null)
//				return false;
//		} else if (!product.equals(other.product))
//			return false;
//		return true;
//	}


}
