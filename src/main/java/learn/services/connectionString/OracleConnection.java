package learn.services.connectionString;

public class OracleConnection implements ConnectionStringService{
    @Override
    public String connectionString()
    {
        return "Oracle Connection String";
    }
}
