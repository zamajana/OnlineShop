package fon.master.onlineshop.logic;

import java.util.ArrayList;
import java.util.List;

import fon.master.onlineshop.data.CartContainer;
import fon.master.onlineshop.data.Data;
import fon.master.onlineshop.data.ProductComponentContainer;
import fon.master.onlineshop.data.ProductCompositeContainer;
import fon.master.onlineshop.data.ProductContainer;
import fon.master.onlineshop.domain.CartItem;
import fon.master.onlineshop.domain.Category;
import fon.master.onlineshop.domain.Category.Section;
import fon.master.onlineshop.domain.Customer;
import fon.master.onlineshop.domain.Product;
import fon.master.onlineshop.domain.ProductComponent;
import fon.master.onlineshop.domain.ProductComposite;


public class Controller {

	private ProductContainer productContainer;
	private ProductCompositeContainer productCompositeContainer;
	private ProductComponentContainer productComponentContainer;
	
//	private List<ProductContainer> productContainers;	
	private List<CartContainer> cartContainers;
	
	private static Controller controller;
	
	public static Controller getInstance(){
		if(controller==null){
			controller = new Controller();
		}
		return controller;
	}
	
	private Controller(){
		this.productContainer = new ProductContainer(Product.class);
		Data.getInstance().addProductsToComposite();
		this.productCompositeContainer = new ProductCompositeContainer(ProductComponent.class, "parent");
		this.productComponentContainer = new ProductComponentContainer(ProductComponent.class);
		this.cartContainers = new ArrayList<CartContainer>();
		showAllProducts();
		showAllProductsTree();
	}
	
	public void showAllProducts(){
		productContainer.addAll(Data.getInstance().getProductList());
	}
	
	public void showAllProductsTree(){
		for (ProductComponent productComponent : Data.getInstance().getProductCompositeList()) {
			productCompositeContainer.addBean(productComponent);
			if(productComponent.getChildren()!=null){
				for (ProductComponent pc : productComponent.getChildren()) {
					productCompositeContainer.addBean(pc);
				}
			}
		}
//		for (ProductComponent productComponent : Data.getInstance().getProductCompositeList()) {
//		productCompositeContainer.addBean(productComponent);
//		if(productComponent.getChildren()!=null){
//			for (ProductComponent pc : productComponent.getChildren()) {
//				productCompositeContainer.addBean(pc);
//			}
//		}
//		}
	}
	
	public void showAllChildrenProducts(ProductComponent parent){
		productComponentContainer.removeAllItems();
		productComponentContainer.addAll(parent.getChildren());
	}
	
	public ProductContainer getProductContainer(){
		return productContainer;
	}
	
	public ProductCompositeContainer getProductCompositeContainer() {
		return productCompositeContainer;
	}

	public ProductComponentContainer getProductComponentContainer() {
		return productComponentContainer;
	}

	public List<Category> getCategoriesForSection(Section section){
		List<Category> categories = new ArrayList<Category>();
		for (Category category : Data.getInstance().getCategoryList()) {
			if(category.getSection()==section){
				categories.add(category);
			}
		}
		return categories;
	}
	
	public void searchByCategory(Category category){
		List<Product> products = new ArrayList<Product>();
		for (Product product : Data.getInstance().getProductList()) {
			if(product.getCategory().equals(category)){
				products.add(product);
			}
		}
		productContainer = new ProductContainer(Product.class);
		productContainer.addAll(products);
	}
	
	public CartContainer getCartContainerForCustomer(Customer c){
		for (CartContainer cartContainer : cartContainers) {
			if(c.equals(cartContainer.getCustomer())){
				return cartContainer;
			}
		}
		return null;
	}
	
	public void logInCustomer(Customer c){
		CartContainer cartContainer = new CartContainer(CartItem.class, c);
		cartContainers.add(cartContainer);
	}
	
	public void logOutCart(Customer c){
		cartContainers.remove(getCartContainerForCustomer(c));
	}
	
