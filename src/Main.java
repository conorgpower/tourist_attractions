import java.util.Scanner;

public class Main {

    //Fields
    public static Main app;
    public Scanner Input = new Scanner(System.in);
    TouristAttractionLinkedList<Object> TouristAttractionLinkedList;

    public static void main(String[] args) throws Exception {
        app = new Main();
        app.Start();
    }

    public Main() {
        this.TouristAttractionLinkedList = new TouristAttractionLinkedList<>();
    }

    //Main menu opened upon start of programme
    public int MainMenu() {
        System.out.println("1) Add a TouristAttraction Attraction");
        System.out.println("2) Delete a TouristAttraction Attraction");
        System.out.println("3) List a TouristAttraction Attraction");
        System.out.println("4) Save data");
        System.out.println("5) Load data");
        System.out.println("6) List alphabetically");
        System.out.println("7) List by cost");
        System.out.println("0) Exit");
        int start = Input.nextInt();
        return start;

    }

    //Switch to control main menu
    private void Start() throws Exception {
        do {
            int Start = MainMenu();
            switch(Start) {
                case 1:
                    addTouristAttraction();
                    break;
                case 2:
                    deleteTouristAttraction();
                    break;
                case 3:
                    listTouristAttraction();
                    break;
                case 4:
                    TouristAttractionLinkedList.save();
                    break;
                case 5:
                    TouristAttractionLinkedList.load();
                    break;
                case 6:
                    listAlphabetically();
                    break;
                case 7:
                    listByCost();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.exit(0);
            }
        }while(true);
    }

    //Add Tourist Attraction
    private void addTouristAttraction() {
        String TouristAttractionName = touristAttractionName();
        String TouristAttractionDescription = touristAttractionDescription();
        int TouristAttractionOpeningTime = touristAttractionOpeningTime();
        int TouristAttractionCost = touristAttractionCost();
        int countTouristAttraction = TouristAttractionLinkedList.countTouristAttraction();
        TouristAttractionLinkedList.addTouristAttraction(new TouristAttraction(TouristAttractionName,TouristAttractionDescription,TouristAttractionOpeningTime,TouristAttractionCost,countTouristAttraction));
    }

    private String touristAttractionName() {
        System.out.println("Enter the name of the Tourist Attraction: ");
        String name = Input.next();
        name.toUpperCase();
        return name;
    }

    private String touristAttractionDescription() {
        System.out.println("Please provide a description of the Tourist Attraction: ");
        String description = Input.next();
        //Empty while loop serves purpose as to stop opening time error
        while(description == null){
        }
        description.toUpperCase();
        return description;
    }
    private int touristAttractionOpeningTime() {
        System.out.println("Enter the opening time of the Tourist Attraction; ");
        int openingTime = Input.nextInt();
        return openingTime;
    }
    private int touristAttractionCost() {
        System.out.println("Enter the cost of entry: ");
        int cost = Input.nextInt();
        return cost;
    }

    //Delete Tourist Attraction
    private void deleteTouristAttraction() {
        System.out.println("Enter the name of the Tourist Attraction that you would like to delete: ");
        String name = Input.next();
        TouristAttractionLinkedList.deleteTouristAttraction(name);
    }

    //List all Tourist Attractions
    private void listTouristAttraction() {
        TouristAttractionLinkedList.listTouristAttractions();
    }

    //List Alphabetically
    private void listAlphabetically() {
        TouristAttractionLinkedList.listAlphabetically();
    }

    //List by cost
    private void listByCost(){
        TouristAttractionLinkedList.listByCost();
    }
}
