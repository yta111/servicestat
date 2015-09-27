package by.home.db;

import by.home.orderclass.Order;

public interface IOrderRepository {
	public void addOrder(Order order, int carid);
	public void findAllOrderss();
	public void deleteOrderById(int carId);
	public void findOrderByCar(int carId);
}
