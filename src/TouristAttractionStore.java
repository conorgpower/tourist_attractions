public class TouristAttractionStore<touristAttraction> {

    //Fields
    public TouristAttractionStore<touristAttraction> next = null;
    public TouristAttraction touristAttraction;
    public TouristAttractionStore<touristAttraction> TouristAttractionStore;



    public TouristAttractionStore(TouristAttraction touristAttraction, TouristAttractionStore<touristAttraction> TouristAttractionStore) {
        this.touristAttraction = touristAttraction;
        this.TouristAttractionStore = TouristAttractionStore;
    }

    public String toString() {
        return touristAttraction.toString();
    }

    public TouristAttractionStore<touristAttraction> getNext() {
        return next;
    }

    public void setNext(TouristAttractionStore<touristAttraction> next) {
        this.next = next;
    }

    public TouristAttraction getTouristAttraction() {
        return touristAttraction;
    }

    public void setTouristAttraction (TouristAttraction touristAttraction) {
        this.touristAttraction = touristAttraction;
    }
}