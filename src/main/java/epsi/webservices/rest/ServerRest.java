package epsi.webservices.rest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/list")
public class ServerRest {

    private static final Logger log = Logger.getLogger(ServerRest.class);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getProduct(@PathVariable("id") int id) {
        log.info("id " + id);

        return "oih";
    }
}
