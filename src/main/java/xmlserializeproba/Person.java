package xmlserializeproba;

public class Person {
     String first_name;
     String middle_name;
     String last_name;

    public Person() {
    }

    public Person(String first_name, String last_name) {
         this.first_name = first_name;
         this.last_name = last_name;
         this.middle_name = "";
     }

     public Person(String first_name, String middle_name, String last_name) {
         this.first_name = first_name;
         this.middle_name = middle_name;
         this.last_name = last_name;
     }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
