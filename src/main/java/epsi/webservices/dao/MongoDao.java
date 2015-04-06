package epsi.webservices.dao;

import com.mongodb.*;
import epsi.webservices.beans.Product;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MongoDao implements ServletContextListener {
    private static Logger log = Logger.getLogger(MongoDao.class);

    private static MongoClient mongo;
    private static DB db;
    private static DBCollection collectionProducts;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            mongo = new MongoClient();
        } catch (UnknownHostException e) {
            log.error(e.getMessage());
        }

        db = mongo.getDB("ArchiWeb");

        collectionProducts = db.getCollection("produits");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        mongo.close();
    }

    public static void insert(DBObject dbo, String collectionName) {
        log.info("Insertion : "+dbo.toString()+", dans la collection : "+collectionName);
        db.getCollection(collectionName).insert(dbo);
    }

    public static void remove(DBObject dbo, String collectionName) {
        log.info("Delete : "+dbo.toString()+", dans la collection : "+collectionName);
        db.getCollection(collectionName).remove(dbo);
    }

    public static List<DBObject> getAllProduct() {
        DBCursor cursor = collectionProducts.find();

        List<DBObject> dbListProduct = new ArrayList<>();

        while(cursor.hasNext()) {
            dbListProduct.add(cursor.next());
        }

        return dbListProduct;
    }

    public static DBObject getProduct(int id) {
        DBCursor cursor = collectionProducts.find(new BasicDBObject().append("id", id));

        DBObject dbo = null;

        //il y'a 1 object au maximum
        while(cursor.hasNext()) {
            return cursor.next();
        }

        //remplacer par une erreur?
        return null;
    }

    public static List<DBObject> find(DBObject dbo, String collectionName) {
        List<DBObject> listResult = new ArrayList<>();

        DBCursor cursor = db.getCollection(collectionName).find(dbo);

        while(cursor.hasNext()) {
            listResult.add(cursor.next());
        }

        return listResult;
    }

}
