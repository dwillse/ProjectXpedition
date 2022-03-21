
import java.util.*;

//The database class will eventually pull information from SQL to make a list of excursions for the algorithm to work on
public class database 
{

    ArrayList<Excursion> excursionArray = new ArrayList<>();

}


// This is all the information we need for each individual excursion



class Excursion
{
    String name;
    String excursion;
    Location location;
    Tag tags;
    String website;
    String description;
    double reviews;
    
}


//This class is used to tag each excursion with certain values
class Tag
{
    


}


//This class is used to find the location of an excursion in the real world using lat and long
class Location 
{
    private double latitude;
    private double longitude;
    
    public Location(double la, double lo)
    {
        this.latitude = la;
        this.longitude = lo;
    }

    private double getLatitude() {
        return latitude;
    }

    private double getLongitude() {
        return longitude;
    }

    private void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    private void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    

/*public class Database {
    String country;
    String excursion;
    Location location;
    String website;
    String description;
    double reviews;
    //couldn't remember if we decided on anything for tags so
    //I'm just putting it here as a placeholder
    String[] tags;
>>>>>>> 896f386d662b357eae8b252c26df8b0524bf247b
}
*/