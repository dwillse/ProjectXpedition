import java.util.*;

//Main method class so we can run/test
public class Main {
    
    public static void main(String args[]){
        Location l = new Location(2, 3);
        System.out.println(l);

        ArrayList<Excursion> excursionArray = new ArrayList();
        
        Excursion test = new Excursion("Japan", "Hiking", new Location(35.3606, 138.7274),
        new Tag("Mountain"), "www.mtfuji.com", "Japan's Mt. Fuji ss an active volcano about 100 kilometers southwest of Tokyo",
        4.6);

        excursionArray.add(test);

        System.out.println(excursionArray.get(0));


    }
}
