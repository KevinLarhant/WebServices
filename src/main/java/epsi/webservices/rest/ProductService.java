package epsi.webservices.rest;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import epsi.webservices.dao.MongoDao;
import org.apache.log4j.Logger;
import epsi.webservices.beans.Product;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/product")
public class ProductService {

    Logger log = Logger.getLogger(ProductService.class);

    @RequestMapping(value="/getProducts",method=RequestMethod.GET)
    public String getProducts () {
        log.info("List of all products asked");

        //JSONObject json = new JSONObject();
        StringBuilder sb = new StringBuilder();

        List<DBObject> dbListProducts = MongoDao.getAllProduct();

        for(DBObject dbo : dbListProducts) {
            sb.append(dbo.toString());
        }

        return  sb.toString();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getProduct(@PathVariable("id") int id) {
        log.info("id product asked : " + id);

        return MongoDao.getProduct(id).toString();
    }

}
