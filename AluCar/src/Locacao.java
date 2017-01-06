import java.sql.*;

import javax.swing.JOptionPane;
public class Locacao
{
	String cpf;
	String nome;
	String marca;
	String modelo;
	String cor;
	String placa;
	String ano;
	String valorlocacao;
	String data;
	String dias;
	String valortotal;
	String observacao;
	public Locacao(String cpf, String nome, String marca, String modelo, String cor, String placa, String ano, String valorlocacao, String data, String dias, String valortotal,String observacao)
	{
		this.cpf = cpf;
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.cor=cor;
		this.placa=placa;
		this.ano=ano;
		this.valorlocacao=valorlocacao;
		this.data = data;
		this.dias=dias;
		this.valortotal=valortotal;
		this.observacao=observacao;
	}
	public Locacao()
	{
	
	}
	public void inserirLocacao(Connection conn)
	{
		String sqlinserirFuncionarios="Insert Into locacoes (cpf,nome,marca,modelo,cor,placa,ano,valorlocacao,data,dias,valortotal,observacao)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement status=null;
		
		try{
				status=conn.prepareStatement(sqlinserirFuncionarios);
				
				status.setString(1, this.cpf);
				status.setString(2, this.nome);
				status.setString(3, this.marca);
				status.setString(4, this.modelo);
				status.setString(5, this.cor);
				status.setString(6, this.placa);
				status.setString(7, this.ano);
				status.setString(8, this.valorlocacao);
				status.setString(9, this.data);
				status.setString(10, this.dias);
				status.setString(11 ,this.valortotal);
				status.setString(12, this.observacao);
				status.execute();
			
			}

		catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Erro ao inserir Dados");
			}
	}
	
	public ResultSet exibirLocacao(Connection conn)
	{
		String comandosql="select * from locacoes";
		PreparedStatement status = null;
		ResultSet resultado=null;
		 
		try
		{
			status=conn.prepareStatement(comandosql);
			resultado=status.executeQuery();
					
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe locacao");
			
		}
		
		return resultado;
	}
	
	public void editaLocacao(String carroselect, String codigo,String cpf, String nome, String marca, String modelo, String cor, String placa, String ano, String valorlocacao, String data, String dias, String valortotal,String observacao)
	{
		try
		{
		Conexao conecta=new Conexao();
		Connection conn=conecta.obtemConexao();
		String editasql="update locacoes set cpf='"+cpf+"',nome = '"+nome+"',marca = '"+marca+"',modelo = '"+modelo+"',cor = '"+cor+"',placa = '"+placa+"',ano = '"+ano+"',valorlocacao = '"+valorlocacao+"',data = '"+data+"',dias = '"+dias+"',valortotal = '"+valortotal+"',observacao = '"+observacao+"'where cpf ='"+cpf+"'and modelo='"+carroselect+"'";			
		PreparedStatement stm=conn.prepareStatement(editasql);
		stm.execute();
		
		
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na atualização dos dados"+ex);
			ex.printStackTrace();
		}		
	}
	
	public void colocaStatus(String modelo, String cor)
	{
		try
		{
		Conexao conecta=new Conexao();
		Connection conn=conecta.obtemConexao();
		String sql="update veiculo set status='"+"alugado"+"' where modelo='"+modelo+"'and cor='"+cor+"'";			
		PreparedStatement stm=conn.prepareStatement(sql);
		stm.execute();
		
		
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro colocarstatus"+ex);
			ex.printStackTrace();
		}		
	}
	
	public void excluiLocacao(String cpf, String carroselect,String modelo, String cor)
	{
		try
		{
		Conexao conecta = new Conexao();
		Connection conn=conecta.obtemConexao();
		String sql = "delete from locacoes where cpf='"+cpf+"'and modelo='"+carroselect+"'";
		String sqlstatus ="update veiculo set status='"+"livre"+"' where modelo='"+modelo+"'and cor='"+cor+"'";
		PreparedStatement stm=conn.prepareStatement(sql);
		PreparedStatement stmstatus=conn.prepareStatement(sqlstatus);
		stm.execute();
		stmstatus.execute();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Erro ao excluir," +ex);
		}
	}
	
	public ResultSet pesquisarLocacao(Connection conn,String cpf)
	{
		String sql = "select * from locacoes where cpf ='"+cpf+"'";
		PreparedStatement status = null;
		ResultSet resultado=null;
		 
		try
		{
			status=conn.prepareStatement(sql);
			resultado=status.executeQuery();
						
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe Locacao");
			
		}
		
		return resultado;	
	}
	public ResultSet pesquisarveiculoLocacao(Connection conn,String cpf, String carroselect)
	{
		String sql = "select * from locacoes where cpf ='"+cpf+"'and modelo='"+carroselect+"'";
		PreparedStatement status = null;
		ResultSet resultado=null;
		 
		try
		{
			status=conn.prepareStatement(sql);
			resultado=status.executeQuery();
						
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe Locacao");
			
		}
		
		return resultado;	
	}
	
	public ResultSet mostraCor(Connection conn,String modelo)
	{
		String comandosql="select * from veiculo where modelo ='"+modelo+"'and status ='"+"livre"+"'";
		PreparedStatement status = null;
		ResultSet resultado=null;
		 
		try
		{
			status=conn.prepareStatement(comandosql);
			resultado=status.executeQuery();
					
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe locacao");
			
		}
		
		return resultado;
	}
	
	public ResultSet dadosVeiculos(Connection conn,String modelo,String cor)
	{
		String comandosql="select * from veiculo where modelo ='"+modelo+"'and cor='"+cor+"'";
		PreparedStatement status = null;
		ResultSet resultado=null;
		 
		try
		{
			status=conn.prepareStatement(comandosql);
			resultado=status.executeQuery();
					
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe locacao");
			
		}
		
		return resultado;
	}

}
