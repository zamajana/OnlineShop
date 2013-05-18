package fon.master.onlineshop.gui.product.management;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table;

import fon.master.onlineshop.data.ProductComponentContainer;
import fon.master.onlineshop.domain.ProductComponent;
import fon.master.onlineshop.logic.Controller;

public class ChildrenProductTable extends Table{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProductComponentContainer productComponentContainer;
	private ProductCRUDForm productCRUDForm;
	private ProductComponent selectedProduct = null;
	
	public ChildrenProductTable(ProductCRUDForm productCRUDForm){
		
		this.productCRUDForm = productCRUDForm;
		
		productComponentContainer = Controller.getInstance().getProductComponentContainer();
		
		setHeight("400px");
		setWidth("100%");

        addGeneratedColumn("edit", new ColumnGenerator() {
 			public Object generateCell(Table source, final Object itemId, Object columnId) {
 				ProductComponent product = (ProductComponent) itemId;
 				Button editButton = new Button("Edit"); 
 				editButton.addListener(new Button.ClickListener() {			
					public void buttonClick(ClickEvent event) {
						selectedProduct = (ProductComponent) itemId;
						selectedProduct();
					}
				});
 				return editButton;
 			}
 		});
     
        
        setContainerDataSource(productComponentContainer);
        setVisibleColumns(ProductComponentContainer.NATURAL_COL_ORDER);
        setColumnHeaders(ProductComponentContainer.COL_HEADERS_ENGLISH);
        setSelectable(true);
        setImmediate(true);
        setNullSelectionAllowed(false);
        
        setColumnCollapsingAllowed(true);
        setColumnReorderingAllowed(true);
	}
	
	private void selectedProduct(){
		productCRUDForm.productSelected(selectedProduct);
	}
	
	

}
