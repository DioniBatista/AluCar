import java.sql.*;

import javax.swing.JOptionPane;


public class Funcionarios {
	String nome;
	String senha;
	String cargo;
	
	public Funcionarios(String n,String s, String c)
	{
		this.nome=n;
		this.senha=s;
		this.cargo=c;
	}	
	public Funcionarios()
	{
		
	}
	
	public void excluiFuncionario(String c)
	{
		try
		{
		Conexao conecta=new Conexao();
		Connection conn=conecta.obtemConexao();
		String editasql="delete from login where nome='"+c+"'";			
		PreparedStatement stm=conn.prepareStatement(editasql);
		stm.execute();
		
		
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro ao excluir dados"+ex);
			ex.printStackTrace();
		}
	}
	
	public ResultSet exibirFuncionario(Connection conn)
	{
		String comandosql="select * from login";
		PreparedStatement status = null;
		ResultSet resultado=null;
		 
		try
		{
			status=conn.prepareStatement(comandosql);
			resultado=status.executeQuery();
						
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe Funcionario");
			//ex.printStackTrace();
		}
		
		return resultado;		
	}
	
	public void inserirFuncionarios(Connection conn)
		{
			String sqlinserirFuncionarios="Insert Into login (nome,senha,cargo)values(?,?,?)";
			
			
			PreparedStatement status=null;
			
			try{
					status=conn.prepareStatement(sqlinserirFuncionarios);
					
					status.setString(1, this.nome);
					status.setString(2, this.senha);
					status.setString(3, this.cargo);
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
	public Funcionarios(String n)
	{
		this.nome=n;
	}
	
	public ResultSet pesquisarFuncionario(Connection conn,String nome)
	{
		String comandosql="select * from login where nome='"+nome+"'";
		PreparedStatement status = null;
		ResultSet resultado=null;
		 
		try
		{
			status=conn.prepareStatement(comandosql);
			resultado=status.executeQuery();
						
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe funcionario");
			
		}
		
		return resultado;	
	}
	
	public void editaFuncionarios(String codigo,String nome, String senha, String cargo)
	{
		try
		{
		Conexao conecta=new Conexao();
		Connection conn=conecta.obtemConexao();
		String editasql="update login set nome='"+nome+"',senha = '"+senha+"',cargo = '"+cargo+"' where codigo='"+codigo+"'";			
		PreparedStatement stm=conn.prepareStatement(editasql);
		stm.execute();
		
		
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na atualização dos dados"+ex);
			ex.printStackTrace();
		}		
	}
	
	public Funcionarios(String nome, String senha)
	{
		this.nome = nome;
		this.senha=senha;
	}
	public void fazerLogin(Connection conn)
	{
		String sqlLogin = "select * from login where nome='"+nome+"' and senha='"+senha+"'";
		
			
		try
		{		
			Statement status = conn.createStatement();
			ResultSet rs = status.executeQuery(sqlLogin); 
			if(rs.equals(nome))
			{
				JOptionPane.showMessageDialog(null,"verdadeiro");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"fjhsdfjdks");
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"entrou n catch");
		}
	}
	
	
}
	
