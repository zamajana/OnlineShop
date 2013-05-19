package fon.master.onlineshop.gui.product.management;

import org.apache.commons.digester.xmlrules.FromXmlRuleSet;

import com.vaadin.event.Action;
import com.vaadin.ui.Tree;

import fon.master.onlineshop.data.ProductCompositeContainer;
import fon.master.onlineshop.domain.ProductComponent;
import fon.master.onlineshop.domain.ProductComposite;
import fon.master.onlineshop.gui.ProductManagementComponent;
import fon.master.onlineshop.gui.ProductManagementComponent.Mode;
import fon.master.onlineshop.logic.Controller;

public class ProductsTree extends Tree implements Action.Handler{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Action ADD_PRODUCT = new Action("Add Product");
	private static final Action ADD_COMPOSITE_PRODUCT = new Action("Add Complex Product");
	private static final Action EDIT_PRODUCT = new Action("Edit Product");
//	private static final Action DELETE = new Action("Delete");
    
    private static final Action[] actions = new Action[] { ADD_PRODUCT, ADD_COMPOSITE_PRODUCT, EDIT_PRODUCT };
	
	private ProductManagementComponent productManagementComponent;
	private ProductCompositeContainer productCompositeContainer;	
	private ProductComponent selectedProduct = null;
		
	public ProductsTree(ProductManagementComponent productManagementComponent){
			
		this.productManagementComponent = productManagementComponent;
		productCompositeContainer = Controller.getInstance().getProductCompositeContainer();
		setContainerDataSource(productCompositeContainer);
		
		setImmediate(true);
		setSelectable(true);
		setNullSelectionAllowed(false);
		setMultiSelect(false);
		setReadOnly(false);
		
		for (Object rootItemId: productCompositeContainer.rootItemIds()){
            expandItemsRecursively(rootItemId);
		}
		
		addActionHandler(this);
		
		addListener(new ValueChangeListener() {	
			public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
				if(getValue()!=null){
				selectedProduct = (ProductComponent) getValue();
				productSelected();
				}
			}
		});
	
	}
	
	private void productSelected(){
		if(isProductSelected()){
			productManagementComponent.productSelected(selectedProduct);
		}
	}
	
	public boolean isProductSelected(){
		if(selectedProduct!=null){
			return true;
		}
		return false;
	}

	public ProductComponent getSelectedProduct() {
		return selectedProduct;
	}


	public Action[] getActions(Object target, Object sender) {
		return actions;
	}

	public void handleAction(Action action, Object sender, Object target) {
		if(action == EDIT_PRODUCT){
			if(isProductSelected()){
				productSelected();
				if(getSelectedProduct() instanceof ProductComposite){
					productManagementComponent.prepareProductForm(Mode.EDIT_COMPOSITE_PRODUCT);
				}else{
					productManagementComponent.prepareProductForm(Mode.EDIT_PRODUCT);
				}
			}
		}else if(action == ADD_COMPOSITE_PRODUCT){
			productManagementComponent.prepareProductForm(Mode.ADD_COMPOSITE_PRODUCT);
		}
		else if(action == ADD_PRODUCT){
			productManagementComponent.prepareProductForm(Mode.ADD_PRODUCT);
		}
	}
	

	





	
	
	

}
