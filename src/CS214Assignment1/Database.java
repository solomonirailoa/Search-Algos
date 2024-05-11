package CS214Assignment1;

public class Database<T extends Comparable<? super T>> { //We have enable "Generics" in Java, hence a solution to Question 2 of Assignment1
    private final T key; //This will be the primary search key
    private final T data; //The search data, indentifiable only through the search key, preferably an ID
    public Database (T key, T data){ // <---- This is CONSTRUCTOR
        this.key=key;
        this.data=data;
    }
    public T getKey() {
        return this.key;
    }
    @SuppressWarnings("unchecked")
	public T printOut() {
        String concat = "";
        String line = ((String)(this.data));
        String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        for(String t : tokens) {
            if (t.isEmpty()){
                t = "!empty!";
            }
            concat= concat + t + " | ";
        }
        return (T) (this.key + " | " + concat);
    }
    public void showDetailedRecord(String columnHeading){
        String[] titles = columnHeading.split(",");
        String line = ((String)(this.data));
        String[] records = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        System.out.println("\n-------------------------");
        System.out.println("Record Details");
        System.out.println("-------------------------");
        System.out.println(titles[0] + ": " + this.key);
        for (int i =0; i < titles.length -1; i++){
            if (records[i].isEmpty()){
                records[i] = "!empty!";
            }
            System.out.println(titles[i+1] + ": " + records[i]);
        }
        System.out.println("---------------------------------\n");
    }
}