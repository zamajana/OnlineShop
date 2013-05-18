package fon.master.onlineshop.data;

import java.util.ArrayList;
import java.util.List;

import fon.master.onlineshop.domain.Address;
import fon.master.onlineshop.domain.Cart;
import fon.master.onlineshop.domain.CartItem;
import fon.master.onlineshop.domain.Category;
import fon.master.onlineshop.domain.Customer;
import fon.master.onlineshop.domain.Place;
import fon.master.onlineshop.domain.Product;
import fon.master.onlineshop.domain.ProductComponent;
import fon.master.onlineshop.domain.ProductComposite;
import fon.master.onlineshop.domain.Category.Section;

public class Data {

	private static Data operations;
	
	public static Data getInstance(){
		if(operations==null){
			operations = new Data();
		}
		return operations;
	}
	
	private Data(){}
	
	private List<Category> categoryList = new ArrayList<Category>(){{
		add(new Category(1, "Tops", Section.WOMEN));
		add(new Category(2, "Bottoms", Section.WOMEN));
		add(new Category(3, "Dresses", Section.WOMEN));
		add(new Category(4, "Bottoms", Section.MEN));
		add(new Category(5, "Jackets and coats", Section.WOMEN));
		add(new Category(6, "Accessories", Section.WOMEN));
		add(new Category(7, "Suits", Section.MEN));
		add(new Category(8, "Shoes", Section.WOMEN));
		add(new Category(9, "Shoes", Section.CHILDREN));
	}};
	
	private List<Category> compositeCategoryList = new ArrayList<Category>(){{
		add(new Category(10, "Outfits", Section.WOMEN));
		add(new Category(11, "Catalogue", Section.WOMEN));
	}};
	
	private List<Product> productList = new ArrayList<Product>(){{
		add(new Product(1, "Earrings", 400.00, "Some earrings desciption", null, null, null, 10.00, "", 9.08, categoryList.get(5)));
		add(new Product(2, "Necklace", 100.00, "Some necklace description", null, null, null, 10.00, "", 8.00, categoryList.get(5)));
		add(new Product(3, "Pumps", 4500.00, "Black pumps description", null, null, null, 10.00, "", 9.00, categoryList.get(7)));
		add(new Product(4, "Trench coat", 5000.00, "Trench coat description", null, null, null, 10.00, "", 9.00, categoryList.get(4)));
		add(new Product(5, "Black suit", 7200.00, "Man suit description", null, null, null, 10.00, "", 9.00, categoryList.get(6)));
		add(new Product(6, "Little black dress", 2500.00, "Little black dress never gets old", null, null, null, 10.00, "", 9.00, categoryList.get(2)));
		add(new Product(7, "Peplum dress", 3000.00, "Trending this winter", null, null, null, 10.00, "", 9.00, categoryList.get(2)));
		add(new Product(8, "Vedges", 3500.00, "Great for summer", null, null, null, 10.00, "", 9.00, categoryList.get(7)));
		add(new Product(9, "Children snickers", 2800.00, "Children snickers description", null, null, null, 10.00, "", 9.00, categoryList.get(8)));
		add(new Product(10, "Hat", 1500.00, "Hat description", null, null, null, 10.00, "", 9.00, categoryList.get(5)));
		add(new Product(11, "Earrings", 400.00, "Some earrings desciption", null, null, null, 10.00, "", 9.08, categoryList.get(5)));
		add(new Product(12, "Necklace", 100.00, "Some necklace description", null, null, null, 10.00, "", 8.00, categoryList.get(5)));
		add(new Product(13, "Pumps", 4500.00, "Black pumps description", null, null, null, 10.00, "", 9.00, categoryList.get(7)));
		add(new Product(14, "Trench coat", 5000.00, "Trench coat description", null, null, null, 10.00, "", 9.00, categoryList.get(4)));
		add(new Product(15, "Black suit", 7200.00, "Man suit description", null, null, null, 10.00, "", 9.00, categoryList.get(6)));
		add(new Product(16, "Little black dress", 2500.00, "Little black dress never gets old", null, null, null, 10.00, "", 9.00, categoryList.get(2)));
		add(new Product(17, "Peplum dress", 3000.00, "Trending this winter", null, null, null, 10.00, "", 9.00, categoryList.get(2)));
		add(new Product(18, "Vedges", 3500.00, "Great for summer", null, null, null, 10.00, "", 9.00, categoryList.get(7)));
		add(new Product(19, "Children snickers", 2800.00, "Children snickers description", null, null, null, 10.00, "", 9.00, categoryList.get(8)));
		add(new Product(20, "Hat", 1500.00, "Hat description", null, null, null, 10.00, "", 9.00, categoryList.get(5)));
	}};
	
