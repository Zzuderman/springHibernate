package hiber.dao;

import hiber.model.Car;

import java.util.List;

public interface CarDao {
    void add(Car car); //Для создания только таблицы с машинами
    List<Car> carsList();// Для вывода списка машин
}
