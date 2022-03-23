import java.util.*;

//Main method class so we can run/test
public class Main {
    
    public static void main(String args[]){

        //currently instantiating an arraylist based off the excursion class
        //will need to change later
        ArrayList<Excursion> excursionArray = new ArrayList();

        /*
        Excursion test = new Excursion("Japan", "Hiking", new Location(35.3606, 138.7274),
        new Tag("Mountain"), "www.mtfuji.com", "Japan's Mt. Fuji is an active volcano about 100 kilometers southwest of Tokyo",
        4.6);
        */

        //creating 10 sample excursions
        Excursion exc1 = new Excursion("England", "The Broads", new Location(52.6049, 1.6089),
        new Tag("park"), "www.thebroads.com", "There Broads is a network of mostly navigable rivers and lakes in the English counties of Norfolk and Suffolk.",
        4.7);
        Excursion exc2 = new Excursion("England", "Dartmoor National Park", new Location(50.5719, 3.9207),
        new Tag("park"), "www.dartmoor.com", "Dartmoor National Park is a vast moorland in the county of Devon, in southwest England.",
        4.8);
        Excursion exc3 = new Excursion("England", "Royal Obervatory Greenwich", new Location(51.4769, 0.0005), new Tag("museum"), "www.royalobservatory.com", "The Royal Observatory, Greenwich is an observatory situated on a hill in Greenwich Park in south east London.", 4.5);
        Excursion exc4 = new Excursion("England", "The British Museum", new Location(51.5194, 0.1270), new Tag("museum"), "www.britishmuseum.com", "The British museum is a pubilc museum dedicated to human history, art and culture.", 4.7);
        Excursion exc5 = new Excursion("England", "Windosor Castle", new Location(51.4839, 0.6044), new Tag("castle"), "www.winsorcastle.com", "Windsor castle is a royal residence at Windsor in the English country of Berkshire.", 4.6);
        Excursion exc6 = new Excursion("England", "Warwick Castle", new Location(52.2792, 1.5852), new Tag("castle"), "www.warwickcastle.com", "Warwick castle is a medieval castle developed from a wooden fort, originally built by William the Conqueror during 1068", 4.5);
        Excursion exc7 = new Excursion("England", "Chester Zoo", new Location(53.2273, 2.8844), new Tag("zoo"), "www.chesterzoo.com", "Chester Zoo is a zoo at Upton-by-Chester, Cheshire, England.", 4.7);
        Excursion exc8 = new Excursion("England", "ZSL London Zoo", new Location(51.5353, 0.1534), new Tag("zoo"), "www.zsllondon.com", "London Zoo is the world's oldest scientific zoo.", 4.3);
        Excursion exc9 = new Excursion("England", "Bournemouth Beach", new Location(50.7190, 1.8512), new Tag("beach"), "www.bournemouthbeach.com", "Sandy stretch with amusement arcades on 2 piers & backed by cliffside gardens & terrace restaurants.", 4.6);
        Excursion exc10 = new Excursion("England", "Fistral Beach", new Location(50.4165, 5.1002), new Tag("beach"), "www.fistralbeach.com", "Fistral Beach is in Fistral Bay on the north coast of Cornwall, England, United Kingdom.", 4.7);

        //adding sample excursions into excursion Array
        excursionArray.add(exc1);
        excursionArray.add(exc2);
        excursionArray.add(exc3);
        excursionArray.add(exc4);
        excursionArray.add(exc5);
        excursionArray.add(exc6);
        excursionArray.add(exc7);
        excursionArray.add(exc8);
        excursionArray.add(exc9);
        excursionArray.add(exc10);

        //creating arrays for sample user
        ArrayList<Tag> prefArray1 = new ArrayList<>();
        ArrayList<Tag> prefArray2 = new ArrayList<>();
        ArrayList<Tag> prefArray3 = new ArrayList<>();
        ArrayList<Tag> prefArray4 = new ArrayList<>();
        ArrayList<Tag> prefArray5 = new ArrayList<>();
        prefArray1.add(new Tag("park"));
        prefArray2.add(new Tag("museum"));
        prefArray3.add(new Tag("zoo"));
        prefArray4.add(new Tag("beach"));
        prefArray5.add(new Tag("castle"));

        //creating a sample user
        UserPreference user = new UserPreference(prefArray5, prefArray4, prefArray3, prefArray2, prefArray1);

        Algorithm.CallAlgorithim(user, excursionArray);
        //System.out.println(Algorithm.CallAlgorithim(user, excursionArray));



    }
}
