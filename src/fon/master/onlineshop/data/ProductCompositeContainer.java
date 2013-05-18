package fon.master.onlineshop.data;

import java.util.Collection;
import java.util.LinkedList;

import com.vaadin.data.Container.Hierarchical;
import com.vaadin.data.util.BeanItemContainer;

import fon.master.onlineshop.domain.ProductComponent;

public class ProductCompositeContainer extends BeanItemContainer<ProductComponent> implements Hierarchical{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Object parentPropertyId;
	
	public ProductCompositeContainer(Class<? super ProductComponent> type, Object parentPropertyId)
			throws IllegalArgumentException {
		super(type);
		this.parentPropertyId = parentPropertyId;
	}

	public Collection<?> getChildren(Object itemId) {
//		List<ProductComponent> children = new ArrayList<ProductComponent>();
//		children = ((ProductComponent) itemId).getChildren();
//		return children;
		LinkedList<Object> children = new LinkedList<Object>();
		for (Object candidateId: getItemIds()) {
			Object parentRef = getItem(candidateId).getItemProperty(parentPropertyId).getValue();
			if (parentRef == itemId)
				children.add(candidateId);
		}
		if (children.size() > 0)
			return children;
		else
			return null;
	}

	public ProductComponent getParent(Object itemId) {
		return (ProductComponent) getItem(itemId).getItemProperty(parentPropertyId).getValue();
	}

	public Collection<?> rootItemIds() {
//        List<ProductComponent> roots = new ArrayList<ProductComponent>();
//        roots.add(root);
//        return roots;
		LinkedList<Object> result = new LinkedList<Object>();
		for (Object candidateId: getItemIds()) {
			Object parentRef = getItem(candidateId).getItemProperty(parentPropertyId).getValue();
			if (parentRef == null)
				result.add(candidateId);
		}
		if (result.size() > 0)
			return result;
		else
			return null;
	}

	public boolean setParent(Object itemId, Object newParentId)
			throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Not implemented here");
	}

	public boolean areChildrenAllowed(Object itemId) {
		 return hasChildren(itemId);
	}

	public boolean setChildrenAllowed(Object itemId, boolean areChildrenAllowed)
			throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Not implemented here");
	}

	public boolean isRoot(Object itemId) {
		throw new UnsupportedOperationException("Not implemented here");
	}

	public boolean hasChildren(Object itemId) {
//		if(((ProductComponent) itemId).getChildren()==null || ((ProductComponent) itemId).getChildren().isEmpty()){
//			return false;
//		}
//		return true;
		for (Object candidateId: getItemIds()) {
		     Object parentRef = getItem(candidateId).getItemProperty(parentPropertyId).getValue();
		     if (parentRef == itemId)
		         return true;
		 }
		 return false;
	}

//	@Override
//	public boolean addNestedContainerProperty(String propertyId) {
//		return super.addNestedContainerProperty(propertyId);
//	}


}
