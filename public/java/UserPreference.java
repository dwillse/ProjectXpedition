import java.util.ArrayList;
//This class has 5 arraylists full of the different tags for each rating the user put in
public class UserPreference {
    ArrayList<String> fiveStar = new ArrayList<>();
	ArrayList<String> fourStar = new ArrayList<>();
	ArrayList<String> threeStar = new ArrayList<>();
	ArrayList<String> twoStar = new ArrayList<>();
	ArrayList<String> oneStar = new ArrayList<>();
	

	public UserPreference(ArrayList<String> five, ArrayList<String> four, ArrayList<String> three, ArrayList<String> two, ArrayList<String> one)
	{
		fiveStar = five;
		fourStar = four;
		threeStar = three;
		twoStar = two;
		oneStar = one;
	}


    public ArrayList<String> getFiveStar() {
        return fiveStar;
    }


    public void setFiveStar(ArrayList<String> fiveStar) {
        this.fiveStar = fiveStar;
    }


    public ArrayList<String> getFourStar() {
        return fourStar;
    }


    public void setFourStar(ArrayList<String> fourStar) {
        this.fourStar = fourStar;
    }


    public ArrayList<String> getThreeStar() {
        return threeStar;
    }


    public void setThreeStar(ArrayList<String> threeStar) {
        this.threeStar = threeStar;
    }


    public ArrayList<String> getTwoStar() {
        return twoStar;
    }


    public void setTwoStar(ArrayList<String> twoStar) {
        this.twoStar = twoStar;
    }


    public ArrayList<String> getOneStar() {
        return oneStar;
    }


    public void setOneStar(ArrayList<String> oneStar) {
        this.oneStar = oneStar;
    }

    
}
