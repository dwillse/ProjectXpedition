import java.util.ArrayList;

//Class which holds our algorithm
public class Algorithm {
    //This will be the Method that you actually call to get results
    //TODO fix return type if needed
	public static ArrayList<Excursion> CallAlgorithim (UserPreference user, ArrayList<Excursion> exArray)
	{

		Excursion startingPoint = getStartingPoint(user, exArray);
		ArrayList<Excursion> options = AllWithinFifty(startingPoint, exArray);
        ArrayList<Excursion> finalList = new ArrayList<>();
        ArrayList<Tag> tagsArray = new ArrayList<>();
        tagsArray.add(startingPoint.getTags());
        finalList.add(startingPoint);
        
        for (int i = 0; i < 4; i++) {

            finalList.add(getNextExcursion(user, options, tagsArray));
            tagsArray.add(finalList.get(i+1).getTags());
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
		ArrayList<Tag> bestTags = user.getFiveStar();
		

		//this simply goes down the list to make sure their highest ranked list of tags is used
        //Note: May get stuck on getting OneStar, I can't tell for sure though
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
				if(bestTags.get(j).getTag1().equals(exArray.get(i).getTags().getTag1()))
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

    private static Excursion getNextExcursion(UserPreference user, ArrayList<Excursion> exArray, ArrayList<Tag> tags)
	{
        ArrayList<Excursion> exArray2 = exArray;
        UserPreference user2 = user;
		Excursion startingPoint = exArray.get(0);
		Boolean firstTime = true;
		ArrayList<Tag> bestTags = user.getFiveStar();

        for (int i = 0; i < exArray.size(); i++) {
            for (int j = 0; j < tags.size(); j++) {
                if(exArray.get(i).getTags().getTag1().equals(tags.get(j).getTag1())){
                    exArray2.remove(exArray.get(i));
                }
            }
        }
    
        for (int i = 0; i < tags.size(); i++) {
            if(user.getFiveStar().contains(tags.get(i))){
                user2.getFiveStar().remove(tags.get(i));
            }
            if(user.getFourStar().contains(tags.get(i))){
                user2.getFourStar().remove(tags.get(i));
            }
            if(user.getThreeStar().contains(tags.get(i))){
                user2.getThreeStar().remove(tags.get(i));
            }
            if(user.getTwoStar().contains(tags.get(i))){
                user2.getTwoStar().remove(tags.get(i));
            }
            if(user.getOneStar().contains(tags.get(i))){
                user2.getOneStar().remove(tags.get(i));
            }
        }
		

		//this simply goes down the list to make sure their highest ranked list of tags is used
        //Note: May get stuck on getting OneStar, I can't tell for sure though
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
				if(bestTags.get(j).getTag1().equals(exArray.get(i).getTags().getTag1()))
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






    
}
