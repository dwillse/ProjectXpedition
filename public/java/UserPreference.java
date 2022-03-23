import java.util.ArrayList;
//This class has 5 arraylists full of the different tags for each rating the user put in
public class UserPreference {
    ArrayList<Tag> fiveStar = new ArrayList<>();
	ArrayList<Tag> fourStar = new ArrayList<>();
	ArrayList<Tag> threeStar = new ArrayList<>();
	ArrayList<Tag> twoStar = new ArrayList<>();
	ArrayList<Tag> oneStar = new ArrayList<>();
	

	public UserPreference(ArrayList<Tag> five, ArrayList<Tag> four, ArrayList<Tag> three, ArrayList<Tag> two, ArrayList<Tag> one)
	{
		fiveStar = five;
		fourStar = four;
		threeStar = three;
		twoStar = two;
		oneStar = one;
	}


    public ArrayList<Tag> getFiveStar() {
        return fiveStar;
    }


    public void setFiveStar(ArrayList<Tag> fiveStar) {
        this.fiveStar = fiveStar;
    }


    public ArrayList<Tag> getFourStar() {
        return fourStar;
    }


    public void setFourStar(ArrayList<Tag> fourStar) {
        this.fourStar = fourStar;
    }


    public ArrayList<Tag> getThreeStar() {
        return threeStar;
    }


    public void setThreeStar(ArrayList<Tag> threeStar) {
        this.threeStar = threeStar;
    }


    public ArrayList<Tag> getTwoStar() {
        return twoStar;
    }


    public void setTwoStar(ArrayList<Tag> twoStar) {
        this.twoStar = twoStar;
    }


    public ArrayList<Tag> getOneStar() {
        return oneStar;
    }


    public void setOneStar(ArrayList<Tag> oneStar) {
        this.oneStar = oneStar;
    }

    
}
