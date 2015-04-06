package epsi.webservices.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.List;

public class DaoUser {

    private static final String COLLEC_USER = "Utilisateur";
    private static final String LOGIN = "Login";
    private static final String PWD = "Password";

    //TODO : plusieurs users avec mm login
    public static void newUser(String login, String pwd) {
        MongoDao.insert(new BasicDBObject().append("login",login).append("password", pwd), COLLEC_USER);
    }

    public static void deleteUser(String login) {
        MongoDao.remove(new BasicDBObject().append("login",login), COLLEC_USER);
    }

    public static boolean checkCredentials(String login, String pwd) {
        BasicDBObject user = new BasicDBObject().append(LOGIN,login).append(PWD,pwd);

        List<DBObject> listUser = MongoDao.find(user, COLLEC_USER);

        if(listUser.size() == 1) {
            return true;
        }
        return false;
    }
}
