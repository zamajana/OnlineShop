package fon.master.onlineshop.gui.product.management.composite;

import com.vaadin.ui.Table;

public class TableLeaf extends Table implements ProductManagementAPI{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void enable() {
		setEnabled(true);
	}

	public void disable() {
		setEnabled(false);
	}

	public void hide() {
		setVisible(false);
	}

	public void show() {
		setVisible(true);
	}
	
	public void addChild(ProductManagementAPI productManagementAPI) {
		throw new UnsupportedOperationException();
	}

	public void removeChild(ProductManagementAPI productManagementAPI) {
		throw new UnsupportedOperationException();
	}

	public ProductManagementAPI getChild(int i) {
		throw new UnsupportedOperationException();
	}
}
