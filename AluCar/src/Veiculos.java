import java.sql.*;

import javax.swing.JOptionPane;
public class Veiculos 
{
	String marca;
	String modelo;
	String cor;
	String placa;
	String ano;
	int valor;
	public Veiculos(String marca,String modelo,String cor,String placa,String ano, int valor)
	{
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa=placa;
		this.ano=ano;
		this.valor=valor;
		
	}
	public Veiculos()
	{
		
	}

	
	public ResultSet exibirVeiculos(Connection conn)
	{
		String comandosql="select * from veiculo where status='"+"livre"+"'";
		PreparedStatement status = null;
		ResultSet resultado=null;
		 
		try
		{
			status=conn.prepareStatement(comandosql);
			resultado=status.executeQuery();
					
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe veiculos");
			
		}
		
		return resultado;
	}
	public ResultSet exibirtodosVeiculos(Connection conn)
	{
		String comandosql="select * from veiculo";
		PreparedStatement status = null;
		ResultSet resultado=null;
		 
		try
		{
			status=conn.prepareStatement(comandosql);
			resultado=status.executeQuery();
					
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe veiculos");
			
		}
		
		return resultado;
	}
	
	public ResultSet pesquisarVeiculos(Connection conn,String placa)
	{
		String sqlpesquisarVeiculos = "select * from veiculo where placa ='"+placa+"'";
		PreparedStatement status = null;
		ResultSet resultado=null;
		 
		try
		{
			status=conn.prepareStatement(sqlpesquisarVeiculos);
			resultado=status.executeQuery();
						
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe Veiculos");
			
		}
		
		return resultado;	
	}
	
	public void editaVeiculos(String placa,String marca, String modelo, String cor,int valor,int ano)
	{
		try
		{
		Conexao conecta=new Conexao();
		Connection conn=conecta.obtemConexao();
		String editasql="update veiculo set placa='"+placa+"',marca = '"+marca+"',modelo = '"+modelo+"',cor ='"+cor+"',valorlocacao='"+valor+"',ano='"+ano+"' where placa='"+placa+"'";			
		PreparedStatement stm=conn.prepareStatement(editasql);
		stm.execute();
		
		
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na atualização dos dados"+ex);
			ex.printStackTrace();
		}		
	}
	
	public void excluiVeiculos(String placa)
	{
		try
		{
		Conexao conecta=new Conexao();
		Connection conn=conecta.obtemConexao();
		String excluisql="delete from veiculo where placa='"+placa+"'";			
		PreparedStatement stm=conn.prepareStatement(excluisql);
		stm.execute();
		
		
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro ao excluir dados"+ex);
			ex.printStackTrace();
		}
	}
	
	public void inserirVeiculos(Connection conn)
	{
String sqlinserirVeiculos = "Insert Into veiculo (marca,modelo,cor,placa,ano,valorlocacao,status)values(?,?,?,?,?,?,?)";
		
		PreparedStatement status = null;
		
		try
		{
			status=conn.prepareStatement(sqlinserirVeiculos);
			status.setString(1, this.marca);
			status.setString(2, this.modelo);
			status.setString(3, this.cor);
			status.setString(4, this.placa);
			status.setString(5, this.ano);
			status.setInt(6, this.valor);
			status.setString(7, "livre");
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
}