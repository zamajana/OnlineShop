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
	
	private Label titleLbl = new Label();
	
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
		
		setSplitPosition(40);
		
		// TOP of the vertical split panel
		
		// form is not visible, buttons are disabled, inputs are disabled
		hideProductForm();
		
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
		productFieldsLayout.setSpacing(true);
		productFieldsLayout.setMargin(true);
		
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
		deleteBtn.addListener((ClickListener)this);
		
		// set on vertical split panel
		addComponent(productFormLayout);	

	}


	public void productSelected(ProductComponent productComponent){
		
		this.selectedProduct = productComponent;	
		//initializeProductInputForm(selectedProduct);
		//showProductForm();
		productFormLayout.setVisible(true);
		childrenLayout.setVisible(true);
		childrenLayout.setEnabled(false);
		showSelectedProduct(selectedProduct);
		showReadOnlyForm();
		
		initializeChildrenProductTable(selectedProduct);
		showChildrenProductsTable();
		
	}

	
	public void prepareProductForm(Mode mode){
		setMode(mode);
		productButtonsLayout.setEnabled(true);
		if(mode==Mode.ADD_COMPOSITE_PRODUCT || mode==Mode.ADD_PRODUCT){
			enableInputFormForAdd();
		}else if(mode==Mode.EDIT_COMPOSITE_PRODUCT || mode==Mode.EDIT_PRODUCT){
			enableInputFormForEdit();
		}
	}
	
	private void showSelectedProduct(ProductComponent productComponent){
		nameValueLbl.setValue(productComponent.getName());
		descriptionValueLbl.setValue(productComponent.getDescription());
		priceValueLbl.setValue(productComponent.getPrice());
		categoryValueLbl.setValue(productComponent.getCategory().getName());
		titleLbl.setValue("SELECTED PRODUCT");
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
	
	private void enableInputFormForAdd(){
		clearFormForAdd();
		priceTxt.setEnabled(getMode()==Mode.ADD_PRODUCT);
		titleLbl.setValue("ADD NEW PRODUCT");
		enableActionsForAdd();
		showFormWithInputs();
		if(!productFormLayout.isVisible()){
			productFormLayout.setVisible(true);
		}
	}
	
	private void enableInputFormForEdit(){
		initializeProductInputForm(selectedProduct);
		priceTxt.setEnabled(getMode()==Mode.EDIT_PRODUCT);
		childrenLayout.setEnabled(getMode()==Mode.EDIT_COMPOSITE_PRODUCT);
		titleLbl.setValue("EDIT SELECTED PRODUCT");
		enableActionsForEdit();
		showFormWithInputs();
	}
	
	private void clearFormForAdd(){
		nameTxt.setValue("");
		descriptionTxt.setValue("");
		priceTxt.setValue("");
		categoryTxt.setValue("");
	}
	
	private void showFormWithInputs(){
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
	
	private void showReadOnlyForm(){
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
	
	private void enableActionsForEdit(){
		saveBtn.setEnabled(false);
		updateBtn.setEnabled(true);
		deleteBtn.setEnabled(true);
	}
	
	private void enableActionsForAdd(){
		saveBtn.setEnabled(true);
		updateBtn.setEnabled(false);
		deleteBtn.setEnabled(false);
	}
	
	public void hideProductForm(){
		productFormLayout.setVisible(false);
		childrenLayout.setVisible(false);
	}

	public void buttonClick(ClickEvent event) {
		final Button source = event.getButton();
//		if(source == addChildBtn){
//			prepareProductForm(Mode.ADD_PRODUCT);
		//}else 
			if(source == saveBtn){
				ProductComponent product = createNewProduct();		
				Controller.getInstance().saveProduct(selectedProduct, product);
				productManagementComponent.getProductsTree().select(product);
			}else if(source == updateBtn){
				productManagementComponent.removeProductsTree();
				ProductComponent productComponent = selectedProduct;
				productComponent = editProduct(productComponent);
				Controller.getInstance().updateProduct(productComponent, productComponent.getParent());
				productManagementComponent.refreshProductsTree();
				selectedProduct = productComponent;
				productManagementComponent.getProductsTree().select(selectedProduct);
			}else if(source == deleteBtn){
				productManagementComponent.removeProductsTree();
				Controller.getInstance().removeProduct(selectedProduct, selectedProduct.getParent());
				productManagementComponent.refreshProductsTree();
				hideProductForm();
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
			showChildrenProductsTable();
			childrenLayout.setVisible(true);
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
