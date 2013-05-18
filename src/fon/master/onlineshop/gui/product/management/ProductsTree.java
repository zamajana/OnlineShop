package fon.master.onlineshop.gui.product.management;

import com.vaadin.event.Action;
import com.vaadin.ui.Tree;

import fon.master.onlineshop.data.ProductCompositeContainer;
import fon.master.onlineshop.domain.ProductComponent;
import fon.master.onlineshop.gui.ProductManagementComponent;
import fon.master.onlineshop.logic.Controller;

public class ProductsTree extends Tree implements Action.Handler{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Action ADD = new Action("Add");
	private static final Action EDIT = new Action("Edit");
	private static final Action DELETE = new Action("Delete");
    
    private static final Action[] actions = new Action[] { ADD, EDIT, DELETE };
	
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
		if(selectedProduct!=null){
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
		if (action == DELETE) {
            removeItem(target);
        } else {
            // Add
  //          final Object id = addCaptionedItem("New Product", target);
 //           expandItem(target);
 //           setValue(id);
 //           editor.focus();
        }
	}
	

	





	
	
	

}
