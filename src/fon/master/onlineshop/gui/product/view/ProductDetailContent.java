package fon.master.onlineshop.gui.product.view;

import com.vaadin.ui.Component;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import fon.master.onlineshop.domain.Product;

public class ProductDetailContent implements PopupView.Content{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final VerticalLayout detailLayout = new VerticalLayout();
	private final String linkText = "Show Detail";
	
	private TextField titleTxt;
	private TextField descriptionTxt;
	private TextField priceTxt;

	public ProductDetailContent(Product product) {
		this.titleTxt = new TextField("Title", product.getName());
		this.descriptionTxt = new TextField("Decription", product.getDescription());
		this.priceTxt = new TextField("Price", String.valueOf(product.getPrice()));
	}
	
	public String getMinimizedValueAsHTML() {
		return linkText;
	}

	public Component getPopupComponent() {	
		detailLayout.setHeight("300px");
		detailLayout.setWidth("300px");
		detailLayout.addComponent(titleTxt);
		detailLayout.addComponent(descriptionTxt);
		detailLayout.addComponent(priceTxt);
		return detailLayout;
	}



	

}
