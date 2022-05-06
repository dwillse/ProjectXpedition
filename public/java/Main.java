import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import org.bson.Document;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
                
        //Codec registry for using custom objects
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        //building mongo client connection and getting the xpedition database
        MongoClientSettings settings = MongoClientSettings.builder()
            .codecRegistry(pojoCodecRegistry)
            .build();
        MongoClient client = MongoClients.create(settings);
        MongoDatabase database = client.getDatabase("Xpedition");
        
        
        //grabbing each collection needed for the program from MongoDB
        MongoCollection<Document> preferences = database.getCollection("preferences");
        MongoCollection<ExcursionHolder> excursions = database.getCollection("excursions", ExcursionHolder.class);
        MongoCollection<Document> itinerary = database.getCollection("itineraries");
        MongoCollection<Document> excursions2 = database.getCollection("excursions");
        
        //getting the users passed in id and storing to a userId object
        ObjectId userId = new ObjectId(args[0]);
        
        
        //creating new arraylist to hold the excursion collection and a list to hold the list of excursions
        ArrayList<ExcursionHolder> holder = new ArrayList<>();
        ArrayList<Excursion> exList = new ArrayList<>();
        
        //puts the excursions collection into a holder arraylist to be used to transfer to the final list
        excursions.find(new Document(), ExcursionHolder.class).into(holder);
        
        //turns the list of excursion objects from the mongo collection into an arraylist to be passed to the algorithm
        for (int i = 0; i < holder.size(); i++) {
            exList.add(new Excursion(holder.get(i).getCountry(), holder.get(i).getExcursion(), new Location(Double.parseDouble(holder.get(i).getLat()),
                    Double.parseDouble(holder.get(i).getLongit())), holder.get(i).getTag(), holder.get(i).getWebsite(), holder.get(i).getDescription(), Double.parseDouble(holder.get(i).getReview())));
        }
        

        //creating all arrayLists to hold user preferences
        ArrayList<String> prefArray1 = new ArrayList<>();
        ArrayList<String> prefArray2 = new ArrayList<>();
        ArrayList<String> prefArray3 = new ArrayList<>();
        ArrayList<String> prefArray4 = new ArrayList<>();
        ArrayList<String> prefArray5 = new ArrayList<>();
                
        //Takes in the remaining arguments passed(preference names) and adds them to the correct preference arraylist based on thier star rating
        for (int i = 1; i < args.length; i++) {
            String arg = args[i];
            
            //Since a preference document in the preference collection holds a user's id this searches for that preference document using the userId
            Document userPrefs = preferences.find(new Document("userName", userId)).first();
            //Accesses the preference data inside the preference document
            Document prefs = (Document) userPrefs.get("chosen");
            String p = (String) prefs.get(arg);
            int x = Integer.parseInt(p);
            switch(x){
                case 1:
                    prefArray1.add(arg);
                    break;
                case 2:
                    prefArray2.add(arg);
                    break;
                case 3:
                    prefArray3.add(arg);
                    break;
                case 4:
                    prefArray4.add(arg);
                    break;
                case 5:
                    prefArray5.add(arg);
                    break;
                default:
                    break;
            }
        }
        
        //Test to see whats in each pref array
        System.out.println(prefArray5);
        System.out.println(prefArray4);
        System.out.println(prefArray3);
        System.out.println(prefArray2);
        System.out.println(prefArray1);
        
        //creating a user object to be passed to the algorithm
        UserPreference user = new UserPreference(prefArray5, prefArray4, prefArray3, prefArray2, prefArray1);

        //Call Algorithm here(would run exactly like normal)
        ArrayList<Excursion> finalList = Algorithm.CallAlgorithim(user, exList);
        
        

        //Store Algorithm's return to MongoDB here
        //If there are not enough things recommended returns a document with less excursions
        switch (finalList.size()) {
            case 5:
                {
                    Document excurs = new Document("excursion1", excursions2.find(new Document("excursion", finalList.get(0).getExcursion())).first().getObjectId("_id"))
                            .append("excursion2", excursions2.find(new Document("excursion", finalList.get(1).getExcursion())).first().getObjectId("_id"))
                            .append("excursion3", excursions2.find(new Document("excursion", finalList.get(2).getExcursion())).first().getObjectId("_id"))
                            .append("excursion4", excursions2.find(new Document("excursion", finalList.get(3).getExcursion())).first().getObjectId("_id"))
                            .append("excursion5", excursions2.find(new Document("excursion", finalList.get(4).getExcursion())).first().getObjectId("_id"))
                            .append("userName", userId);
                    itinerary.insertOne(excurs);
                    break;
                }
            case 4:
                {
                    Document excurs = new Document("excursion1", excursions2.find(new Document("excursion", finalList.get(0).getExcursion())).first().getObjectId("_id"))
                            .append("excursion2", excursions2.find(new Document("excursion", finalList.get(1).getExcursion())).first().getObjectId("_id"))
                            .append("excursion3", excursions2.find(new Document("excursion", finalList.get(2).getExcursion())).first().getObjectId("_id"))
                            .append("excursion4", excursions2.find(new Document("excursion", finalList.get(3).getExcursion())).first().getObjectId("_id"))
                            .append("userName", userId);
                    itinerary.insertOne(excurs);
                    break;
                }
            case 3:
                {
                    Document excurs = new Document("excursion1", excursions2.find(new Document("excursion", finalList.get(0).getExcursion())).first().getObjectId("_id"))
                            .append("excursion2", excursions2.find(new Document("excursion", finalList.get(1).getExcursion())).first().getObjectId("_id"))
                            .append("excursion3", excursions2.find(new Document("excursion", finalList.get(2).getExcursion())).first().getObjectId("_id"))
                            .append("userName", userId);
                    itinerary.insertOne(excurs);
                    break;
                }
            case 2:
                {
                    Document excurs = new Document("excursion1", excursions2.find(new Document("excursion", finalList.get(0).getExcursion())).first().getObjectId("_id"))
                            .append("excursion2", excursions2.find(new Document("excursion", finalList.get(1).getExcursion())).first().getObjectId("_id"))
                            .append("userName", userId);
                    itinerary.insertOne(excurs);
                    break;
                }
            case 1:
                {
                    Document excurs = new Document("excursion1", excursions2.find(new Document("excursion", finalList.get(0).getExcursion())).first().getObjectId("_id"))
                            .append("userName", userId);
                    itinerary.insertOne(excurs);
                    break;
                }
            default:
                break;
        }

        
    }
    
}
