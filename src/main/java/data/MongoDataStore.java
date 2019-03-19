/*
*
*   Used to access a mongo database
*
*
*
*
*/
package data;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.MongoClientURI;
import org.bson.Document;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;
import model.Member;
import model.MemberList;

/*   some data inserts  for member data
    private Long id ,  String name, String email String phoneNumber ,String urlstr;
    db.member.insertMany([
   { id:1, name:"Bert", email:"bertb@gmail.com", phoneNumber:"01273123456",  urlstr:"www.bbc.co.uk" },
   { id:1, name:"Fred", email:"Fredb@gmail.com", phoneNumber:"01273123457",  urlstr:"www.bbc.com" },
   { id:1, name:"Cyril", email:"Cyrilb@gmail.com", phoneNumber:"01273123458",  urlstr:"www.google.co.uk" }
    ])
*/

public class MongoDataStore {

/* create this class logger */
  private static final Logger mdslogger = Logger.getLogger(MongoDataStore.class.getName());


  public MongoCollection<Document> getMongoCollection(String membercolstr){

      /* database connection code to be moved into other function */
      MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
      // azure connection string
      // "mongodb://brynburson:lGq0uXmMh2GFAuHEW3rDsi74vziiDM5VZfKuSMXLu3dyQ3h0rqoQWMOwOlCZjax8wKpACQMn7dCSfD4PW7wbXw==@brynburson.documents.azure.com:10255/?ssl=true&replicaSet=globaldb"


      MongoDatabase database = mongoClient.getDatabase("bbdb");
      MongoCollection<Document> coll = database.getCollection(membercolstr);

      return coll;
  }


  public void insertMemberRecordsToDb() {

      int mbrsnum;

      mdslogger.info("MongodDataStore:connectToDb");

      /* get Member collection */
      MongoCollection<Document> coll = getMongoCollection("member");
      // get documents array
      List<Document> documents = new ArrayList<Document>();

      // get current member list from singleton instance
      MemberList ml = new MemberList();
      List<Member> mbrs = new ArrayList<Member>();
      mbrs = ml.getMembers();
      mbrsnum = mbrs.size();

      for(int x=0; x< mbrsnum; x++){
          mdslogger.info("MongodDataStore:connectToDb member:(" + x + ") name is:" + mbrs.get(x).getName());
          // insert a member document
          Document doc = new Document("id","5")
              .append("name",mbrs.get(x).getName())
              .append("email",mbrs.get(x).getEmail())
              .append("phoneNumber",mbrs.get(x).getPhoneNumber())
              .append("urlstr",mbrs.get(x).getBburlstr());
          documents.add(doc);
      }
      coll.insertMany(documents);
  }

  public void deleteMemberRecordsFromDb() {

        mdslogger.info("MongodDataStore:connectToDb");

        /* get Member collection */
        MongoCollection<Document> membercoll = getMongoCollection("member");

        /* delete specfic member records from the db  */
   //  to be looked up *******     coll.deleteMany(??)

  }

  public void getMemberRecordsFromDb() {

      int noofdocs =0;
      int x=0;

      mdslogger.info("MongodDataStore:getMemberRecordsFromDb");
      /* get Member collection */
      MongoCollection<Document> coll = getMongoCollection("member");

      /* get records into documents array */
      List<Document> documents = (List<Document>) coll.find().into(new ArrayList<Document>());

      // get member list instance ready for insertion and Empty before retrieving form DB
      MemberList ml = new MemberList();
      ml.deleteAllMembers();

      noofdocs = documents.size();

      for(x=0; x<noofdocs; x++){
          mdslogger.info("Doc(" + x + ")" +  documents.get(x));

      }

  }


}
