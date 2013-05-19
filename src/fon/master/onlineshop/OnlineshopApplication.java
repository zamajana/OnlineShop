package fon.master.onlineshop;

import com.vaadin.Application;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.VerticalSplitPanel;
import com.vaadin.ui.Window;

import fon.master.onlineshop.gui.OnlineShopComponent;
import fon.master.onlineshop.gui.ProductManagementComponent;

public class OnlineshopApplication extends Application {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final AbsoluteLayout layout = new AbsoluteLayout();
	private final AbsoluteLayout contentLayout = new AbsoluteLayout();
//	private final VerticalSplitPanel appLayout = new VerticalSplitPanel();
	private final ProductManagementComponent productManagementComponent = new ProductManagementComponent();
	private final OnlineShopComponent onlineShopComponent = new OnlineShopComponent(this);
	
	private MenuBar dashboardMenu;
	
	@Override
	public void init() {
		Window mainWindow = new Window("Online Shop Application", layout);
		setMainWindow(mainWindow);
		layout.setHeight("100%");
		layout.setWidth("100%");
	//	layout.addComponent(appLayout);
	//	layout.addComponent(new OnlineShopComponent(this));
//		layout.addComponent(new TreeExample());
		
		dashboardMenu = buildDashboardMenu();
		dashboardMenu.setImmediate(true);
		layout.addComponent(dashboardMenu);
		layout.addComponent(contentLayout, "top:20px;");
		contentLayout.addComponent(productManagementComponent);
	}
	
	private MenuBar buildDashboardMenu(){
		dashboardMenu = new MenuBar();
		dashboardMenu.setStyleName("dashboardMenu");
		dashboardMenu.setWidth("100%");
		dashboardMenu.setHeight("20px");
		
		Command productManagementCmd = new Command() {
			public void menuSelected(MenuItem selectedItem) {
				contentLayout.removeAllComponents();
				contentLayout.addComponent(productManagementComponent);
			}
		};
		
		Command categoryManagementCmd = new Command() {
			public void menuSelected(MenuItem selectedItem) {
				
			}
		};
		
		Command shopPreviewCmd = new Command() {
			public void menuSelected(MenuItem selectedItem) {
				contentLayout.removeAllComponents();
				contentLayout.addComponent(onlineShopComponent);
			}
		};
		
		dashboardMenu.addItem("PRODUCT MANAGEMENT", productManagementCmd);
		dashboardMenu.addItem("CATEGORY MANAGEMENT", categoryManagementCmd);
		dashboardMenu.addItem("PREVIEW", shopPreviewCmd);
		
		return dashboardMenu;
	}

	
	
	
	


}
