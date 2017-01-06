import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
public class Marca 
{
	public Marca()
	{
		
	}
	
	
	String marca;
	
	public Marca(String m)
	{
		this.marca=m;
		
	}	
	public void inserirMarca(Connection conn)
	{
		String sqlinserirMarca="Insert Into marca (marca)values(?)";
		
		
		PreparedStatement status=null;
		
		try{
				status=conn.prepareStatement(sqlinserirMarca);
				
				status.setString(1, this.marca);
				status.execute();
				
			}

		catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Erro ao inserir Dados");
			}
		
		finally
			{
				try
					{
						status.close();
					}
				catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, "A conexão com o banco não pode ser encerrada");
					}
			
			}	
	}
	public ResultSet exibirMarca(Connection conn)
	{
		String comandosql="select * from marca";
		PreparedStatement status = null;
		ResultSet resultado=null;
		 
		try
		{
			status=conn.prepareStatement(comandosql);
			resultado=status.executeQuery();
					
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe marca");
			
		}
		
		return resultado;
	}

}
