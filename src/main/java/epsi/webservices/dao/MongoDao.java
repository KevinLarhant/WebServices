package epsi.webservices.dao;

import com.mongodb.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.UnknownHostException;

/**
 * Created by klarhant on 24/03/2015.
 */
public class MongoDao implements ServletContextListener {
    private static Logger log = Logger.getLogger(MongoDao.class);

    private static MongoClient mongo;
    private static DB db;
    private static DBCollection collection;


    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            mongo = new MongoClient();
        } catch (UnknownHostException e) {
            log.error(e.getMessage());
        }

        db = mongo.getDB("ArchiWeb");

        collection = db.getCollection("produits");

        System.out.println("coucou");


    }


    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        mongo.close();
    }

    public void insert(DBObject dbo) {
        collection.insert(dbo);
    }

    public BasicDBList getAllProduct() {
        DBCursor cursor = collection.find();

        BasicDBList dblist = new BasicDBList();

        while(cursor.hasNext()) {
            dblist.add(cursor.next());
        }

        return dblist;
    }
}
