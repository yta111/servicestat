package by.home.maincontroller;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;













import by.home.clientcarclass.ClientCar;
import by.home.clientcardclass.ClientCard;
import by.home.clientcardclass.ClientCardStore;
import by.home.db.DBClientCarRepository;
import by.home.db.DBClientCardRepository;
import by.home.db.DBOrderRepository;
import by.home.db.IClientCarRepository;
import by.home.db.IClientCardrepository;
import by.home.db.IOrderRepository;
import by.home.orderclass.Order;

public class MainController {
	private static IClientCardrepository clientCardRepository=new DBClientCardRepository();
	private static IClientCarRepository clientCarRepository=new DBClientCarRepository();
	private static IOrderRepository orderRepository=new DBOrderRepository();
	private static ClientCardStore clientCardStore = new  ClientCardStore();
	enum Choice{
		ADDCLIENT, FINDCLIENTS, ADDCAR, FINDCARS, EXIT, DELETECAR, CARBYCLIENT,ORDERBYCAR,
		DELETEORDER, FINDORDERS, ADDORDER
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean b=true;
		Set<String> set=new HashSet<String>();
		for(int i=0;i<Choice.values().length;i++){
			set.add(Choice.values()[i].toString());
		}
		
		do{
			System.out.println("To add new client card enter ADDCLIENT ");
			System.out.println("To find all client cards enter FINDCLIENTS ");
			
			System.out.println("To add new car to the client enter ADDCAR ");
			System.out.println("To delete car by id enter DELETECAR ");
			System.out.println("To find all cars  enter FINDCARS ");
			System.out.println("To exit the app  enter EXIT ");
			System.out.println("To find car by client enter  CARBYCLIENT");
			
			System.out.println("To add new order enter ADDORDER");
			System.out.println("To find all orders enter FINDORDERS");
			System.out.println("To delete an order enter DELETEORDER");
			System.out.println("To find  order by car enter ORDERBYCAR");
			
			 Scanner scanner1=new Scanner(System.in);
			 String usertext=scanner1.nextLine();
			// scanner1.close();
			if(set.contains(usertext.toUpperCase())){
			switch(Choice.valueOf(usertext.toUpperCase())){
			
			case ADDCLIENT:{
				Scanner scanner=new Scanner(System.in);
				
				System.out.println("Enter the id of client ");
				
				String stringid=scanner.nextLine();
				int id=Integer.parseInt(stringid);
				
				System.out.println("Enter the name of client ");
				String name=scanner.nextLine();
				//check if client exists!
				System.out.println("Enter the surname of client ");
				String surname=scanner.nextLine();
				
				System.out.println("Enter the date of birth of client ");
				String dateOFBirth=scanner.nextLine();
				
				System.out.println("Enter the date of adress of client ");
				String adress=scanner.nextLine();
				
				System.out.println("Enter the email of client ");
				String email=scanner.nextLine();
				
				System.out.println("Enter the phone number of client ");
				String phoneNumber=scanner.nextLine();
				
				scanner.close();
				
				ClientCard ClientCard=new ClientCard();
				clientCardStore.addToList(ClientCard);
				
				ClientCard.setAdress(adress);
				ClientCard.setDateOfBirth(dateOFBirth);
				ClientCard.setEmail(email);
				ClientCard.setid(id);
				ClientCard.setName(name);
				ClientCard.setSurName(surname);
				ClientCard.setPhoneNumber(phoneNumber);
				
				clientCardRepository.addClientCard(ClientCard);
				//scanner1.close();
				break;
			}
			case FINDCLIENTS:{
				clientCardRepository.findAllClientCards();
				
				
			}
			break;
			case DELETECAR:{
				Scanner deletescanner=new Scanner(System.in);
				
				System.out.println("Enter the id of car ");
				
				String stringid=deletescanner.nextLine();
				int carId=Integer.parseInt(stringid);
				
				clientCarRepository.deleteCarById(carId);
				//deletescanner.close();
			}
			break;
			case CARBYCLIENT:{
				Scanner carIdScanner=new Scanner(System.in);
				
				System.out.println("Enter the id of client ");
				
				String stringid=carIdScanner.nextLine();
				int clientId=Integer.parseInt(stringid);
				
				clientCarRepository.findCarByClient(clientId);
			}
			break;
			
			case FINDCARS:{
				clientCarRepository.findAllCars();
			}
			break;
			
			case ADDORDER:{
				Scanner orderscanner=new Scanner(System.in);
				
				System.out.println("Enter the date of order ");
				String date=orderscanner.nextLine();
				
				System.out.println("Enter the orderamount ");
				String oAmount=orderscanner.nextLine();
				
				System.out.println("Enter the orderstatus ");
				String oStatus=orderscanner.nextLine();
				
				System.out.println("Enter the carId");
				
				String carId=orderscanner.nextLine();
				int cId=Integer.parseInt(carId);
				
				Order order=new Order();
				order.setDate(date);
				order.setOrderAmount(oAmount);
				order.setOrderStatus(oStatus);
				orderRepository.addOrder(order, cId);
				
			}
			break;
			case FINDORDERS:{
				orderRepository.findAllOrderss();
			}
			break;
			
			case DELETEORDER:{
				Scanner deletescanner2=new Scanner(System.in);
				
				System.out.println("Enter the id of car ");
				
				String stringid=deletescanner2.nextLine();
				int carId=Integer.parseInt(stringid);
				orderRepository.deleteOrderById(carId);
			}
			break;
			
			case ORDERBYCAR:{
				Scanner orderIScanner=new Scanner(System.in);
				
				System.out.println("Enter the id of car ");
				
				String stringid=orderIScanner.nextLine();
				int carId=Integer.parseInt(stringid);
				orderRepository.findOrderByCar(carId);
			}
			break;
			case ADDCAR:{
				
				Scanner carscanner=new Scanner(System.in);
				
				System.out.println("Enter the id of car ");
				String carUserId=carscanner.nextLine();
				int carIDs=Integer.parseInt(carUserId);
				
				System.out.println("Enter the Manufacturer of the car ");
				String carManufacturer=carscanner.nextLine();
				
				System.out.println("Enter the Model of the car ");
				String carModel=carscanner.nextLine();
				
				System.out.println("Enter the year of production ");
				String carYear=carscanner.nextLine();
				
				System.out.println("Enter id of car owner");
				
				String clientId=carscanner.nextLine();
				int clId=Integer.parseInt(clientId);
				
			//	carscanner.close();
				
				ClientCar clientcar=new ClientCar();
				
				clientcar.setid(carIDs);
				clientcar.setManufacture(carManufacturer);
				clientcar.setModel(carModel);
				clientcar.setYear(carYear);
				
				clientCarRepository.addClientCar(clientcar, clId);
				
				
				
			}
			break;
			case EXIT:{
				b=false;
			}
			}
			
		//	scanner.close();
			
			
		}else{
			System.out.println("Enter a correct command!");
		}
	}while(b);

}
}
