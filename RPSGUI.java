package RPSGame;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RPSGUI implements IFrame {
	JPanel pnl, canvas;
	
	@Override
	public void buildButtonPanel() {
		pnl = new JPanel();
		
		ImageIcon r = new ImageIcon("C:\\\\Users\\\\prosi\\\\OneDrive\\\\Pictures\\\\Rock_001.png");
		ImageIcon p = new ImageIcon("C:\\Users\\prosi\\OneDrive\\Pictures\\paper.png");
		ImageIcon s = new ImageIcon("C:\\Users\\prosi\\OneDrive\\Pictures\\scissors_002.png");
		
		Image rImage = r.getImage();
		Image pImage = p.getImage();
		Image sImage = s.getImage();
		
		Image rResize = rImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		Image pResize = pImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		Image sResize = sImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		
		r = new ImageIcon(rResize);
		p = new ImageIcon(pResize);
		s = new ImageIcon(sResize);
		
		JButton rock = new JButton(r);
		JButton paper = new JButton(p);
		JButton scissors = new JButton(s);
		
		GridLayout layout = new GridLayout();
		layout.setHgap(40);
		
		pnl.setLayout(layout);
		pnl.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
		
		pnl.add(rock);
		pnl.add(paper);
		pnl.add(scissors);		
		
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == rock)
				{
					GameController.RockBtn();
					canvas.repaint();
				}
				else if(e.getSource() == paper)
				{
					GameController.PaperBtn();
				}
				else if(e.getSource() == scissors)
				{
					GameController.ScissorsBtn();
				}
			}
		};

		rock.addActionListener(listener);
		paper.addActionListener(listener);
		scissors.addActionListener(listener);
		
	}

	@Override
	public void buildCanvas() {
		class Canvas extends JPanel
		{
	
			public void paintComponent(Graphics g)
			{				
				super.paintComponent(g);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
				g.drawString(GameController.compMsg, 200, 50);
				g.drawString(GameController.myMsg, 700, 50);
				g.drawString(GameController.msg, 350, 200);		
			}
		}
		canvas = new Canvas();
	}

	@Override
	public JFrame getFrame() {
		JFrame frame = new JFrame("Game");

		frame.add(pnl, "North");
		frame.add(canvas, "Center");
		frame.setSize(1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}

}


