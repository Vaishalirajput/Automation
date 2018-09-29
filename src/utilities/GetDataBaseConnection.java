package utilities;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;

import org.bson.*;
import com.mongodb.*;
 

public class GetDataBaseConnection { 
   
/* public static void main( String args[] ) {  
 
      MongoDatabase db = connectToDatabase("10.151.100.119","27018","webqa_minervadb","webqa_minerva","webqa_minerva");
      System.out.println("Connected to the database successfully"); 
      
      //Accessing a collection 
      MongoCollection<Document> userOTP = db.getCollection("userOTP");
      
      //We can user following class to find data: BsonString, BsonInt32, BsonFloat, etc.   
      Iterable<Document> OTP = userOTP.find().sort(Sorts.descending("lastUpdated"));
      System.out.println(OTP.iterator().next().getString("oneTimePassword") + "  total count"); 
      
   } */

	/**
	 * Method to access the database. String parameters are: host, port, dbName, username, password
	 * @param host "localhost"
	 * @param port "27018"
	 * @param dbName "testdb"
	 * @param user "test"
	 * @param password "test"
	 * @return MongoDatabase class object
	 */
   public static MongoDatabase connectToDatabase(String host, String port, String dbName, String user, String password){
	   
	   MongoClientURI connectionString = new MongoClientURI("mongodb://"+user+":"+password+"@"+host+":"+port+"/"+dbName);
	   System.out.print(connectionString.getURI());
	   MongoClient mongoClient = new MongoClient(connectionString);
	   
	   //MongoCollection<Document> userOTP = mongoClient.getDatabase(dbName).getCollection("userOTP");
	   //userOTP.find().sort(Sorts.descending("lastUpdated"));
	   
	   return(mongoClient.getDatabase(dbName));
   }
   
   
   
   
} 