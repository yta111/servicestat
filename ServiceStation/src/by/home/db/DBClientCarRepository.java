package by.home.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import by.home.clientcarclass.ClientCar;
import by.home.clientcardclass.ClientCard;
import by.home.clientcardclass.ClientCardStore;

public class DBClientCarRepository implements IClientCarRepository {
	
	ClientCardStore carStore=new ClientCardStore();
	
	ArrayList<ClientCard> cardList;
	@Override
	public void addClientCar(ClientCar car, int clientId) {
		
		
		
		//cardList=carStore.getClientcardList();
		
		//for(int i=0; i<cardList.size(); i++){
			//if(clientId==cardList.get(i).getId()){
				try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost/servicestation", "root", "password1234567chimneY");
				Statement state=c.createStatement();
				ResultSet rs=state.executeQuery("SELECT `Client_id` FROM `servicestation`.`clientcard`"); 
				while(rs.next()){
					//System.out.println("client id "+ rs.getInt(1));
					if(clientId==rs.getInt(1)){
						PreparedStatement st=c.prepareStatement("INSERT INTO `servicestation`.`clientcar` (`client_id`,`car_id`, `Manufacture`, `Model`, `Year`) VALUES (?, ?, ?, ?, ?);");
						
						st.setInt(1,clientId);
						st.setInt(2,car.getId());
						st.setString(3,car.getManufacture());
						st.setString(4,car.getModel());
						st.setString(5,car.getYear());
						
						st.executeUpdate();
						st.close();
					}
				}
				
				
				
				c.close();
				rs.close();
				//System.out.println("I get here!");
				
				}catch(Exception exp){
					exp.printStackTrace();
				}
		//	}else{
		//		System.out.println("Enter correct id of existing owner");
		//	}
				
	//	
		
	}
	@Override
	public void findAllCars() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/servicestation", "root", "password1234567chimneY");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select * from clientcar");
			while(rs.next()){
				System.out.println("client id "+ rs.getInt(1)+" car id "+ rs.getInt(2)+" manufacturer: "+rs.getString(3)+" model: "+rs.getString(4)+" year: "+rs.getString(5));
			}
			rs.close();
			s.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteCarById(int carId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/servicestation", "root", "password1234567chimneY");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("SELECT * FROM `servicestation`.`clientcar`");
			while(rs.next()){
				if(rs.getInt(2)==(carId)){
					int id=rs.getInt("car_id");
					PreparedStatement st=c.prepareStatement("DELETE FROM`servicestation`.`clientcar` WHERE `car_id`=?;");
					st.setInt(1,id);
					st.executeUpdate();
					st.close();
				}
			}
			s.close();
			c.close();
			} catch (Exception e) {
		 	e.printStackTrace();
		}
	}
	@Override
	public void findCarByClient(int clientId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/servicestation", "root", "password1234567chimneY");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("SELECT * FROM `servicestation`.`clientcar`"); 
			while(rs.next()){
				if(clientId==rs.getInt(1)){
					System.out.println("client id "+ rs.getInt(1)+" car id "+ rs.getInt(2)+" manufacturer: "+rs.getString(3)+" model: "+rs.getString(4)+" year: "+rs.getString(5));
				}
				
			}
			
			//ResultSet rs=s.executeQuery("select * from clientcar WHERE `client_id`=2;");
			//rs.setInt(1,clientId);
			//rs.executeUpdate();
			
			s.close();
			c.close();
			rs.close();
	}catch (Exception e) {
	 	e.printStackTrace();
	}
	

}
}
