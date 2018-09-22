import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class TouristAttractionLinkedList<touristAttraction> {

    public TouristAttractionStore<touristAttraction> head = null;

    ArrayList<TouristAttraction> myList = new ArrayList<>();

    //Add Tourist Attraction
    public void addTouristAttraction(TouristAttraction touristAttraction) {
        TouristAttractionStore<touristAttraction> end = new TouristAttractionStore<>(touristAttraction,null);
        end.setTouristAttraction(touristAttraction);
        end.next = head;
        head = end;
    }

    //Check whether list is empty or not
    public boolean noTouristAttraction() {
        if(head == null) {
            return true;
        }
        else {
            return false;
        }
    }

    //List all Tourist Attractions
    public void listTouristAttractions() {
        TouristAttractionStore<touristAttraction> list = head;
        while(list != null) {
            System.out.println(list);
            list = list.next;
        }
    }

    //List alphabetically
    public void listAlphabetically() {
        TouristAttractionStore<touristAttraction> list = head;
        //Copy list into an Array List
        while(list != null) {
            myList.add(list.getTouristAttraction());
            list = list.next;
        }
        Collections.sort(myList, TouristAttraction.TANameComparator);

        for (TouristAttraction touristAttraction: myList) {
            System.out.println(touristAttraction);
        }
        myList.clear();
    }

    //List by cost
    public void listByCost() {
        TouristAttractionStore<touristAttraction> list = head;
        //Copy list into an Array List
        while(list != null) {
            myList.add(list.getTouristAttraction());
            list = list.next;
        }
        Collections.sort(myList, TouristAttraction.TACostComparator);

        for (TouristAttraction touristAttraction: myList) {
            System.out.println(touristAttraction);
        }
        myList.clear();
    }

    //Return int indicating position of Tourist Attraction
    public int countTouristAttraction() {
        int count = 0;
        if (noTouristAttraction()) {
            count = 1;
        }
        else {
            TouristAttractionStore<touristAttraction> link = head;
            while(link.getNext() != null) {
                count++;
                link = link.getNext();
            }
        }
        return count;
    }

    //Delete Tourist Attraction
    public boolean deleteTouristAttraction(touristAttraction name) {
        TouristAttractionStore<touristAttraction> TouristAttractionStore = head, prev = null;
        while(TouristAttractionStore != null && !TouristAttractionStore.getTouristAttraction().getName().equals(name)) {
            prev = TouristAttractionStore;
            TouristAttractionStore = TouristAttractionStore.next;
        }

        if(TouristAttractionStore != null) {
            if(prev == null) {
                head = TouristAttractionStore.next;
            }
            else {
                prev.next = TouristAttractionStore.next;
            }
            return true;
        }
        return false;
    }

    //Load Tourist Attraction
    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        Class<?>[] classes = new Class[] { TouristAttraction.class, TouristAttractionLinkedList.class, TouristAttractionStore.class };
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("TouristAttraction.xml"));
        head = (TouristAttractionStore<touristAttraction>) is.readObject();
    }
    //Save Tourist Attraction
    public void save() throws Exception
    {
        Class<?>[] classes = new Class[] { TouristAttraction.class, TouristAttractionLinkedList.class, TouristAttractionStore.class };
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("TouristAttraction.xml"));
        out.writeObject(head);
        out.close();
    }
}
