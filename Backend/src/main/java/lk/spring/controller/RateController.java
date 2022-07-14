package lk.spring.controller;

import lk.spring.dto.CustomerDTO;
import lk.spring.dto.RateDTO;
import lk.spring.service.CustomerService;
import lk.spring.service.RateService;
import lk.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rate")
@CrossOrigin
public class RateController {
    @Autowired
    RateService rateService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveRate(@ModelAttribute RateDTO rateDTO) {
        rateService.saveRate(rateDTO);
        return new ResponseUtil(200, "Saved", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteRate(@RequestParam String id) {
        rateService.deleteRate(id);
        return new ResponseUtil(200, "Deleted", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateRate(@RequestBody RateDTO rateDTO) {
        rateService.updateRate(rateDTO);
        return new ResponseUtil(200, "Updated", null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchRate(@PathVariable String id){
        return new ResponseUtil(200, "Ok", rateService.searchRate(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCRate(){
        return new ResponseUtil(200, "Ok", rateService.getAllRate());
    }


}
