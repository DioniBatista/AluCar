import java.sql.*;

public class Conexao 
{
	public Connection obtemConexao()
			throws SQLException
			{
				return DriverManager.getConnection("jdbc:mysql://localhost/alucar","root","vertrigo");
			}

}
