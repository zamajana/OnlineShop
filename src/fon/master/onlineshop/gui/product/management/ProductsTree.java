package fon.master.onlineshop.gui.product.management;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.event.Action;
import com.vaadin.ui.AbstractSelect;
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
    private static final Object CAPTION_PROPERTY = "name";
	
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
        
       // addContainerProperty(CAPTION_PROPERTY, ProductComponent.class, "");
        setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_PROPERTY);
        setItemCaptionPropertyId(CAPTION_PROPERTY);
		
		for (Object rootItemId: productCompositeContainer.rootItemIds()){
            expandItemsRecursively(rootItemId);
		}
		
		addListener((ValueChangeListener) productManagementComponent);
		addActionHandler(this);
		
//		addListener(new ValueChangeListener() {	
//			public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
//				selectedProduct = (ProductComponent) event.getProperty().getValue();
//				productSelected();
//			}
//		});
	
	}
	
	private void productSelected(){
		productManagementComponent.productSelected(selectedProduct);
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
	
	public void valueChange(ValueChangeEvent event) {
 //       final Object id = getValue(); // selected item id
   //     if (event.getProperty() == this) {
            // a Tree item was (un) selected
//            if (id == null) {
  //          	System.out.println("######### ID is NULL");
 //               // no selecteion, disable TextField
//            	  editor.removeListener((ValueChangeListener)this);
//            	  editor.setValue("");
//            	  editor.setEnabled(false);
         //   	productManagementComponent.removeTreeListenerFromForm(this);
 //           } else {
 //           	System.out.println("######### ID is NOT NULL");
                // item selected
                // first remove previous listener
               // editor.removeListener(this);
         //   	productManagementComponent.removeTreeListenerFromForm(this);
           // 	selectedProduct = (ProductComponent) getItem(id).getItemProperty(CAPTION_PROPERTY).getValue();
 //           	selectedProduct = (ProductComponent) event.getProperty().getValue();
//				productSelected();
            //	productManagementComponent.productSelected(selectedProduct);
            //	productManagementComponent.addTreeListenerToForm(this);
 //           	productManagementComponent.prepareProductForm(Mode.EDIT_PRODUCT);
                // enable TextField and update value
             //   editor.setEnabled(true);
       //         final Item item = tree.getItem(id);
       //         editor.setValue(item.getItemProperty(CAPTION_PROPERTY)
        //                .getValue());
                // listen for TextField changes
        //        editor.addListener(this);
        //        editor.focus();
 //           }
//        } else {
            // TextField
   //         if (id != null) {
   //             final Item item = getItem(id);
               // final Property p = item.getItemProperty(CAPTION_PROPERTY);
           //     final Property p = item.getItemProperty(CAPTION_PROPERTY);
                //p.setValue(editor.getValue());
           //     p.setValue(productManagementComponent.getUpdatedProduct());
    //            this.requestRepaint();
   //         }

    //    }
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
	
	private Object addCaptionedItem(String caption, Object parent) {
        // add item, let tree decide id
        final Object id = this.addItem();
        // get the created item
        final Item item = this.getItem(id);
        // set our "caption" property
        final Property p = item.getItemProperty(CAPTION_PROPERTY);
        p.setValue(caption);
        if (parent != null) {
            setChildrenAllowed(parent, true);
            setParent(id, parent);
            setChildrenAllowed(id, false);
        }
        return id;
    }

	





	
	
	

}