	private ProductComposite rootComposite = new ProductComposite(100, "Look book", "What's your style?", compositeCategoryList.get(1));
	
	private ProductComposite productComposite1 =  new ProductComposite(21, "Summer time", "Look fresh, feel free", compositeCategoryList.get(0));
	private ProductComposite productComposite2 =  new ProductComposite(22, "Winter is coming", "Get dress for snow", compositeCategoryList.get(0));
	private ProductComposite productComposite3 =  new ProductComposite(23, "Get lucky", "We're up all night for good fun", compositeCategoryList.get(0));
	private ProductComposite productComposite4 =  new ProductComposite(24, "Raindrops", "You make me happy when skies are grey", compositeCategoryList.get(0));
	
	private List<ProductComponent> productComponentList = new ArrayList<ProductComponent>(){{
		add(new Product(1, "Earrings", 400.00, "Some earrings desciption", categoryList.get(5)));
		add(new Product(2, "Necklace", 100.00, "Some necklace description", categoryList.get(5)));
		add(new Product(3, "Pumps", 4500.00, "Black pumps description", categoryList.get(7)));
		add(new Product(4, "Trench coat", 5000.00, "Trench coat description", categoryList.get(4)));
		add(new Product(5, "Black suit", 7200.00, "Man suit description", categoryList.get(6)));
		add(new Product(6, "Little black dress", 2500.00, "Little black dress never gets old", categoryList.get(2)));
		add(new Product(7, "Peplum dress", 3000.00, "Trending this winter", categoryList.get(2)));
		add(new Product(8, "Vedges", 3500.00, "Great for summer", categoryList.get(7)));
		add(new Product(9, "Children snickers", 2800.00, "Children snickers description", categoryList.get(8)));
		add(new Product(10, "Hat", 1500.00, "Hat description", categoryList.get(5)));
		add(new Product(11, "Earrings", 400.00, "Some earrings desciption", categoryList.get(5)));
		add(new Product(12, "Necklace", 100.00, "Some necklace description", categoryList.get(5)));
		add(new Product(13, "Pumps", 4500.00, "Black pumps description", categoryList.get(7)));
		add(new Product(14, "Trench coat", 5000.00, "Trench coat description", categoryList.get(4)));
		add(new Product(15, "Black suit", 7200.00, "Man suit description", categoryList.get(6)));
		add(new Product(16, "Little black dress", 2500.00, "Little black dress never gets old", categoryList.get(2)));
		add(new Product(17, "Peplum dress", 3000.00, "Trending this winter", categoryList.get(2)));
		add(new Product(18, "Vedges", 3500.00, "Great for summer", categoryList.get(7)));
		add(new Product(19, "Children snickers", 2800.00, "Children snickers description", categoryList.get(8)));
		add(new Product(20, "Hat", 1500.00, "Hat description", categoryList.get(5)));
	}};
	
	
	
