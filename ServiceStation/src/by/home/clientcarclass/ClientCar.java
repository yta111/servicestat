package by.home.clientcarclass;

public class ClientCar {
	private int carId;
	private String manufacture;
	private String model;
	private String year;
	
	
	public void setid(int id){
		this.carId=id;
	}
	public int getId(){
		return carId;
	}
	
	public void setManufacture(String manufacture){
		this.manufacture=manufacture;
	}
	public String getManufacture(){
		return manufacture;
	}
	
	public void setModel(String model){
		this.model=model;
	}
	public String getModel(){
		return model;
	}
	
	public void setYear(String  year){
		this.year= year;
	}
	public String getYear(){
		return  year;
	}
	
	
	
	
	public String toString(){
		return manufacture+" "+model+" "+year;
	}
}
