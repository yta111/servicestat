package by.home.clientcardclass;

public class ClientCard {

		private int id;
		private String name;
		private String surname;
		private String dateOfBirth;
		private String adress;
		private String email;
		private String phoneNumber;
		
		public void setid(int id){
			this.id=id;
		}
		public int getId(){
			return id;
		}
		
		public void setName(String name){
			this.name=name;
		}
		public String getName(){
			return name;
		}
		
		public void setSurName(String surname){
			this.surname=surname;
		}
		public String getSurName(){
			return surname;
		}
		
		public void setDateOfBirth(String date){
			this.dateOfBirth=date;
		}
		public String getDateOfBirth(){
			return dateOfBirth;
		}
		
		public void setAdress(String adress){
			this.adress=adress;
		}
		public String getAdress(){
			return adress;
		}
		
		public void setPhoneNumber(String phoneNumber){
			this.phoneNumber=phoneNumber;
		}
		public String getPhoneNumber(){
			return phoneNumber;
		}
		
		public void setEmail(String email){
			this.email=email;
		}
		public String getEmail(){
			return email;
		}
		
		public String toString(){
			return name+" "+surname+" "+dateOfBirth+" "+adress+" "+phoneNumber+" "+email;
		}
}
