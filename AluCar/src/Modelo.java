import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
public class Modelo
{
	public Modelo()
	{
		
	}
	public ResultSet exibirModelo(Connection conn)
	{
		String comandosql="select * from modelo";
		PreparedStatement status = null;
		ResultSet resultado=null;
		 
		try
		{
			status=conn.prepareStatement(comandosql);
			resultado=status.executeQuery();
					
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe modelo");
			
		}
		
		return resultado;	
	}
	
String modelo;
String marca;	
	public Modelo(String model, String marc)
	{
		this.modelo=model;
		this.marca=marc;
	}	
	public void inserirModelo(Connection conn)
	{
		String sqlinserirModelo="Insert Into modelo (codmarca,modelo)values(?,?)";
		
		
		PreparedStatement status=null;
		
		try{
				status=conn.prepareStatement(sqlinserirModelo);
				
				status.setString(1, this.marca);
				status.setString(2,this.modelo);
				status.execute();
				conn.close();
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


}
