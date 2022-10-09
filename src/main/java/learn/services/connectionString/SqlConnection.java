package learn.services.connectionString;

public class SqlConnection implements ConnectionStringService{
    @Override
    public String connectionString()
    {
        return "Oracle Connection String";
    }
}
