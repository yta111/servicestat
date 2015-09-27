package by.home.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import by.home.orderclass.Order;

public class DBOrderRepository implements IOrderRepository{

	@Override
	public void addOrder(Order order, int carid) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/servicestation", "root", "password1234567chimneY");
			Statement state=c.createStatement();
			ResultSet rs=state.executeQuery("SELECT `car_id` FROM `servicestation`.`clientcar`"); 
			while(rs.next()){
				//System.out.println("client id "+ rs.getInt(1));
				if(carid==rs.getInt(1)){
					PreparedStatement st=c.prepareStatement("INSERT INTO `servicestation`.`order` (`car_id`, `Date`, `OrderAmount`, `OrderStatus`) VALUES ( ?, ?, ?, ?);");
					
					st.setInt(1,carid);
					st.setString(2,order.getDate());
					st.setString(3,order.getOrderAmount());
					st.setString(4,order.getOrderStatus());
					
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
		
	}

	@Override
	public void findAllOrderss() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/servicestation", "root", "password1234567chimneY");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("SELECT * FROM `servicestation`.`order`");
			while(rs.next()){
				System.out.println("car id "+ rs.getInt(1) +" date: "+rs.getString(2)+" orderamount: "+rs.getString(3)+" orderstatus: "+rs.getString(4));
			}
			rs.close();
			s.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderById(int carId) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/servicestation", "root", "password1234567chimneY");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("SELECT * FROM `servicestation`.`order`");
			while(rs.next()){
				if(rs.getInt(1)==(carId)){
					int id=rs.getInt("car_id");
					PreparedStatement st=c.prepareStatement("DELETE FROM`servicestation`.`order` WHERE `car_id`=?;");
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
	public void findOrderByCar(int carId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/servicestation", "root", "password1234567chimneY");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("SELECT * FROM `servicestation`.`order`"); 
			while(rs.next()){
				if(carId==rs.getInt(1)){
					System.out.println("car id "+ rs.getInt(1)+" date "+ rs.getString(2)+" orderamount: "+rs.getString(3)+" orderstatus: "+rs.getString(4));
				}
				
			}
			
			
			s.close();
			c.close();
			rs.close();
	}catch (Exception e) {
	 	e.printStackTrace();
	}
		
	}

}
