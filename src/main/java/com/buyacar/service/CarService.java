package com.buyacar.service;

import com.buyacar.dto.CarRequestDTO;
import com.buyacar.dto.CarResponseDTO;
import com.buyacar.exception.ResourceNotFoundException;
import com.buyacar.model.Brand;
import com.buyacar.model.Car;
import com.buyacar.model.LookUp;
import com.buyacar.repository.BrandRepository;
import com.buyacar.repository.CarRepository;
import com.buyacar.repository.LookUpRepository;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private LookUpRepository lookUpRepository;

    private static final Logger logger = LoggerFactory.getLogger(CarService.class);

    /**
     * ✅ Get all cars (no filters)
     */
    public List<CarResponseDTO> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(CarResponseDTO::new)
                .toList();
    }

    /**
     * ✅ Get a car by ID
     */
    public CarResponseDTO getCarById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id " + id));
        return new CarResponseDTO(car);
    }

    /**
     * ✅ Create a new car
     */
    @Transactional
    public CarResponseDTO saveCar(CarRequestDTO carRequestDTO) {
        logger.info("Inside saveCar ");
        Car car = mapRequestToEntity(new Car(), carRequestDTO);
        Car savedCar = carRepository.save(car);
        return new CarResponseDTO(savedCar);
    }

    /**
     * ✅ Update existing car
     */
    @Transactional
    public CarResponseDTO updateCar(Long id, CarRequestDTO updatedCarDTO) {
        Car existingCar = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id " + id));

        Car updatedCar = mapRequestToEntity(existingCar, updatedCarDTO);
        Car savedCar = carRepository.save(updatedCar);
        return new CarResponseDTO(savedCar);
    }

    /**
     * ✅ Delete a car by ID
     */
    @Transactional
    public void deleteCarById(Long id) {
        if (!carRepository.existsById(id)) {
            throw new ResourceNotFoundException("Car not found with given id " + id);
        }
        carRepository.deleteById(id);
    }

    /**
     * ✅ Filter cars dynamically with pagination
     */
    public Page<CarResponseDTO> filterCars(Long brandId, Long fuelTypeId, Long transmissionId,
                                           Long colorId, Long bodyTypeId, Long seatingCapacityId,
                                           Integer minYear, Integer maxYear,
                                           Double minPrice, Double maxPrice,
                                           Double minMileage, Double maxMileage,
                                           Double minEngineCapacity, Double maxEngineCapacity,
                                           int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Specification<Car> spec = (root, query, cb) -> {
            List<Predicate> filters = new ArrayList<>();

            if (brandId != null)
                filters.add(cb.equal(root.get("brand").get("id"), brandId));
            if (fuelTypeId != null)
                filters.add(cb.equal(root.get("fuelType").get("id"), fuelTypeId));
            if (transmissionId != null)
                filters.add(cb.equal(root.get("transmission").get("id"), transmissionId));
            if (colorId != null)
                filters.add(cb.equal(root.get("color").get("id"), colorId));
            if (bodyTypeId != null)
                filters.add(cb.equal(root.get("bodyType").get("id"), bodyTypeId));
            if (seatingCapacityId != null)
                filters.add(cb.equal(root.get("seatingCapacity").get("id"), seatingCapacityId));

            if (minYear != null)
                filters.add(cb.greaterThanOrEqualTo(root.get("year"), minYear));
            if (maxYear != null)
                filters.add(cb.lessThanOrEqualTo(root.get("year"), maxYear));

            if (minPrice != null)
                filters.add(cb.greaterThanOrEqualTo(root.get("price"), minPrice));
            if (maxPrice != null)
                filters.add(cb.lessThanOrEqualTo(root.get("price"), maxPrice));

            if (minMileage != null)
                filters.add(cb.greaterThanOrEqualTo(root.get("mileage"), minMileage));
            if (maxMileage != null)
                filters.add(cb.lessThanOrEqualTo(root.get("mileage"), maxMileage));

            if (minEngineCapacity != null)
                filters.add(cb.greaterThanOrEqualTo(root.get("engineCapacity"), minEngineCapacity));
            if (maxEngineCapacity != null)
                filters.add(cb.lessThanOrEqualTo(root.get("engineCapacity"), maxEngineCapacity));

            return cb.and(filters.toArray(new Predicate[0]));
        };

        Page<Car> carPage = carRepository.findAll(spec, pageable);
        return carPage.map(CarResponseDTO::new);
    }

    /**
     * ✅ Reusable Lookup Fetcher
     */
    private LookUp getLookUpDtlsById(Long id, String type) {
        return lookUpRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(type + " not found with id " + id));
    }

    /**
     * ✅ Utility: Map DTO to Entity (for create/update)
     */
    private Car mapRequestToEntity(Car car, CarRequestDTO dto) {

        car.setModel(dto.getName());
        car.setYear(dto.getYear());
        car.setPrice(dto.getPrice());
        car.setMileage(dto.getMileage());
        car.setEngineCapacity(dto.getEngineCapacity());

        car.setFuelType(getLookUpDtlsById(dto.getFuelTypeId(), "FuelType"));
        car.setTransmission(getLookUpDtlsById(dto.getTransmissionId(), "Transmission"));
        car.setColor(getLookUpDtlsById(dto.getColorId(), "Color"));
        car.setBodyType(getLookUpDtlsById(dto.getBodyTypeId(), "BodyType"));
        car.setSeatingCapacity(getLookUpDtlsById(dto.getSeatingCapacityId(), "SeatingCapacity"));
        car.setBrand(brandRepository.findById(dto.getBrandNameId())
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found with id " + dto.getBrandNameId())));
        return car;
    }
}