	public void addProductsToComposite(){
		
		Product product1 = new Product(1, "Earrings", 400.00, "Some earrings desciption", categoryList.get(5));
		Product product2 = new Product(2, "Necklace", 100.00, "Some necklace description", categoryList.get(5));
		Product product3 = new Product(3, "Pumps", 4500.00, "Black pumps description", categoryList.get(7));
		Product product4 = new Product(4, "Trench coat", 5000.00, "Trench coat description", categoryList.get(4));
		Product product5 = new Product(5, "Black suit", 7200.00, "Man suit description", categoryList.get(6));
		Product product6 = new Product(6, "Little black dress", 2500.00, "Little black dress never gets old", categoryList.get(2));
		Product product7 = new Product(7, "Peplum dress", 3000.00, "Trending this winter", categoryList.get(2));
		Product product8 = new Product(8, "Vedges", 3500.00, "Great for summer", categoryList.get(7));
		Product product9 = new Product(9, "Children snickers", 2800.00, "Children snickers description", categoryList.get(8));
		Product product10 = new Product(10, "Hat", 1500.00, "Hat description", categoryList.get(5));
		Product product11 = new Product(11, "Earrings", 400.00, "Some earrings desciption", categoryList.get(5));
		Product product12 = new Product(12, "Necklace", 100.00, "Some necklace description", categoryList.get(5));
		Product product13 = new Product(13, "Pumps", 4500.00, "Black pumps description", categoryList.get(7));
		Product product14 = new Product(14, "Trench coat", 5000.00, "Trench coat description", categoryList.get(4));
		Product product15 = new Product(15, "Black suit", 7200.00, "Man suit description", categoryList.get(6));
		Product product16 = new Product(16, "Little black dress", 2500.00, "Little black dress never gets old", categoryList.get(2));
		Product product17 = new Product(17, "Peplum dress", 3000.00, "Trending this winter", categoryList.get(2));
		Product product18 = new Product(18, "Vedges", 3500.00, "Great for summer", categoryList.get(7));
		Product product19 = new Product(19, "Children snickers", 2800.00, "Children snickers description", categoryList.get(8));
		Product product20 = new Product(20, "Hat", 1500.00, "Hat description", categoryList.get(5));
		
		rootComposite.setParent(null);
		
		productComposite1.addChildProduct(product1);
		productComposite1.addChildProduct(product18);
		productComposite1.addChildProduct(product20);
		productComposite1.addChildProduct(product3);
		productComposite1.addChildProduct(product4);
		productComposite1.addChildProduct(product17);
		
		productComposite2.addChildProduct(product2);
		productComposite2.addChildProduct(product14);
		productComposite2.addChildProduct(product5);
		productComposite2.addChildProduct(product8);
		productComposite2.addChildProduct(product16);
		productComposite2.addChildProduct(product19);
		
		productComposite3.addChildProduct(productComposite1);
		productComposite3.addChildProduct(product7);
		productComposite3.addChildProduct(product6);
		productComposite3.addChildProduct(product9);
		productComposite3.addChildProduct(product10);
		productComposite3.addChildProduct(product15);
		
		productComposite4.addChildProduct(product2);
		productComposite4.addChildProduct(product14);
		productComposite4.addChildProduct(product20);
		productComposite4.addChildProduct(product11);
		productComposite4.addChildProduct(product12);
		productComposite4.addChildProduct(product13);
		
		rootComposite.addChildProduct(productComposite1);
		rootComposite.addChildProduct(productComposite2);
		rootComposite.addChildProduct(productComposite3);
		rootComposite.addChildProduct(productComposite4);
	}
	
	private List<ProductComposite> productCompositeList = new ArrayList<ProductComposite>(){{
		add(rootComposite);
		add(productComposite1);
		add(productComposite2);
		add(productComposite3);
		add(productComposite4);
	}};

	
	private List<Customer> customerList = new ArrayList<Customer>(){{
		add(new Customer(1, "Maja", "Dumitraskovic", "zamajana", "zamajana", "zamajana@gmail.com", new Address(1, "Decanska", "31", new Place(1, 19300, "Negotin")), null));
		Place bg = new Place(2, 11000, "Beograd");
		add(new Customer(2, "Jovana", "Veskovic", "joca", "skljoca", "jocaskljoca@gmail.com", new Address(2, "Brace Skerovic", "12/4", bg), null));
		add(new Customer(3, "Milica", "Bokonjic", "mica", "patuljica", "patuljica@gmail.com", new Address(3, "Ulica", "bb", bg), null));
	}};
	
	private List<CartItem> cartItemList = new ArrayList<CartItem>(){{
		Cart cart = new Cart(1, 10000.00, getCustomerList().get(0), null);
		add(new CartItem(1, cart, getProductList().get(0), 100.00, 3));
		add(new CartItem(2, cart, getProductList().get(1), 104.00, 1));
		add(new CartItem(3, cart, getProductList().get(2), 150.60, 1));
	}};
	
	public List<Product> getProductList() {
		return productList;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public List<Category> getCompositeCategoryList() {
		return compositeCategoryList;
	}

	public List<ProductComponent> getProductComponentList() {
		return productComponentList;
	}

	public List<ProductComposite> getProductCompositeList() {
		return productCompositeList;
	}

	public ProductComposite getRootComposite() {
		return rootComposite;
	}
	
	
	
	
}
