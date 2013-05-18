package fon.master.onlineshop.gui.product.management.composite;

import com.vaadin.ui.Component;

public interface ProductManagementAPI extends Component{

	public void addChild(ProductManagementAPI productManagementAPI);
	public void removeChild(ProductManagementAPI productManagementAPI);
	public ProductManagementAPI getChild(int i);
	
	public void enable();
	public void disable();
	public void hide();
	public void show();
}
