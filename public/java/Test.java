import java.util.*;
import java.util.ArrayList;

//Main method class so we can run/test
class Main {
    
    public static void main(String args[]){
		System.out.println("Printing from Test.java file...\n");

		for(int i = 1; i < args.length - 1; i+= 2) {
			System.out.println("The user's  preference is: " + args[i] + " : " + args[i + 1]);
		}


        //currently instantiating an arraylist based off the excursion class
        //will need to change later
        ArrayList<Excursion> excursionArray = new ArrayList<>();

        /*
        Excursion test = new Excursion("Japan", "Hiking", new Location(35.3606, 138.7274),
        new Tag("Mountain"), "www.mtfuji.com", "Japan's Mt. Fuji is an active volcano about 100 kilometers southwest of Tokyo",
        4.6);
        */

        //creating 10 sample excursions
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
        excursionArray.add(exc11);

        //creating arrays for sample user
        ArrayList<String> prefArray1 = new ArrayList<>();
        ArrayList<String> prefArray2 = new ArrayList<>();
        ArrayList<String> prefArray3 = new ArrayList<>();
        ArrayList<String> prefArray4 = new ArrayList<>();
        ArrayList<String> prefArray5 = new ArrayList<>();
        prefArray1.add("park");
        prefArray2.add("museum");
        prefArray3.add("zoo");
        prefArray4.add("beach");
        prefArray5.add("castle");

        //creating a sample user
        UserPreference user = new UserPreference(prefArray5, prefArray4, prefArray3, prefArray2, prefArray1);

        Algorithm.CallAlgorithim(user, excursionArray);
        //System.out.println(Algorithm.CallAlgorithim(user, excursionArray));



    }
}

//Class which holds our algorithm
class Algorithm {
    //This will be the Method that you actually call to get results
    //TODO fix return type if needed
	public static ArrayList<Excursion> CallAlgorithim (UserPreference user, ArrayList<Excursion> exArray)
	{

		//finds best excursion for the user's highest rated tag
		Excursion startingPoint = getStartingPoint(user, exArray);

		//finds every excursion within fifty miles of the startingpoint excursion
		ArrayList<Excursion> options = AllWithinFifty(startingPoint, exArray);

        ArrayList<Excursion> finalList = new ArrayList<>();
        ArrayList<String> tagsArray = new ArrayList<>();

		/*Adds startingpoint's tag i.e. tag of first excursion recommended, to a list of tags that
		* will not be recommended again
		*/
        tagsArray.add(startingPoint.getTag());

		//adds the 'best excursion' found from getStartingPoint to the final list to be output at the end of the recommendation process
        finalList.add(startingPoint);
        

		/*counter variable that will be used to specify how many time the loop to look for other excursions should run
		* should be default set to 4 since we want to recommend 4 excursions other than startingPoint which has already been
		* recommended
		*/
		int counter = 4;

		//Loop should run 4 times to recommend the remaining 4 excursions and put them into finalList
        for (int i = 0; i < counter; i++) {
            finalList.add(getNextExcursion(user, options, tagsArray));

            tagsArray.add(finalList.get(i+1).getTag());
        }


		//Removes all default excursions that made it through the getNextExcursion method and into the final list
		//Note: Should be 0 removals if there were enough options to satisfy the 5 different tag requirement
		for (int i = 0; i < finalList.size(); i++) {
			if(finalList.get(i).getExcursion().equals("excursion")){
				finalList.remove(i);
				i--;
			}
		}
		
		//Runs a recommendation method to try and recommend the remaining excursions (up to 5)
		//Uses duplicate tags that have been already recommended in finalList
		counter = 5 - finalList.size();
		tagsArray.clear();
		for (int i = 0; i < counter; i++) {
			finalList.add(getNextExcursion(user, options, tagsArray, finalList));
						
			tagsArray.add(finalList.get(i+1).getTag());
		}
		
		//Removes all default excursions that made it through the getNextExcursion method and into the final list
		//Note: Should be 0 removals if there were enough options to satisfy the 5 different tag requirement
		for (int i = 0; i < finalList.size(); i++) {
			if(finalList.get(i).getExcursion().equals("excursion")){
				finalList.remove(i);
				i--;
			}
		}


        //FOR TESTING: REMOVE LATER
        System.out.println("FOR TESTING REMOVE LATER\n");
        for (int i = 0; i < finalList.size(); i++) {
            System.out.println(finalList.get(i).getExcursion());
        }      

        return finalList;
	}

