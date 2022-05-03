import java.util.*;
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


//Main method class so we can run/test
public class Main {
    
    public static void main(String args[]){

        //Codec registry for using custom objects
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        //building mongo client connection and getting the xpedition database
        MongoClientSettings settings = MongoClientSettings.builder()
            .codecRegistry(pojoCodecRegistry)
            .build();
        MongoClient client = MongoClients.create(settings);
        MongoDatabase database = client.getDatabase("Xpedition");
        
        
        //grabbing each collection needed for the program 
        MongoCollection<PreferenceHolder> preferences = database.getCollection("preferences", PreferenceHolder.class);
        MongoCollection<ExcursionHolder> excursions = database.getCollection("excursions", ExcursionHolder.class);
        MongoCollection<Document> itinerary = database.getCollection("itinerary");
        
        /*
        * Old hard-coded sample excursions
        *
        Excursion exc1 = new Excursion("England", "The Broads", new Location(52.6049, 1.6089),
        "park", "www.thebroads.com", "There Broads is a network of mostly navigable rivers and lakes in the English counties of Norfolk and Suffolk.",
        4.7);
        Excursion exc2 = new Excursion("England", "Dartmoor National Park", new Location(50.5719, 3.9207),
        "park", "www.dartmoor.com", "Dartmoor National Park is a vast moorland in the county of Devon, in southwest England.",
        4.8);
        Excursion exc3 = new Excursion("England", "Royal Obervatory Greenwich", new Location(51.4769, 0.0005), "museum", "www.royalobservatory.com", "The Royal Observatory, Greenwich is an observatory situated on a hill in Greenwich Park in south east London.", 4.5);
        Excursion exc4 = new Excursion("England", "The British Museum", new Location(51.5194, 0.1270), "museum", "www.britishmuseum.com", "The British museum is a pubilc museum dedicated to human history, art and culture.", 4.7);
        Excursion exc5 = new Excursion("England", "Windosor Castle", new Location(51.4839, 0.6044), "castle", "www.winsorcastle.com", "Windsor castle is a royal residence at Windsor in the English country of Berkshire.", 4.6);
        Excursion exc6 = new Excursion("England", "Warwick Castle", new Location(52.2792, 1.5852), "castle", "www.warwickcastle.com", "Warwick castle is a medieval castle developed from a wooden fort, originally built by William the Conqueror during 1068", 4.5);
        Excursion exc7 = new Excursion("England", "Chester Zoo", new Location(53.2273, 2.8844), "zoo", "www.chesterzoo.com", "Chester Zoo is a zoo at Upton-by-Chester, Cheshire, England.", 4.7);
        Excursion exc8 = new Excursion("England", "ZSL London Zoo", new Location(51.5353, 0.1534), "zoo", "www.zsllondon.com", "London Zoo is the world's oldest scientific zoo.", 4.3);
        Excursion exc9 = new Excursion("England", "Bournemouth Beach", new Location(50.7190, 1.8512), "beach", "www.bournemouthbeach.com", "Sandy stretch with amusement arcades on 2 piers & backed by cliffside gardens & terrace restaurants.", 4.6);
        Excursion exc10 = new Excursion("England", "Fistral Beach", new Location(50.4165, 5.1002), "beach", "www.fistralbeach.com", "Fistral Beach is in Fistral Bay on the north coast of Cornwall, England, United Kingdom.", 4.7);
        Excursion exc11 = new Excursion("England", "beach", new Location(51.5, .15), "beach", "web", "des", 4.7);
        */

        //creating new arraylist to hold the excursion collection and a list to hold the list of excursions
        ArrayList<ExcursionHolder> holder = new ArrayList<>();
        ArrayList<Excursion> exList = new ArrayList<>();
        
        //puts the excursions collection into a holder arraylist to be used to transfer to the final list
        excursions.find(new Document(), ExcursionHolder.class).into(holder);
        
        //turns the list of excursion objects from the mongo collection into an arraylist to be passed to the algorithm
        for (int i = 0; i < holder.size(); i++) {
            exList.add(new Excursion(holder.get(i).getCountry(), holder.get(i).getExcursion(), new Location(holder.get(i).getLat(),
                    holder.get(i).getLongit()), holder.get(i).getTag(), holder.get(i).getWebsite(), holder.get(i).getDescription(), holder.get(i).getReviews()));
        }
        

        //creating all arrayLists to hold user preferences
        String userName = "Corrin";
        ArrayList<String> prefArray1 = new ArrayList<>();
        ArrayList<String> prefArray2 = new ArrayList<>();
        ArrayList<String> prefArray3 = new ArrayList<>();
        ArrayList<String> prefArray4 = new ArrayList<>();
        ArrayList<String> prefArray5 = new ArrayList<>();
        ArrayList<PreferenceHolder> prefHolder = new ArrayList<>();
        
        //taking the collection of preferences from mongo and putting it into preference arraylist
        preferences.find(new Document(), PreferenceHolder.class).into(prefHolder);
        
        for (int i = 0; i < prefHolder.size(); i++) {
            //making sure name is not null and if it is skips loop iteration
            if(prefHolder.get(i).getUser() == null){
                
            //gets the correct user's name and adds their preferences to the preference arrays that will build the User java object
            }else if(prefHolder.get(i).getUser().equals(userName)){
                 prefArray5.add(prefHolder.get(i).getChosen());
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
        for (int i = 0; i < finalList.size(); i++) {
            Document excurs = new Document("country", finalList.get(i).getCountry())
                                            .append("excursion", finalList.get(i).getExcursion())
                                            .append("tag", finalList.get(i).getTag())
                                            .append("lat", finalList.get(i).getLocation().getLatitude())
                                            .append("longit", finalList.get(i).getLocation().getLongitude())
                                            .append("website", finalList.get(i).getWebsite())
                                            .append("description", finalList.get(i).getDescription())
                                            .append("reviews", finalList.get(i).getReviews());
            
            itinerary.insertOne(excurs);
        }

    }
}
