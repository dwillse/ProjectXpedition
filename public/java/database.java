

public class database 
{
    String name;
    String excursion;
    Location location;
    String[] tags;
    String website;
    String description;
    double reviews;
    
}



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
    
    
}
