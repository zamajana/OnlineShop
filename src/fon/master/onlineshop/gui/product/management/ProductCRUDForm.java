package fon.master.onlineshop.gui.product.management;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

import fon.master.onlineshop.domain.Category;
import fon.master.onlineshop.domain.Category.Section;
import fon.master.onlineshop.domain.Product;
import fon.master.onlineshop.domain.ProductComponent;
import fon.master.onlineshop.domain.ProductComposite;
import fon.master.onlineshop.gui.ProductManagementComponent;
import fon.master.onlineshop.gui.ProductManagementComponent.Mode;
import fon.master.onlineshop.logic.Controller;

public class ProductCRUDForm extends VerticalSplitPanel implements ClickListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProductManagementComponent productManagementComponent;
	
	private Mode mode;
	
	private VerticalLayout productFormLayout = new VerticalLayout();
	private GridLayout productFieldsLayout = new GridLayout();
	private HorizontalLayout productButtonsLayout = new HorizontalLayout();
	private VerticalLayout childrenLayout = new VerticalLayout();
	
	private Label titleLbl = new Label("Selected product");
	
	private Label nameLbl = new Label("Name");
	private Label descriptionLbl = new Label("Description");
	private Label priceLbl = new Label("Price");
	private Label categoryLbl = new Label("Category");
	
	private Label nameValueLbl = new Label();
	private Label descriptionValueLbl = new Label();
	private Label priceValueLbl = new Label();
	private Label categoryValueLbl = new Label();
	
	private TextField nameTxt = new TextField();
	private TextField descriptionTxt = new TextField();
	private TextField priceTxt = new TextField();
	private TextField categoryTxt = new TextField();
	
	private Button saveBtn = new Button("Save");
	private Button updateBtn = new Button("Update");
	private Button deleteBtn = new Button("Delete");
	
	private ChildrenProductTable childrenProductTable;
	private Button addChildBtn = new Button("Add Child Product");
	
	private ProductComponent selectedProduct = null;

	public ProductCRUDForm(ProductManagementComponent productManagementComponent){
		
		this.productManagementComponent = productManagementComponent;
		
		setSplitPosition(30);
		
		// TOP of the vertical split panel
		
		// form is not visible, buttons are disabled, inputs are disabled
		productFormLayout.setVisible(false);
		disableProductForm();
		
		// input form, labels and input fields
		productFieldsLayout.setRows(4);
		productFieldsLayout.setColumns(2);
		productFieldsLayout.addComponent(nameLbl);
		productFieldsLayout.addComponent(nameValueLbl);
		productFieldsLayout.addComponent(descriptionLbl);
		productFieldsLayout.addComponent(descriptionValueLbl);
		productFieldsLayout.addComponent(priceLbl);
		productFieldsLayout.addComponent(priceValueLbl);
		productFieldsLayout.addComponent(categoryLbl);	
		productFieldsLayout.addComponent(categoryValueLbl);
		
		// save, update, delete buttons
		productButtonsLayout.addComponent(saveBtn);
		productButtonsLayout.addComponent(updateBtn);
		productButtonsLayout.addComponent(deleteBtn);
		
		// input form -- top, buttons -- bottom
		productFormLayout.addComponent(titleLbl);
		productFormLayout.addComponent(productFieldsLayout);
		productFormLayout.addComponent(productButtonsLayout);
		
		// BOTTOM of the vertical split panel
		
		addChildBtn.addListener((ClickListener)this);
		saveBtn.addListener((ClickListener)this);
		updateBtn.addListener((ClickListener)this);
		
		// set on vertical split panel
		addComponent(productFormLayout);	

	}


	public void productSelected(ProductComponent productComponent){
		
		this.selectedProduct = productComponent;	
		//initializeProductInputForm(selectedProduct);
		//showProductForm();
		productFormLayout.setVisible(true);
		showSelectedProduct(selectedProduct);
		
		initializeChildrenProductTable(selectedProduct);
		showChildrenProductsTable();
		
	}

	
	public void prepareProductForm(Mode mode){
		setMode(mode);
		productButtonsLayout.setEnabled(true);
		if(mode==Mode.ADD_COMPOSITE_PRODUCT){
			enableFormForAddCompositeProduct();		
		}else if(mode==Mode.ADD_PRODUCT){
			enableFormForAddProduct();
		}else if(mode==Mode.EDIT_COMPOSITE_PRODUCT){
			enableFormForEditCompositeProduct();
		}else if(mode==Mode.EDIT_PRODUCT){
			enableFormForEditProduct();
		}
	}
	
	private void showSelectedProduct(ProductComponent productComponent){
		nameValueLbl.setValue(productComponent.getName());
		descriptionValueLbl.setValue(productComponent.getDescription());
		priceValueLbl.setValue(productComponent.getPrice());
		categoryValueLbl.setValue(productComponent.getCategory().getName());
		productFieldsLayout.removeAllComponents();
		productFieldsLayout.addComponent(nameLbl);
		productFieldsLayout.addComponent(nameValueLbl);
		productFieldsLayout.addComponent(descriptionLbl);
		productFieldsLayout.addComponent(descriptionValueLbl);
		productFieldsLayout.addComponent(priceLbl);
		productFieldsLayout.addComponent(priceValueLbl);
		productFieldsLayout.addComponent(categoryLbl);	
		productFieldsLayout.addComponent(categoryValueLbl);
	}
	
	private void initializeProductInputForm(ProductComponent productComponent){
		nameTxt.setValue(productComponent.getName());
		descriptionTxt.setValue(productComponent.getDescription());
		priceTxt.setValue(productComponent.getPrice());
		categoryTxt.setValue(productComponent.getCategory().getName());
		if(productComponent instanceof ProductComposite){
			priceTxt.setEnabled(false);
		}else{
			priceTxt.setEnabled(true);
		}
		productFieldsLayout.removeAllComponents();
		productFieldsLayout.addComponent(nameLbl);
		productFieldsLayout.addComponent(nameTxt);
		productFieldsLayout.addComponent(descriptionLbl);
		productFieldsLayout.addComponent(descriptionTxt);
		productFieldsLayout.addComponent(priceLbl);
		productFieldsLayout.addComponent(priceTxt);
		productFieldsLayout.addComponent(categoryLbl);	
		productFieldsLayout.addComponent(categoryTxt);
	}
	
	private void initializeChildrenProductTable(ProductComponent productComponent){
		try{
			Controller.getInstance().showAllChildrenProducts(productComponent);
		}catch(Exception e){
		
		}
	}
	
	private void showChildrenProductsTable(){
		childrenLayout.removeAllComponents();
		childrenLayout.removeComponent(childrenLayout);
		childrenProductTable = new ChildrenProductTable(this);
		childrenLayout.addComponent(childrenProductTable);
		childrenLayout.addComponent(addChildBtn);
		setSecondComponent(childrenLayout);	
	}
	
	private void enableFormForAddCompositeProduct(){
		enableFormForAdd();
		priceTxt.setEnabled(false);
	}
	
	private void enableFormForAddProduct(){
		enableFormForAdd();
		priceTxt.setEnabled(true);
	}
	
	private void enableFormForAdd(){
		productFormLayout.removeAllComponents();
		nameTxt.setValue("");
		descriptionTxt.setValue("");
		priceTxt.setValue("");
		categoryTxt.setValue("");
		if(selectedProduct instanceof ProductComposite){
			priceTxt.setEnabled(false);
		}else{
			priceTxt.setEnabled(true);
		}
		saveBtn.setEnabled(true);
		updateBtn.setEnabled(false);
		deleteBtn.setEnabled(false);
		productFieldsLayout.addComponent(nameLbl);
		productFieldsLayout.addComponent(nameTxt);
		productFieldsLayout.addComponent(descriptionLbl);
		productFieldsLayout.addComponent(descriptionTxt);
		productFieldsLayout.addComponent(priceLbl);
		productFieldsLayout.addComponent(priceTxt);
		productFieldsLayout.addComponent(categoryLbl);	
		productFieldsLayout.addComponent(categoryTxt);
		productFormLayout.setVisible(true);
	}
	
	private void enableFormForEditCompositeProduct(){
		initializeProductInputForm(selectedProduct);
		enableFormForEdit();
		priceTxt.setEnabled(false);
		childrenLayout.setEnabled(true);
	}
	
	private void enableFormForEditProduct(){
		initializeProductInputForm(selectedProduct);
		enableFormForEdit();
		priceTxt.setEnabled(true);
		childrenLayout.setEnabled(false);
	}
	
	private void enableFormForEdit(){
		saveBtn.setEnabled(false);
		updateBtn.setEnabled(true);
		deleteBtn.setEnabled(true);
	}
	
	public void disableProductForm(){
		productButtonsLayout.setEnabled(false);
		childrenLayout.setEnabled(false);
	}

	public void buttonClick(ClickEvent event) {
		final Button source = event.getButton();
//		if(source == addChildBtn){
//			prepareProductForm(Mode.ADD_PRODUCT);
		//}else 
			if(source == saveBtn){
				ProductComponent product = createNewProduct();		
				Controller.getInstance().saveProduct(selectedProduct, product);
			}else if(source == updateBtn){
				productManagementComponent.removeProductsTree();
				ProductComponent product = editProduct(selectedProduct);
				System.out.println("######## 1. RADI DO OVDE>>>");
				Controller.getInstance().updateProduct(product, product.getParent());
				System.out.println("######## 2. RADI DO OVDE>>>");
				productManagementComponent.refreshProductsTree();
//				final Object id = productManagementComponent.getProductsTree().getValue();
//				if (id != null) {
//					 final Item item = productManagementComponent.getProductsTree().getItem(id);
//			         final Property p = item.getItemProperty(CAPTION_PROPERTY);
//			         p.setValue(productManagementComponent.getUpdatedProduct());
//			         productManagementComponent.repaintProductsTree();
//				}
//				selectedProduct = editProduct(selectedProduct);
			}
	}
	
	private ProductComponent editProduct(ProductComponent productComponent){	
		productComponent.change(nameTxt.getValue().toString(), Double.valueOf(priceTxt.getValue().toString()), 
					descriptionTxt.getValue().toString(), new Category(1, categoryTxt.getValue().toString(), Section.MEN));
		return productComponent;
	}
	
	private ProductComponent createNewProduct(){
		ProductComponent product = null;
		if(getMode()==Mode.ADD_COMPOSITE_PRODUCT){
			product = new ProductComposite(1, nameTxt.getValue().toString(), descriptionTxt.getValue().toString(), 
			new Category(1, categoryTxt.getValue().toString(), Section.WOMEN));
		}else if(getMode()==Mode.ADD_PRODUCT){
			product = new Product(1, nameTxt.getValue().toString(), Double.valueOf(priceTxt.getValue().toString()), 
			descriptionTxt.getValue().toString(), new Category(1, categoryTxt.getValue().toString(), Section.WOMEN));
		}
		return product;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public ProductComponent getSelectedProduct() {
		return selectedProduct;
	}

	
}
