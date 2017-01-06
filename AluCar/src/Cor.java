import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
public class Cor
{
	public Cor()
	{
		
	}
	public ResultSet exibirCor(Connection conn)
	{
		String comandosql="select * from cor";
		PreparedStatement status = null;
		ResultSet resultado=null;
		 
		try
		{
			status=conn.prepareStatement(comandosql);
			resultado=status.executeQuery();
						
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe cor");
			
		}
		
		return resultado;	
	}
	String modelo;
	//String marca;	
	String cor;
		public Cor(String cor)
		{
			this.cor=cor;
			//this.modelo=model;
			//this.marca=marc;
		}	
		public void inserirCor(Connection conn)
		{
			String sqlinserirCor="Insert Into cor (cor)values(?)";
			
			
			PreparedStatement status=null;
			
			try{
					status=conn.prepareStatement(sqlinserirCor);
					
					status.setString(1, this.cor);
					status.execute();
				
				}

			catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "Erro ao inserir Dados"+e);
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
