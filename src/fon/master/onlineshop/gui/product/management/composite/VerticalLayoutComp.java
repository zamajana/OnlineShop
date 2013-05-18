package fon.master.onlineshop.gui.product.management.composite;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.VerticalLayout;

public class VerticalLayoutComp extends VerticalLayout implements ProductManagementAPI{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ProductManagementAPI> components = new ArrayList<ProductManagementAPI>();
	
	public void enable() {
		setEnabled(true);
		for (ProductManagementAPI comp : components) {
			comp.enable();
		}
	}

	public void disable() {
		setEnabled(false);
		for (ProductManagementAPI comp : components) {
			comp.disable();
		}
	}

	public void hide() {
		setVisible(false);
		for (ProductManagementAPI comp : components) {
			comp.hide();
		}
	}

	public void show() {
		setVisible(true);
		for (ProductManagementAPI comp : components) {
			comp.show();
		}
	}
	
	public void addChild(ProductManagementAPI productManagementAPI) {
		components.add(productManagementAPI);
	}

	public void removeChild(ProductManagementAPI productManagementAPI) {
		components.remove(productManagementAPI);
	}

	public ProductManagementAPI getChild(int i) {
		return components.get(i);
	}

}
