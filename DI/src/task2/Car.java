package task2;

public class Car implements Vehicle {
    private DatabaseConfig db;

    Car(DatabaseConfig db) {
        this.db = db;
    }

    @Override
    public void saveToDatabase(String Vehicle_Name) {

        db.save(Vehicle_Name);
    }

}
