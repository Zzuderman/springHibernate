package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarService {
    void add(Car car); //Для создания только таблицы с машинами
    List<Car> carsList();// Для вывода списка машин
}
