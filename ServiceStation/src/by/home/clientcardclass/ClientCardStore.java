package by.home.clientcardclass;

import java.util.ArrayList;
import java.util.List;

public class ClientCardStore {
	 
	private ArrayList<ClientCard> cliendCardList=new ArrayList<ClientCard>();
	public void addToList(ClientCard cc){
		cliendCardList.add(cc);
	}
	public ArrayList<ClientCard> getClientcardList(){
		return cliendCardList;
	}
}
