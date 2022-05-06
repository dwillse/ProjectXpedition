public class Location 

{
    private double latitude;
    private double longitude;
    
    public Location(double la, double lo)
    {
        this.latitude = la;
        this.longitude = lo;
    }

    public double getLatitude() {
        return latitude;
    }
        
        
    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    public String toString(){
        return "Latitude: " + latitude + "\nLongitude: " + longitude;
    }
    
}
