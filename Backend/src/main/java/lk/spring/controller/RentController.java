package lk.spring.controller;

import lk.spring.dto.CustomerDTO;
import lk.spring.dto.RentDto;
import lk.spring.service.RentService;
import lk.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rent")
@CrossOrigin
public class RentController {
    @Autowired
    RentService rentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveRent(@ModelAttribute RentDto rentDto) {
        rentService.saveRent(rentDto);
        return new ResponseUtil(200, "Saved", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteRent(@RequestParam String id) {
        rentService.deleteRent(id);
        return new ResponseUtil(200, "Deleted", null);
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateRent(@RequestBody RentDto rentDto) {
        rentService.updateRent(rentDto);
        return new ResponseUtil(200, "Updated", null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchRent(@PathVariable String id){
        return new ResponseUtil(200, "Ok", rentService.searchRent(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRent(){
        return new ResponseUtil(200, "Ok", rentService.getAllRent());
    }

}
