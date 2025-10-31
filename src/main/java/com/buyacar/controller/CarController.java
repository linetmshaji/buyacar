package com.buyacar.controller;

import com.buyacar.dto.CarRequestDTO;
import com.buyacar.dto.CarResponseDTO;
import com.buyacar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    /** -----------------------------
     *  🔹 Get all cars
     *  ----------------------------- */
    @GetMapping
    public ResponseEntity<List<CarResponseDTO>> getAllCars() {
        List<CarResponseDTO> cars = carService.getAllCars();
        if (cars.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }

    /** -----------------------------
     *  🔹 Get car by ID
     *  ----------------------------- */
    @GetMapping("/{id}")
    public ResponseEntity<CarResponseDTO> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    /** -----------------------------
     *  🔹 Create new car
     *  ----------------------------- */
    @PostMapping
    public ResponseEntity<CarResponseDTO> createCar(@RequestBody CarRequestDTO carRequestDTO) {
        CarResponseDTO savedCar = carService.saveCar(carRequestDTO);
        return ResponseEntity.ok(savedCar);
    }

    /** -----------------------------
     *  🔹 Update car
     *  ----------------------------- */
    @PutMapping("/{id}")
    public ResponseEntity<CarResponseDTO> updateCar(
            @PathVariable Long id,
            @RequestBody CarRequestDTO carRequestDTO) {
        CarResponseDTO updatedCar = carService.updateCar(id, carRequestDTO);
        return ResponseEntity.ok(updatedCar);
    }

    /** -----------------------------
     *  🔹 Delete car
     *  ----------------------------- */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }

    /** -----------------------------
     *  🔹 Filter cars with pagination
     *  ----------------------------- */
    @GetMapping("/filter")
    public ResponseEntity<Page<CarResponseDTO>> filterCars(
            @RequestParam(required = false) Long brandId,
            @RequestParam(required = false) Long fuelTypeId,
            @RequestParam(required = false) Long transmissionId,
            @RequestParam(required = false) Long colorId,
            @RequestParam(required = false) Long bodyTypeId,
            @RequestParam(required = false) Long seatingCapacityId,
            @RequestParam(required = false) Integer minYear,
            @RequestParam(required = false) Integer maxYear,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Double minMileage,
            @RequestParam(required = false) Double maxMileage,
            @RequestParam(required = false) Double minEngineCapacity,
            @RequestParam(required = false) Double maxEngineCapacity,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<CarResponseDTO> filteredCars = carService.filterCars(
                brandId, fuelTypeId, transmissionId, colorId, bodyTypeId, seatingCapacityId,
                minYear, maxYear, minPrice, maxPrice, minMileage, maxMileage,
                minEngineCapacity, maxEngineCapacity, page, size
        );

        if (filteredCars.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(filteredCars);
    }
}
