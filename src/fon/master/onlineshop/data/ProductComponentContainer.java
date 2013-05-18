package fon.master.onlineshop.data;

import com.vaadin.data.util.BeanItemContainer;

import fon.master.onlineshop.domain.ProductComponent;

public class ProductComponentContainer extends BeanItemContainer<ProductComponent>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public static final Object[] NATURAL_COL_ORDER = new Object[] {
		"name", "price", "description", "category", "edit"};
	
	public static final String[] COL_HEADERS_ENGLISH = new String[] {
		"Title", "Price", "Description", "Category", " "};
	
	public ProductComponentContainer(Class<? super ProductComponent> type)
			throws IllegalArgumentException {
		super(type);
	}
	

}
