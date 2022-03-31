import java.util.ArrayList;

//Class which holds our algorithm
public class Algorithm {
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
		/*alters loop based on the size of options where options is the list of all possible excursions
		* able to be recommended
		* This may not be the best way to do this, but I do think it works for now, it will only let the loop run
		* for as long as we have options available
		*/
		if(options.size() == 3){
			counter--;
		}else if(options.size() == 2){
			counter -= 2;
		}else if(options.size() == 1){
			counter -= 3;
		}else if(options.size() == 0){
			counter -= 4;
		}
		
		//Loop should run 4 times to recommend the remaining 4 excursions and put them into finalList
        for (int i = 0; i < counter; i++) {
			
			//tags array is getting stuck on adding the same tag
			for (int j = 0; j < finalList.size(); j++) {
				System.out.println("TAGS ARRAY: " + j);
				System.out.println(tagsArray.get(j));
			} 

			//TODO logic here still needs to be fixed
			//TODO need to test case where user pref list has 2 or more in one list i.e. 2 or more prefs in user.FiveStar
            finalList.add(getNextExcursion(user, options, tagsArray));

			//TODO check to see if final list size == 5 and if not run another method that will recommend already used tags


            tagsArray.add(finalList.get(i+1).getTag());
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
				System.out.println("--------------------------");
				System.out.println(bestTags.get(j));
				System.out.println(exArray.get(i).getTag());
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
		
		//if the tag has been through the recommendation process once, adds it to the list of bad tags
		for (int i = 0; i < bestTags.size(); i++) {
			System.out.println("TAGS IN BEST TAGS: " + bestTags.get(i));
			tags.add(bestTags.get(i));
		}
		
		//TODO could add some kind of different return statement here
		//breaks loop if there are no tags remaining
		if(lastTag){
			break;
		}
		

		
	}


		return startingPoint;

	}






    
}
