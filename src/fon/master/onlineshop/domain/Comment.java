package fon.master.onlineshop.domain;

import java.io.Serializable;

public class Comment extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Customer customer;
	private Product product;
	private String title;
	private String comment;
	
	public Comment() {
		super();
	}

	public Comment(int id, Customer customer, Product product, String title,
			String comment) {
		super();
		this.id = id;
		this.customer = customer;
		this.product = product;
		this.title = title;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return this.customer.toString()+"\n"+this.title+"\n"+this.comment;
	}
	
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
//		result = prime * result + ((product == null) ? 0 : product.hashCode());
//		result = prime * result + ((title == null) ? 0 : title.hashCode());
//		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
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
//		Comment other = (Comment) obj;
//		if (customer == null) {
//			if (other.customer != null)
//				return false;
//		} else if (!customer.equals(other.customer))
//			return false;
//		if (product == null) {
//			if (other.product != null)
//				return false;
//		} else if (!product.equals(other.product))
//			return false;
//		if (title == null) {
//			if (other.title != null)
//				return false;
//		} else if (!title.equals(other.title))
//			return false;
//		if (comment == null) {
//			if (other.comment != null)
//				return false;
//		} else if (!comment.equals(other.comment))
//			return false;
//		return true;
//	}
}
