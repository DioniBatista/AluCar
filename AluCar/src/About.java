import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
public class About extends JInternalFrame
{
	
	public About()
	{
		
		super("About",false,true,false,false);
		setBounds(100,0,500,500);
		setVisible(true);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		JLabel l1 = new JLabel("Desenvolvedor:  Dioni Batista");
		JLabel l2 = new JLabel("Versão: 0.01");
		JLabel l3 = new JLabel("© Copyright - Todos Direitos Reservados");
		JLabel l4 = new JLabel("AluCar Veículos");
		JLabel l5 = new JLabel("Contato: ");
		JLabel l6 = new JLabel("(31)8313-7373");
		JLabel l7 = new JLabel("e-mail: dionibatista@live.com");
		final JButton btVoltar = new JButton("Voltar");
		btVoltar.setBounds(400,420,80,20);
		add(btVoltar);
		JLabel recebelogo = new JLabel();
		Icon teste = new ImageIcon("imagens/logo150x80.png");
		recebelogo.setIcon(teste);
		recebelogo.setBounds(175,80,150,80);
		add(recebelogo);
		l4.setBounds(80,200,300,30);
		add(l4);
		l2.setBounds(80,230,300,30);
		add(l2);
		l1.setBounds(80,290,300,30);
		add(l1);
		l5.setBounds(80,320,300,30);
		add(l5);
		l6.setBounds(80,340,300,30);
		add(l6);
		l7.setBounds(80,360,300,30);
		add(l7);
		l3.setBounds(80,390,300,30);
		add(l3);
		class Acoes implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
			if(e.getSource() == btVoltar)
			{
				Plataforma.verificatela=0;				
				dispose();
			}
		}//fim actionPerformed
	}//fim ActonListener
	Acoes acao = new Acoes();
	btVoltar.addActionListener(acao);
		
	}

}
