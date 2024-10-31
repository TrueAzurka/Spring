package web.Service;


import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final List<Car> carList = new ArrayList<>();

    public CarService() {

        carList.add(new Car("Toyota", "Camry", 2020));
        carList.add(new Car("Honda", "Civic", 2019));
        carList.add(new Car("Ford", "Focus", 2018));
        carList.add(new Car("Chevrolet", "Malibu", 2021));
        carList.add(new Car("Nissan", "Altima", 2017));
    }

    public List<Car> getCars(int count) {
        if (count >= carList.size()) {
            return carList;
        }
        return carList.subList(0, count);
    }
}