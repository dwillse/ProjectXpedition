
import java.util.*;

//The database class will eventually pull information from SQL to make a list of excursions for the algorithm to work on
public class database 
{

    private ArrayList<Excursion> excursionArray = new ArrayList<>();


    public ArrayList<Excursion> getExcursionArray() {
        return excursionArray;
    }

    public void setExcursionArray(ArrayList<Excursion> excursionArray) {
        this.excursionArray = excursionArray;
    }
    
    
    
    

}


// This is all the information we need for each individual excursion
class Excursion
{
    String country;
    String excursion;
    Location location;
    String tag;
    String website;
    String description;
    double reviews;

    public Excursion(String country, String excursion, Location location, String tag, String website, String description,
            double reviews) {
        this.country = country;
        this.excursion = excursion;
        this.location = location;
        this.tag = tag;
        this.website = website;
        this.description = description;
        this.reviews = reviews;
    }


    //generated getters/setters can remove setters if needed
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getExcursion() {
        return excursion;
    }
    public void setExcursion(String excursion) {
        this.excursion = excursion;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getReviews() {
        return reviews;
    }
    public void setReviews(double reviews) {
        this.reviews = reviews;
    }

    @Override
    public java.lang.String toString() {
        return "Excursion [country=" + country + ", description=" + description + ", excursion=" + excursion
                + ", location=" + location + ", reviews=" + reviews + ", tags=" + tag + ", website=" + website + "]";
    }

    
    
    
}


//This class is used to tag each excursion with certain values

/*For the tag class I feel like using a set of 3(max) strings
would be a good way to implement, it would allow for the use of 
something like string1 = castle, string2 = historical. Then we
can just look them up using the stings and some sort of equality 
method later
*/
class Tag
{
    String tag1;
    

    //Multiple constructors based on number of tags needed
    public Tag(String tag1){
        this.tag1 = tag1;
    }

    public String getTag1() {
        return tag1;
    }
    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

}