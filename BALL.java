// BALL IN MIDDLE

import java.io.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class BALL extends Applet implements ActionListener,Runnable
{
	Thread t;
	Button b1,b2;
	int x=0,y=0;
	int a=0,b=0;
	int c=0,d=0;
	int e=0,f=0;

	public void init()
	{
		t=new Thread(this);
	}
	public void start()
	{
		b1=new Button("START");
		b2=new Button("STOP");

		add(b1);
		add(b2);

		x=600;
		y=300;
		a=600;
		b=300;
		c=600;
		d=300;
		e=600;
		f=300;

		setSize(400,400);
		setVisible(true);

		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object ob=ae.getSource();

		if(ob==b1)
		{
			t.start();
		}
		else
		{
			if(ob==b2)
			{
				t.stop();
			}
		}
	}
	public void run()
	{
		try
		{
			while(true)
			{
			// MOVE BALL RIGHT
				if(x<=900)
				{
					x=x+10;
					repaint();
					t.sleep(50);

					if(x==900)
					{
						x=600;
					}
				}
			// MOVE BALL UPPER SIDE
				if(b>=0)
				{
					b=b-10;
					repaint();
					t.sleep(50);

					if(b==0)
					{
						b=300;
					}
				}
			// MOVE BALL LEFT
				if(c>=300)
				{
					c=c-10;
					repaint();
					t.sleep(50);

					if(c==300)
					{
						c=600;
					}
				}
			// MOVE BALL BOTTOM
				if(f<=600)
				{
					f=f+10;
					repaint();
					t.sleep(50);

					if(f==600)
					{
						f=300;
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.fillOval(x,y,100,100);

		g.setColor(Color.BLUE);
		g.fillOval(a,b,100,100);

		g.setColor(Color.YELLOW);
		g.fillOval(c,d,100,100);

		g.setColor(Color.BLACK);
		g.fillOval(e,f,100,100);

		g.setColor(Color.RED);
		g.fillOval(600,300,100,100);
	}
}