package fon.master.onlineshop.gui.product.view;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

import fon.master.onlineshop.domain.Product;

public class ProductGrid extends AbstractCell<Product>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void render(com.google.gwt.cell.client.Cell.Context context,
			Product value, SafeHtmlBuilder sb) {
		if (value == null) {
	        return;
	      }
	      sb.appendHtmlConstant("<table class='cell'>");
	      // Add the name and address.
	      sb.appendHtmlConstant("<td class='purpleHeading'>");
	      sb.appendEscaped(value.getName());
	      sb.appendHtmlConstant("</td></tr><tr><td><p>");
	      sb.appendEscaped("Description: "+value.getDescription());
	      sb.appendHtmlConstant("</p></td></tr></table>");
	}
	


}