	//This method returns ALL excursions within a 50 mile radius of a different excursion
	private static ArrayList<Excursion> AllWithinFifty(Excursion startingPoint, ArrayList<Excursion> exArray)
	{
		ArrayList<Excursion> withinFifty = new ArrayList<>();

		for(int i = 0; i < exArray.size(); i++)
		{
			if(DistanceFormula(exArray.get(i).getLocation(), startingPoint.getLocation()) < 1)
				withinFifty.add(exArray.get(i));
		}
		return withinFifty;		
	}

	// simple formula to determine distance between two excursions
	private static double DistanceFormula(Location ex1, Location ex2)
	{
		return Math.sqrt((Math.pow(ex2.getLongitude()-ex1.getLongitude(), 2) + (Math.pow(ex2.getLatitude()-ex1.getLatitude(), 2))));
	}

	//Determines the best Excursion for the user based on their preferences and its ratings
	private static Excursion getStartingPoint(UserPreference user, ArrayList<Excursion> exArray)
	{

		Excursion startingPoint = exArray.get(0);
		Boolean firstTime = true;
		ArrayList<String> bestTags = user.getFiveStar();
		

		//this simply goes down the list to make sure their highest ranked list of tags is used
		if(user.getFiveStar().isEmpty())
		{
			if(user.getFourStar().isEmpty())
			{
				if(user.getThreeStar().isEmpty())
				{
					if(user.getTwoStar().isEmpty())
					{
						bestTags = user.getOneStar();
					}
					else
						bestTags = user.getTwoStar();
				}
				else
					bestTags = user.getThreeStar();
			}
			else
				bestTags= user.getFourStar();
		}

		//The simpliest and worst way to find the best tags is just looping 
        //through each array, we love O(n^2), don't remember a way better off the top of my head

		for(int i = 0; i < exArray.size(); i++)
		{
			for(int j = 0; j < bestTags.size(); j++)
			{
                //If I have this correct, if bestTags string is equal to an excursion's tag
                //it passes
				if(bestTags.get(j).equals(exArray.get(i).getTag()))
				{
                    //then if its the first time your startingPoint now becomes the excursion whose
                    //tag was equal to the bestTags
					if(firstTime)
					{
						startingPoint = exArray.get(i);
						firstTime = !firstTime;
						
					}
                    
                    //then if the current excursion's reviews > than the startingPoint excursion's reviews
                    //the new startingPoint becomes the current excursion
					if(exArray.get(i).getReviews() > startingPoint.getReviews())
						startingPoint = exArray.get(i);
				}
						
			}
		}

		return startingPoint;

	}

