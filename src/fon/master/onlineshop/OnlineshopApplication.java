package fon.master.onlineshop;

import com.vaadin.Application;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Window;

import fon.master.onlineshop.gui.ProductManagementComponent;

public class OnlineshopApplication extends Application {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final AbsoluteLayout layout = new AbsoluteLayout();
	
	@Override
	public void init() {
		Window mainWindow = new Window("Online Shop Application", layout);
		setMainWindow(mainWindow);
		layout.setHeight("100%");
		layout.setWidth("100%");
	//	layout.addComponent(new OnlineShopComponent(this));
		layout.addComponent(new ProductManagementComponent());
	//	layout.addComponent(new TreeExample());
		
		
	}

	
	
	
	


}
