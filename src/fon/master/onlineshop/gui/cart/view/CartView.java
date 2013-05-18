package fon.master.onlineshop.gui.cart.view;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import fon.master.onlineshop.domain.Customer;
import fon.master.onlineshop.gui.OnlineShopComponent;
import fon.master.onlineshop.logic.Controller;

public class CartView extends VerticalLayout implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1113936007130592518L;

	
	final OnlineShopComponent onlineShopComponent;
	private CartList cartList;
	
	private Label cartLbl;
	private Label totalAmountLbl;
	private Label totalAmountValueLbl;
//	private TextField totalAmountTxt;

	public CartView(OnlineShopComponent onlineShopComponent) {
		this.onlineShopComponent = onlineShopComponent;
		Customer customer = onlineShopComponent.getLoggedCustomer();
		this.setWidth("100.0%");
		this.setHeight("100.0%");
	
		cartLbl = new Label("Your shopping cart");
		totalAmountLbl = new Label("Total amount: ");
		totalAmountValueLbl = new Label();
		totalAmountValueLbl.setStyleName("totalAmountValueLbl");

		cartList = new CartList(customer);
		
		addComponent(cartLbl);
		addComponent(cartList);
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.addComponent(totalAmountLbl);
		horizontalLayout.addComponent(totalAmountValueLbl);
		addComponent(horizontalLayout);
		
		Controller.getInstance().getCartContainerForCustomer(customer).registerObserver(this);
	}

	public void update(Double totalAmount) {
		totalAmountValueLbl.setValue(totalAmount);
	}


	


	
	
}
