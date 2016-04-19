package Task2;

/**
 * Created by Elizaveta on 18.04.2016.
 */
public class Food {
    private  int id;
    private String name;
    private String  price;
    private String description;
    private int calories;

    public Food(int id, String name, String price, String description, int calories) {
        this.id= id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Food(int id){
        this(id, null,null,null,0);
    }
}