	public void addToCart(CartItem cartItem){
		Customer c = cartItem.getCart().getCustomer();
		if(getCartContainerForCustomer(c).size()==0){		
			cartItem.setRb(1);
			getCartContainerForCustomer(c).addBean(cartItem);
		}else{
			for (CartItem i : getCartContainerForCustomer(c).getItemIds()) {
				if(i.getProduct().equals(cartItem.getProduct())){
					updateCartTable(i, c);
					updateTotalPrice(cartItem.getSumPrice(), c);
					return;
				}
			}
			cartItem.setRb(getCartContainerForCustomer(c).size()+1);
			getCartContainerForCustomer(c).addBean(cartItem);
		}
		updateTotalPrice(cartItem.getSumPrice(), c);
	}
	
	
	private void updateCartTable(CartItem cartItem, Customer c){
		Integer q = cartItem.getQuantity();
		getCartContainerForCustomer(c).getContainerProperty(cartItem, "quantity").setValue(q+1);
		Double p = cartItem.getSumPrice();
		getCartContainerForCustomer(c).getContainerProperty(cartItem, "sumPrice").setValue(p+cartItem.getProduct().getPrice());
	}
	
	
	public void updateCartItem(CartItem cartItem){
		Customer c = cartItem.getCart().getCustomer();
		Integer q = cartItem.getQuantity();
		getCartContainerForCustomer(c).getContainerProperty(cartItem, "quantity").setValue(q);
		getCartContainerForCustomer(c).getContainerProperty(cartItem, "sumPrice").setValue(q*cartItem.getProduct().getPrice());
		calculateTotalPrice(c);
	}
	
	private void updateTotalPrice(Double price, Customer c){
		getCartContainerForCustomer(c).setTotalAmount(getCartContainerForCustomer(c).getTotalAmount()+price);
	}

	private void calculateTotalPrice(Customer c){
		Double totalPrice = 0.00;
		for (CartItem i : getCartContainerForCustomer(c).getItemIds()) {
			totalPrice += i.getSumPrice();
		}
		getCartContainerForCustomer(c).setTotalAmount(totalPrice);
	}
	
	public void saveProduct(ProductComponent selectedProduct, ProductComponent productComponent){
		if(selectedProduct!=null && selectedProduct instanceof ProductComposite){
			selectedProduct.addChildProduct(productComponent);
			productComponentContainer.addBean(productComponent);
		}
		productCompositeContainer.addBean(productComponent);
	}
	
	public void updateProduct(ProductComponent selectedProduct, ProductComponent parent){
		List<ProductComponent> products = parent.getChildren();
		int id = selectedProduct.getId();
		for (ProductComponent productComponent : products) {
			if(productComponent.getId()==id){
				products.remove(productComponent);
				break;
			}
		}
		products.add(selectedProduct);
		refreshProductCompositeContainer(products);
	}
	
	public void refreshProductCompositeContainer(List<ProductComponent> products){
		productCompositeContainer = null;
		productCompositeContainer = new ProductCompositeContainer(ProductComponent.class, "parent");
		showAllProductsTree();
	}
	
	public void refreshProductCompositeContainerComposite(List<ProductComposite> products){
		productCompositeContainer = null;
		productCompositeContainer = new ProductCompositeContainer(ProductComponent.class, "parent");
		showAllProductsTree();
	}
	
	public void removeProduct(ProductComponent selectedProduct, ProductComponent parent){
		int id = selectedProduct.getId();
		System.out.println("####### DELETE ID: "+id);
		if(selectedProduct instanceof ProductComposite){
			List<ProductComposite> products = Data.getInstance().getProductCompositeList();
			for(ProductComposite productComposite : products){
				if(productComposite.getId()==id){
					products.remove(productComposite);
					refreshProductCompositeContainerComposite(products);
					break;
				}
			}
		}
			List<ProductComponent> products = parent.getChildren();
			for (ProductComponent productComponent : products) {
				if(productComponent.getId()==id){
					System.out.println("#### PRODUCT ID: "+productComponent.getId());
					products.remove(productComponent);
					refreshProductCompositeContainer(products);
					break;
				}
			}

	}
	
	
//	public void addToCart(Product product, Cart cart){	
//	if(cart.getCartItems().isEmpty() || cart.getCartItems().size()==0){
//		CartItem item = new CartItem(1,cart,product,product.getPrice(),1);
//		cart.getCartItems().add(item);
//		updateTotalPrice(cart);
//		updateCartTable(item);
//		return;
//	}else{
//		for (CartItem i : cart.getCartItems()) {
//			if(product.equals(i.getProduct())){
////				i.setQuantity(i.getQuantity()+1);
////				i.setSumPrice(i.getQuantity()*i.getProduct().getPrice());
//				updateTotalPrice(cart);
//				updateCartTable(i);
//				return;
//			}
//		}
//		CartItem item = new CartItem(cart.getCartItems().size()+1,cart,product,product.getPrice(),1);
//		cart.getCartItems().add(item);
//		updateTotalPrice(cart);
//		updateCartTable(item);
//	}
//}

	
	
}
