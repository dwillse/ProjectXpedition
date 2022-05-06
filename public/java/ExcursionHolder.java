public class ExcursionHolder {
    
    String country;
    String excursion;
    String tag;
    String lat;
    String longit;
    String website;
    String description;
    String review;

    public ExcursionHolder(String country, String excursion, String tag, String lat, String longit, String website, String description, String review) {
        this.country = country;
        this.excursion = excursion;
        this.tag = tag;
        this.lat = lat;
        this.longit = longit;
        this.website = website;
        this.description = description;
        this.review = review;
    }

    public ExcursionHolder() {
    }

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongit() {
        return longit;
    }

    public void setLongit(String longit) {
        this.longit = longit;
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "ExcursionHolder{" + "country=" + country + ", excursions=" + excursion + ", tag=" + tag + ", lat=" + lat + ", longit=" + longit + ", website=" + website + ", description=" + description + ", review=" + review + '}';
    }

    

    

}

