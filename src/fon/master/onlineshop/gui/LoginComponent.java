package fon.master.onlineshop.gui;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import fon.master.onlineshop.data.Data;
import fon.master.onlineshop.domain.Cart;
import fon.master.onlineshop.domain.CartItem;
import fon.master.onlineshop.domain.Customer;
import fon.master.onlineshop.logic.Controller;

public class LoginComponent extends CustomComponent implements Button.ClickListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -237289587262529407L;
	
	final OnlineShopComponent onlineShopComponent;
	
	private VerticalLayout loginLayout;
	private Label passwordLbl;
	private Label usernameLbl;
	private PasswordField passwordFld;
	private TextField usernameTxt;
	private Button loginBtn;
	private Button logoutBtn;
	
	private Label loginSatusLbl;
	
	public LoginComponent(OnlineShopComponent onlineShopComponent) {	
		loginLayout = new VerticalLayout();
		setCompositionRoot(loginLayout);
		this.onlineShopComponent = onlineShopComponent;
		buildLogInLayout();
	}
	
	private VerticalLayout buildLogInLayout(){
		
		HorizontalLayout loginFormLayout = new HorizontalLayout();
		
		loginLayout.setImmediate(false);
		loginLayout.setWidth("350px");
		loginLayout.setHeight("60px");
		loginLayout.setMargin(false);
		
		VerticalLayout firstColumn = new VerticalLayout();
		VerticalLayout secondColumn = new VerticalLayout();
		VerticalLayout thirdColumn = new VerticalLayout();
		
		
		// usernameLbl
		usernameLbl = new Label();
		usernameLbl.setStyleName("usernameLbl");
		usernameLbl.setImmediate(false);
		usernameLbl.setWidth("80px");
		usernameLbl.setHeight("-1px");
		usernameLbl.setValue("Username");
		firstColumn.addComponent(usernameLbl);
		
		// usernameTxt
		usernameTxt = new TextField();
		usernameTxt.setStyleName("usernameTxt");
		usernameTxt.setImmediate(true);
		usernameTxt.setWidth("-1px");
		usernameTxt.setHeight("-1px");
		usernameTxt.setValue("");
		firstColumn.addComponent(usernameTxt);
		
		// passwordLbl
		passwordLbl = new Label();
		passwordLbl.setStyleName("passwordLbl");
		passwordLbl.setImmediate(false);
		passwordLbl.setWidth("-1px");
		passwordLbl.setHeight("-1px");
		passwordLbl.setValue("Password");
		secondColumn.addComponent(passwordLbl);
		
		// passwordFld
		passwordFld = new PasswordField();
		passwordFld.setStyleName("passwordFld");
		passwordFld.setImmediate(true);
		passwordFld.setWidth("-1px");
		passwordFld.setHeight("-1px");
		passwordFld.setValue("");
		secondColumn.addComponent(passwordFld);	
		
		loginBtn = new Button("Log in");
		loginBtn.setStyleName("loginBtn");
		loginBtn.addListener((Button.ClickListener)this);
		thirdColumn.addComponent(loginBtn);		
		
		logoutBtn = new Button("Log out");
		logoutBtn.setStyleName("logoutBtn");
		logoutBtn.addListener((Button.ClickListener)this);
		logoutBtn.setVisible(false);
		thirdColumn.addComponent(logoutBtn);
		
		loginSatusLbl = new Label();
		loginSatusLbl.setStyleName("loginStatusLbl");
		loginSatusLbl.setImmediate(false);
		loginSatusLbl.setWidth("-1px");
		loginSatusLbl.setHeight("-1px");

		loginFormLayout.addComponent(firstColumn);
		loginFormLayout.addComponent(secondColumn);
		loginFormLayout.addComponent(thirdColumn);
		
		loginLayout.addComponent(loginFormLayout);
		loginLayout.addComponent(loginSatusLbl);
		
		return loginLayout;
	}

	public void buttonClick(ClickEvent event) {
		final Button source = event.getButton();
		if(source == loginBtn){
			String status = logIn(usernameTxt.getValue().toString(), passwordFld.getValue().toString());	
			if(onlineShopComponent.isCustomerLoggedIn()){
				customerLoggedIn(status);
			}	
		}else if(source == logoutBtn){
			logOut();
			customerLoggedOut();
		}
	}
	
	public String logIn(String username, String password) {
		List<Customer> customers = Data.getInstance().getCustomerList();
		for (Customer c : customers) {
			if (username.equalsIgnoreCase(c.getUsername())
					&& password.equalsIgnoreCase(c.getPassword())) {
				Cart cart = makeCart(c);
				c.getCarts().add(cart);			
				Controller.getInstance().logInCustomer(c);
				onlineShopComponent.loginCustomer(c, cart);
				
				return "You are logged in as "
						+ c.getFirstName() + " "
						+ c.getLastName();
			}
		}
		OnlineShopNotification.showNotification("Wrong username or password!", getWindow());
		return null;
	}
	
	private Cart makeCart(Customer c) {
		Cart cart;
		if (c.getCarts() == null) {
			List<Cart> carts = new ArrayList<Cart>();
			List<CartItem> items = new ArrayList<CartItem>();
			c.setCarts(carts);
			cart = new Cart(1, 0.0, c, items);
		} else if (c.getCarts().size() == 0 || c.getCarts().isEmpty()) {
			List<CartItem> items = new ArrayList<CartItem>();
			cart = new Cart(1, 0.0, c, items);
		} else {
			List<CartItem> items = new ArrayList<CartItem>();
			cart = new Cart(c.getCarts().size(), 0.0, c, items);
		}
		return cart;
	}
	
	public void logOut() {	
		Controller.getInstance().logOutCart(onlineShopComponent.getLoggedCustomer());
		onlineShopComponent.logoutCustomer(); 
	}
	
	private void customerLoggedOut(){
		usernameLbl.setVisible(true);
		usernameTxt.setVisible(true);
		usernameTxt.setValue("");
		passwordLbl.setVisible(true);
		passwordFld.setVisible(true);
		passwordFld.setValue("");
		loginBtn.setVisible(true);
		logoutBtn.setVisible(false);
		loginSatusLbl.setValue("");
	}
	
	private void customerLoggedIn(String status){
		usernameLbl.setVisible(false);
		usernameTxt.setVisible(false);
		passwordLbl.setVisible(false);
		passwordFld.setVisible(false);
		loginBtn.setVisible(false);
		logoutBtn.setVisible(true);
		loginSatusLbl.setValue(status);
	}
	

		
	
}
