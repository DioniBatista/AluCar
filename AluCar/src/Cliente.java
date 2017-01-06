import java.sql.*;

import javax.swing.JOptionPane;
public class Cliente
{
	String nome;
	String sexo;
	String datanascimento;
	String cpf;
	String rg;
	String telefone;
	String celular;
	String estado;
	String cidade;
	String cep;
	String rua;
	String numero;
	String bairro;
	String email;
	String utilidades;
	String observacao;
	
	public Cliente()
	{
		
	}
	
	public Cliente(String n, String s, String d, String cpf, String rg, String tel, String cel, String e, String c,String cep, String rua, String num, String b, String email, String u, String obs)
	{
		this.nome= n;
		this.sexo = s;
		this.datanascimento = d;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone=tel;
		this.celular=cel;
		this.estado=e;
		this.cidade=c;
		this.cep=cep;
		this.rua=rua;
		this.numero=num;
		this.bairro=b;
		this.email=email;
		this.utilidades=u;
		this.observacao=obs;
	}
	public void inserirCliente(Connection conn)
	{
		String sqlinserirCliente = "Insert Into cliente (nome, sexo, datanascimento, cpf, rg, telefone, celular, estado,cidade,cep,rua,numero,bairro,email,utilidades,observacao)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement status = null;
		
		try
		{
			status=conn.prepareStatement(sqlinserirCliente);
			status.setString(1, this.nome);
			status.setString(2, this.sexo);
			status.setString(3, this.datanascimento);
			status.setString(4, this.cpf);
			status.setString(5, this.rg);
			status.setString(6, this.telefone);
			status.setString(7, this.celular);
			status.setString(8, this.estado);
			status.setString(9, this.cidade);
			status.setString(10, this.cep);
			status.setString(11, this.rua);
			status.setString(12, this.numero);
			status.setString(13, this.bairro);
			status.setString(14, this.email);
			status.setString(15, this.utilidades);
			status.setString(16, this.observacao);
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
	public ResultSet exibirCliente(Connection conn)
	{
		String comandosql="select * from cliente";
		PreparedStatement status = null;
		ResultSet resultado=null;
		 
		try
		{
			status=conn.prepareStatement(comandosql);
			resultado=status.executeQuery();
						
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe Clientes");
			//ex.printStackTrace();
		}
		
		return resultado;		
	}
	
	public void excluiCliente(String c)
	{
		try
		{
		Conexao conecta=new Conexao();
		Connection conn=conecta.obtemConexao();
		String editasql="delete from cliente where cpf='"+c+"'";			
		PreparedStatement stm=conn.prepareStatement(editasql);
		stm.execute();
		
		
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro ao excluir dados"+ex);
			ex.printStackTrace();
		}
	}
	
	public ResultSet pesquisarCliente(Connection conn,String cpf)
	{
		String comandosql="select * from cliente where cpf='"+cpf+"'";
		PreparedStatement status = null;
		ResultSet resultado=null;
		 
		try
		{
			status=conn.prepareStatement(comandosql);
			resultado=status.executeQuery();
						
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na classe cliente");
			
		}
		
		return resultado;	
	}
	
	public void editaCliente( String nome,String sexo,String datanasc,String cpf,String rg,String telefone,String celular,String estado,String cidade,String cep,String rua,String numero,String bairro,String email,String utilidades,String observacao)
	{
		try
		{
		Conexao conecta=new Conexao();
		Connection conn=conecta.obtemConexao();
		String editasql="update cliente set nome='"+nome+"',sexo='"+sexo+"',datanascimento='"+datanasc+"',rg='"+rg+"',telefone='"+telefone+"',celular='"+celular+"',estado='"+estado+"',cidade='"+cidade+"',cep='"+cep+"',rua='"+rua+"',numero='"+numero+"',bairro='"+bairro+"',email='"+email+"',utilidades='"+utilidades+"',observacao='"+observacao+"' where cpf='"+cpf+"'";			
		PreparedStatement stm=conn.prepareStatement(editasql);
		stm.execute();
		
		
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Erro na atualização dos dados"+ex);
			ex.printStackTrace();
		}		
		
	}//fim editaCliente
	
}
