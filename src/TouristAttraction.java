import java.util.Comparator;

public class TouristAttraction
{

    //Fields
    public String name;
    public String description;
    public int openingTime;
    public int cost;
    public int countTouristAttraction;

    //Default constructor
    public TouristAttraction(String name, String description,int openingTime,int cost,int countTouristAttraction){
        this.name = name;
        this.description = description;
        this.openingTime = openingTime;
        this.cost = cost;
        this.countTouristAttraction = countTouristAttraction;
    }

    /*Comparator for sorting the list by Tourist Attraction name*/
    public static Comparator<TouristAttraction> TANameComparator = new Comparator<TouristAttraction>() {

        public int compare(TouristAttraction TA1, TouristAttraction TA2) {
            String TAName1 = TA1.getName().toUpperCase();
            String TAName2 = TA2.getName().toUpperCase();

            //ascending order
            return TAName1.compareTo(TAName2);
        }
    };

    /*Comparator for sorting the list by Tourist Attraction cost*/
    public static Comparator<TouristAttraction> TACostComparator = new Comparator<TouristAttraction>() {

        public int compare(TouristAttraction TA1, TouristAttraction TA2) {
            int TACost1 = TA1.getCost();
            int TACost2 = TA2.getCost();

            //ascending order
            return TACost1-TACost2;
        }
    };


    //Getters
    public int getCountTouristAttraction() { return countTouristAttraction; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public int getOpeningTime() { return openingTime; }

    public int getCost() { return cost; }

    //Setters
    public void setCountTouristAttraction(int countTouristAttraction) { this.countTouristAttraction = countTouristAttraction; }

    public void setName(String name) { this.name = name; }

    public void setDescription(String description) { this.description = description; }

    public void setOpeningTime(int openingTime) { this.openingTime = openingTime; }

    public void setCost(int cost) { this.cost = cost; }

    @Override
    public String toString() { return "Tourist Attraction: " + "Name:" + name  + ", description: " + description + ", openingTime: " + openingTime + ", cost: " + cost; }
}
