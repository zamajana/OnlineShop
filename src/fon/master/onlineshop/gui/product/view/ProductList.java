package fon.master.onlineshop.gui.product.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.Table;

import fon.master.onlineshop.data.ProductContainer;
import fon.master.onlineshop.domain.CartItem;
import fon.master.onlineshop.domain.Product;
import fon.master.onlineshop.gui.OnlineShopComponent;
import fon.master.onlineshop.gui.OnlineShopNotification;
import fon.master.onlineshop.logic.Controller;

public class ProductList extends Table{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	final OnlineShopComponent onlineShopComponent;
	private ProductContainer productContainer; 
	
	public ProductList(OnlineShopComponent onlineShopComponent){
		
		this.onlineShopComponent = onlineShopComponent;
		productContainer = Controller.getInstance().getProductContainer();
		
        setSizeFull();
        
        addGeneratedColumn("detail", new ColumnGenerator() {
			public Object generateCell(Table source, final Object itemId, Object columnId) {
				Product p = (Product) itemId;
				PopupView detail = new PopupView(new ProductDetailContent(p));
				detail.setHideOnMouseOut(false);
				return detail;
			}
		});
        
        addGeneratedColumn("order", new ColumnGenerator() {
			public Object generateCell(Table source, Object itemId, Object columnId) {
				final Product p = (Product) itemId;
				Button addToCartBtn = new Button("Add to cart!");	
				addToCartBtn.addListener(new Button.ClickListener() {	
					public void buttonClick(ClickEvent event) {
						addToCart(p);
					}
				});
				return addToCartBtn;
			}
		});

        
        setContainerDataSource(productContainer);
        setVisibleColumns(ProductContainer.NATURAL_COL_ORDER);
        setColumnHeaders(ProductContainer.COL_HEADERS_ENGLISH);
        setSelectable(true);
        setImmediate(true);
        setNullSelectionAllowed(false);
        
        setColumnCollapsingAllowed(true);
        setColumnReorderingAllowed(true);
	}

	
	private void addToCart(Product p){
		if(onlineShopComponent.isCustomerLoggedIn()){
			CartItem cartItem = new CartItem(null, onlineShopComponent.getCurrentCart(), p, p.getPrice(), 1);
			Controller.getInstance().addToCart(cartItem);
		}else{
			OnlineShopNotification.showNotification("You are not logged in!", getWindow());
		}
	}
	

}
