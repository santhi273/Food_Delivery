package com.capg.foodonlinedelivery.model;
import java.util.List;
import com.capg.foodonlinedelivery.entities.Customer;
import com.capg.foodonlinedelivery.entities.Items;
public class FoodCartDTO {
	 private String cartId;
	    private List<Items> itemList;
	    private Customer customer;
		
		public FoodCartDTO() {
			super();
		}
		public FoodCartDTO(String cartId, List<Items> itemList, Customer customer) {
			super();
			this.cartId = cartId;
			this.itemList = itemList;
			this.customer = customer;
		}
		public String getCartId() {
			return cartId;
		}
		public void setCartId(String cartId) {
			this.cartId = cartId;
		}
		public List<Items> getItemList() {
			return itemList;
		}
		public void setItemList(List<Items> itemList) {
			this.itemList = itemList;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		
}
