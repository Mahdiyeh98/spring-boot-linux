package ir.mahdiyehrezaei.springcloudservicecar.repository;

import ir.mahdiyehrezaei.springcloudservicecar.domain.CarInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarInfo,Integer> {
    CarInfo findByNameContainingAndColorContaining(String name, String color);
}
