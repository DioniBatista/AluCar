/*REDICIONAR IMAGEM 
    		Image redimensiona = logo.getImage().getScaledInstance(150,80,Image.SCALE_DEFAULT);
    		logo = new ImageIcon(redimensiona);
    	----------------------------------------------------------*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login
{
    public Login() 
    {
    	
    	//INICIO JANELA LOGIN
    	final JFrame login = new JFrame("Login");   
    	login.setSize(400,200);
    	login.setVisible(true);
    	login.setLayout(null);
    	login.setResizable(false);//proibe modificar o tamanho como mouse
     	login.setLocationRelativeTo(null);//ficar no centro da tela
     	
    	JLabel rotulo = new JLabel("Bem vindo, ");
    	JLabel lblLogin = new JLabel("Login: ");
    	final JTextField txtLogin = new JTextField();
    	JLabel lblSenha = new JLabel("Senha: ");
    	final JPasswordField txtSenha = new JPasswordField();
    	final JButton btEntrar = new JButton("Entrar");
    	final JButton btCancelar = new JButton("Cancelar");  
    	ImageIcon logo = new ImageIcon("imagens/logo150x80.PNG");
    	JLabel recebelogo = new JLabel();
    	
    	login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	login.add(rotulo);//adicionar no janela
    	rotulo.setBounds(20,10,100,20);//colocar no local da janela
    	
    	login.add(lblLogin);
    	lblLogin.setBounds(50,50,50,20);    	
    	login.add(txtLogin);
    	txtLogin.requestFocus();
    	txtLogin.setBounds(100,50,100,20);
    	
    	login.add(lblSenha);
    	lblSenha.setBounds(50,75,50,20);
    	login.add(txtSenha);
    	txtSenha.setBounds(100,75,100,20);
    	
    	login.add(btEntrar);
    	btEntrar.setBounds(120,120,100,20);
    	
    	login.add(btCancelar);
    	btCancelar.setBounds(225,120,100,20);
    	
    	recebelogo.setIcon(logo);
    	login.add(recebelogo);
    	recebelogo.setBounds(225,30,155,85);
    	
    	
		
    	class Eventos implements ActionListener
    	{
    		 
    			public void actionPerformed(ActionEvent e)
    			{
    				if(e.getSource() == btEntrar)
    				{		
    					String nome = txtLogin.getText();
    		    		String senha = new String(txtSenha.getPassword());
    		    		String cargo = "Gerente";
    		    		String nomelogin;
    				  try
    					{
    						Conexao conecta=new Conexao();
    						Connection conn=conecta.obtemConexao();
    						String sql="select * from login where nome='"+nome+"' and senha='"+senha+"'and cargo='"+cargo+"'";
    						PreparedStatement comando=conn.prepareStatement(sql);
    						ResultSet resultado=comando.executeQuery();
    						if(resultado.next())
    						{
    							nomelogin = nome;
    							//login.hide();// deixa janela oculta
    							login.dispose();
    							 new Plataforma(cargo,nomelogin);
    							 
    						}
    						else
    						{
    							//JOptionPane.showMessageDialog(null, "Dados de Login Inválidos!");
    							//dispose();
    							// se não for gerente cargo recebe funcionário e verifica.
    							cargo = "Funcionário";
    							String sqlf="select * from login where nome='"+nome+"' and senha='"+senha+"'and cargo='"+cargo+"'";
        						PreparedStatement comandof=conn.prepareStatement(sqlf);
        						ResultSet resultadof=comandof.executeQuery();
    							try
    	    					{
    	    					
    	    						if(resultadof.next())
    	    						{
    	    							nomelogin = nome;
    	    							//login.hide();// deixa janela oculta
    	    							login.dispose();
    	    							new Plataforma(cargo,nomelogin);
    	    							
    	    						}
    	    						else
    	    						{
    	    							JOptionPane.showMessageDialog(null, "Dados de Login Inválidos!");
    	    							txtLogin.setText("");
    	    							txtSenha.setText("");
    	    							//JOptionPane.showMessageDialog(null, nome + senha + cargo);
    	    							//dispose();
    	    						}
    	    						
    	    					}//fim try
    	    					catch(Exception ex)
    	    					{
    	    						JOptionPane.showMessageDialog(null, "Banco de dados inacessível");
    	    					}//fim exception VERIFICA SE É FUNCIONARIO
    						}
    						
    					}//fim try
    					catch(Exception ex)
    					{
    						JOptionPane.showMessageDialog(null, "Banco de dados inacessível");
    					}//fim exception
    					
    					
    				}
    				if(e.getSource() == btCancelar)
    				{
    					login.dispose();
    					login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			
    				}
    			}//fim action performed    		
    	}//fim action listener
    	
    	Eventos acao = new Eventos();
    	btEntrar.addActionListener(acao);
    	btCancelar.addActionListener(acao);

    }//fim construtor
  
    
    public static void main (String[]args)
    {
    	new Login();
    }  
    
     
}
