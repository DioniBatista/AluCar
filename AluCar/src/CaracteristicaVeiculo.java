import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
public class CaracteristicaVeiculo 
{
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
	public ResultSet exibirModelo(Connection conn,String teste)
	{
		String t = teste;
		String comandosql="select * from modelo where codmarca ="+t;
		//String comandosql="select * from marca where marca ="+t;
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
	
	public ResultSet pesquisarMarca(Connection conn,String teste)
	{
		String t = teste;
		String comandosql="select * from marca where marca='"+t+"'";
		//String comandosql="select * from marca where marca ="+t;
		PreparedStatement status = null;
		ResultSet resultado=null;
		
		try
		{
			status=conn.prepareStatement(comandosql);
			resultado=status.executeQuery();
				
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe modelo"+ex);
			
		}
		
		return resultado;
	}
	
	public ResultSet pesquisarModelo(Connection conn,String teste)
	{
		String t = teste;
		String comandosql="select * from modelo where modelo='"+t+"'";
		//String comandosql="select * from marca where marca ="+t;
		PreparedStatement status = null;
		ResultSet resultado=null;
		
		try
		{
			status=conn.prepareStatement(comandosql);
			resultado=status.executeQuery();
					
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe modelo"+ex);
			
		}
		
		return resultado;
	}
	//public ResultSet exibirCor(Connection conn, String teste)
	public ResultSet exibirCor(Connection conn)
	{
		//String t = teste;
		//String comandosql="select * from cor where codmodelo ='"+t+"'";
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

}
