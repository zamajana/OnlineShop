package fon.master.onlineshop.gui.cart.view;

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;

import fon.master.onlineshop.data.CartContainer;
import fon.master.onlineshop.domain.CartItem;
import fon.master.onlineshop.domain.Customer;
import fon.master.onlineshop.logic.Controller;

public class CartList extends Table{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7939435233583283932L;
	
	private CartContainer cartContainer;
	
	public CartList(Customer c){
		
		cartContainer = Controller.getInstance().getCartContainerForCustomer(c);

		addGeneratedColumn("quantity", new ColumnGenerator() {
			public Object generateCell(final Table source, final Object itemId, Object columnId) {
				
				final CartItem item = (CartItem) itemId;				
				final TextField quantityTxt = new TextField();
				quantityTxt.setWidth("40px");
				quantityTxt.setStyleName("quantyField");
				quantityTxt.setValue(item.getQuantity());
				quantityTxt.setImmediate(true);
				
				quantityTxt.addListener(new TextChangeListener() {
					public void textChange(TextChangeEvent event) {
						int q = Integer.parseInt(event.getText());
						item.setQuantity(q);
						updateCartItem(item);
					}
				}); 
				
				return quantityTxt;
				}
		});
		
        setContainerDataSource(cartContainer);
        setStyleName("cartList");
        
		this.setWidth("100%");
		this.setHeight("300px");
		
        setVisibleColumns(CartContainer.NATURAL_COL_ORDER);
        setColumnHeaders(CartContainer.COL_HEADERS_ENGLISH);
        setSelectable(true);
        setImmediate(true);
        setNullSelectionAllowed(false);
	}

	private void updateCartItem(CartItem item){
		Controller.getInstance().updateCartItem(item);
	}
	


	
	

	
	
	
}
