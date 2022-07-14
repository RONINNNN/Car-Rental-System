package lk.spring.controller;

import lk.spring.dto.CustomerDTO;
import lk.spring.dto.VehicleTypeDTO;
import lk.spring.service.VehicleTypeService;
import lk.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle_type")
@CrossOrigin
public class VehicleTypeController {
    @Autowired
    VehicleTypeService vehicleTypeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveVehicleType(@ModelAttribute VehicleTypeDTO vehicleTypeDTO) {
        vehicleTypeService.saveVehicleType(vehicleTypeDTO);
        return new ResponseUtil(200, "Saved", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteVehicleType(@RequestParam String id) {
        vehicleTypeService.deleteVehicleType(id);
        return new ResponseUtil(200, "Deleted", null);
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateVehicleType(@RequestBody VehicleTypeDTO vehicleTypeDTO) {
        vehicleTypeService.updateVehicleType(vehicleTypeDTO);
        return new ResponseUtil(200, "Updated", null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchVehicleTye(@PathVariable String id) {
        return new ResponseUtil(200, "Ok", vehicleTypeService.searchVehicleType(id));

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllVehicleType(){
        return new ResponseUtil(200, "Ok", vehicleTypeService.getAllVehicleType());
    }

}