    private static Excursion getNextExcursion(UserPreference user, ArrayList<Excursion> exArray, ArrayList<String> tags)
	{
		Excursion startingPoint = new Excursion("country", "excursion", new Location(1, 1), "tag", "website", "description", 0);
		Boolean firstTime = true;
		Boolean lastTag = false;
		Boolean badTags = true;
		ArrayList<String> bestTags = user.getFiveStar();

		//while loop that runs until our starting point which is the excursion we are recommending has been changed
		while(startingPoint.getReviews() == 0){
			
			//this deletes already used tags out of the users preference array
			for (int i = 0; i < tags.size(); i++) {
				if(user.getFiveStar().contains(tags.get(i))){
					user.getFiveStar().remove(tags.get(i));

				}
				if(user.getFourStar().contains(tags.get(i))){
					user.getFourStar().remove(tags.get(i));
				}
				if(user.getThreeStar().contains(tags.get(i))){
					user.getThreeStar().remove(tags.get(i));
				}
				if(user.getTwoStar().contains(tags.get(i))){
					user.getTwoStar().remove(tags.get(i));
				}
				if(user.getOneStar().contains(tags.get(i))){
					user.getOneStar().remove(tags.get(i));
				}
			}

			//this simply goes down the list to make sure their highest ranked list of tags is used
			if(user.getFiveStar().isEmpty())
			{
				if(user.getFourStar().isEmpty())
				{
					if(user.getThreeStar().isEmpty())
					{
						if(user.getTwoStar().isEmpty())
						{
							bestTags = user.getOneStar();
							lastTag = true;
						}
						else
							bestTags = user.getTwoStar();
					}
					else
						bestTags = user.getThreeStar();
				}
				else
					bestTags= user.getFourStar();
			}

			//The simpliest and worst way to find the best tags is just looping 
			//through each array, we love O(n^2), don't remember a way better off the top of my head

			for(int i = 0; i < exArray.size(); i++)
			{
				for(int j = 0; j < bestTags.size(); j++)
				{
					//If I have this correct, if bestTags string is equal to an excursion's tag
					//it passes
					if(bestTags.get(j).equals(exArray.get(i).getTag()))
					{
						//then if its the first time your startingPoint now becomes the excursion whose
						//tag was equal to the bestTags
						if(firstTime)
						{
							startingPoint = exArray.get(i);
							firstTime = !firstTime;
						}
						
						//then if the current excursion's reviews > than the startingPoint excursion's reviews
						//the new startingPoint becomes the current excursion
						if(exArray.get(i).getReviews() > startingPoint.getReviews())
							startingPoint = exArray.get(i);		
					}		
				}
			}
			
			//If the starting point has been changed(i.e Contains something to be recommended) adds its tag to bad tags list
			if(!(startingPoint.getReviews() == 0)){
				tags.add(startingPoint.getTag());
				badTags = false;
			}
			
			//if the tag has been through the recommendation process without finding a recommendation, adds it to the list of bad tags
			if(badTags == true){
				for (int i = 0; i < bestTags.size(); i++) {
					tags.add(bestTags.get(i));
				}
			}
			
			//breaks loop if there are no tags remaining
			if(lastTag){
				break;
			}
		
		}
		return startingPoint;

	}

	
	/*Overloaded method for getNextExcursion that adds a parameter for the list of already recommended excursions
	* This method allows for the use of duplicate tags in the recommendation process
	*/
	private static Excursion getNextExcursion(UserPreference user, ArrayList<Excursion> exArray, ArrayList<String> tags, ArrayList<Excursion> currExcursions)
	{
        
		Excursion startingPoint = new Excursion("country", "excursion", new Location(1, 1), "tag", "website", "description", 0);
		Boolean firstTime = true;
		Boolean lastTag = false;
		String bestTag = "placeholder";
		ArrayList<String> dupeTags = new ArrayList<>();

		//Gets rid of any already recommended excursions from the excursion list
		//Does the same bad thing of deleting the excursions from the list globally though
		for (int i = 0; i < exArray.size(); i++) {
			for (int j = 0; j < currExcursions.size(); j++) {
				if(exArray.get(i).getExcursion().equals(currExcursions.get(j).getExcursion())){
					exArray.remove(i);
					i--;
				}
			}
		}

		//list of tags we need to recommend
		for (int i = 0; i < currExcursions.size(); i++) {
			dupeTags.add(currExcursions.get(i).getTag());
		}


		int counter = dupeTags.size();
		//This can be changed to a for loop since we only need to run the insides a certain amount of times
		//i.e. The number of excursions already recommended
		for (int j = 0; j < counter; j++)
		{

			//If dupeTags array is not empty, gets the first item in it and uses it for bestTag
			if(!(dupeTags.isEmpty())){
				bestTag = dupeTags.get(0);
			}

			//The simpliest and worst way to find the best tags is just looping 
			//through each array, we love O(n^2), don't remember a way better off the top of my head

			for(int i = 0; i < exArray.size(); i++)
			{
				
					//If I have this correct, if bestTags string is equal to an excursion's tag
					//it passes
					if(bestTag.equals(exArray.get(i).getTag()))
					{
						//then if its the first time your startingPoint now becomes the excursion whose
						//tag was equal to the bestTags
						if(firstTime)
						{
							startingPoint = exArray.get(i);
							firstTime = !firstTime;
						}
						
						//then if the current excursion's reviews > than the startingPoint excursion's reviews
						//the new startingPoint becomes the current excursion
						if(exArray.get(i).getReviews() > startingPoint.getReviews())
							startingPoint = exArray.get(i);
					}		
			}
			
			//if the tag has been through the recommendation process once, adds it to the list of bad tags
			dupeTags.remove(bestTag);
				
			//breaks loop if there are no tags remaining
			if(lastTag){
				break;
			}
		
		}
	
	


		return startingPoint;

	}






    
}

//The database class will eventually pull information from SQL to make a list of excursions for the algorithm to work on
class database 
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


class Location 

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

//This class has 5 arraylists full of the different tags for each rating the user put in
class UserPreference {
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
