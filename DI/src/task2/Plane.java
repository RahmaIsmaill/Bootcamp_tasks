package task2;

public class Plane implements Vehicle{
    private DatabaseConfig db;

    public DatabaseConfig getDb() {
        return db;
    }

    public void setDb(DatabaseConfig db) {
        this.db = db;
    }

    @Override
    public void saveToDatabase(String Vehicle_Name) {

        db.save(Vehicle_Name);
    }
}
