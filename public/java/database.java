
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
    Tag tags;
    String website;
    String description;
    double reviews;

    public Excursion(String country, String excursion, Location location, Tag tags, String website, String description,
            double reviews) {
        this.country = country;
        this.excursion = excursion;
        this.location = location;
        this.tags = tags;
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
    public Tag getTags() {
        return tags;
    }
    public void setTags(Tag tags) {
        this.tags = tags;
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
    public String toString() {
        return "Excursion [country=" + country + ", description=" + description + ", excursion=" + excursion
                + ", location=" + location + ", reviews=" + reviews + ", tags=" + tags + ", website=" + website + "]";
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
    String tag2;
    String tag3;

    //Multiple constructors based on number of tags needed
    public Tag(String tag1){
        this.tag1 = tag1;
    }

    public Tag(String tag1, String tag2){
        this.tag1 = tag1;
        this.tag2 = tag2;
    }

    public Tag(String tag1, String tag2, String tag3){
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
    }

    public String getTag1() {
        return tag1;
    }
    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }
    public String getTag2() {
        return tag2;
    }
    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }
    public String getTag3() {
        return tag3;
    }
    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }
    public String toString(){
        return "Tag1: " + tag1 + "\nTag2: " + tag2 + "\nTag3: " + tag3;
    }

}