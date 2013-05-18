package fon.master.onlineshop.data;

import java.io.Serializable;

import com.vaadin.data.util.BeanItemContainer;

import fon.master.onlineshop.domain.Product;

public class ProductContainer extends BeanItemContainer<Product> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	public static final Object[] NATURAL_COL_ORDER = new Object[] {
//		"id", "name", "price", "description",
//		"sizes", "dimensions", "colors", "discount", "image", "rating", "type" };
//	
//	public static final String[] COL_HEADERS_ENGLISH = new String[] {
//		"ID", "Title", "Price", "Description",
//		"Sizes", "Dimensions", "Colors", "Discount", "Image", "Rating", "Type" };
	
	public static final Object[] NATURAL_COL_ORDER = new Object[] {
		"name", "price", "description", "category", "detail", "order" };
	
	public static final String[] COL_HEADERS_ENGLISH = new String[] {
		"Title", "Price", "Description", "Category", "Detail", " " };
	
	public ProductContainer(Class<? super Product> type) throws IllegalArgumentException {
		super(type);
	}

	
}
