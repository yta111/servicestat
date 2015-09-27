package by.home.db;

import by.home.clientcarclass.ClientCar;


public interface IClientCarRepository {
	public void addClientCar(ClientCar car, int clientid);
	public void findAllCars();
	public void deleteCarById(int carId);
	public void findCarByClient(int clientId);
}
