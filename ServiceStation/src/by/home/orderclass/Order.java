package by.home.orderclass;

public class Order {

	private String date;
	private String orderAmount;
	private String orderStatus;
	
	
	public void setDate(String date){
		this.date=date;
	}
	public String getDate(){
		return date;
	}
	
	public void setOrderAmount(String orderAmount){
		this.orderAmount=orderAmount;
	}
	public String getOrderAmount(){
		return orderAmount;
	}
	
	public void setOrderStatus(String  orderStatus){
		this.orderStatus= orderStatus;
	}
	public String getOrderStatus(){
		return  orderStatus;
	}
	
	
	
	
	public String toString(){
		return date+" "+orderAmount+" "+orderStatus;
	}
}
