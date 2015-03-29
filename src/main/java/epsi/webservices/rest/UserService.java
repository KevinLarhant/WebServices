package epsi.webservices.rest;

import epsi.webservices.beans.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Pierre on 28/03/2015.
 */
@RestController
@RequestMapping("/user")
public class UserService {

    public String getUser (String userId) {

        JSONObject jsonUser = new JSONObject();
        try {
            jsonUser.append("userName","Pierre");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonUser.toString();
    }
}
