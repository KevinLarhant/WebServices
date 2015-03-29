package epsi.webservices.rest;

import epsi.webservices.beans.Product;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pierre on 28/03/2015.
 */
@RestController
@RequestMapping(value="/product")
public class ProductService {


    @RequestMapping(value="/getProducts",method= RequestMethod.GET)
    public String getProducts () {

        JSONObject json = new JSONObject();

        System.out.println("ff");
        return "Coucou";

    }



}
