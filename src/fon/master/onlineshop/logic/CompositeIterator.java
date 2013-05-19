package fon.master.onlineshop.logic;

import java.util.Iterator;
import java.util.Stack;

import fon.master.onlineshop.domain.ProductComponent;
import fon.master.onlineshop.domain.ProductComposite;

public class CompositeIterator implements Iterator<ProductComponent>{

	Stack<Iterator<ProductComponent>> stack = new Stack<Iterator<ProductComponent>>();
	
	public CompositeIterator(Iterator<ProductComponent> iterator){
		stack.push(iterator);
	}
	
	public boolean hasNext() {
		if(stack.isEmpty()){
			return false;
		}else{
			Iterator<ProductComponent> iterator = stack.peek();
			if(!iterator.hasNext()){
				stack.pop();
				return hasNext();
			}else{
				return true;
			}
		}
	}

	public ProductComponent next() {
		if(hasNext()){
			Iterator<ProductComponent> iterator = stack.peek();
			ProductComponent productComponent = iterator.next();
			if(productComponent instanceof ProductComposite && !(iterator instanceof CompositeIterator)){
				stack.push(productComponent.createIterator());
			}
			return productComponent;
		}else{
			return null;
		}
	}

	public void remove() {
		Iterator<ProductComponent> iterator = stack.peek();
		iterator.remove();
	}

}
