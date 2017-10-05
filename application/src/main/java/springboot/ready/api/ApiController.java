package springboot.ready.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class ApiController {

    /* only needed for swagger documentation */
    @ApiOperation(value = "get person object")

    @CrossOrigin
    @RequestMapping(value = "/api", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> person(
            @RequestParam(value = "firstname", defaultValue = "john") final String firstame,
            @RequestParam(value = "lastname", defaultValue = "doe") final String name) {

        Map<String,String> person = new HashMap<String,String>() {{
            put("firstname", firstame);
            put("name", name);
        }};

        return person;
    }
}
