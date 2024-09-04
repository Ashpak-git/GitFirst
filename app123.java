
import java.io.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class app123 extends Applet implements ActionListener,Runnable
{
	Thread t;
	Button b1;

	public void init()
	{
		t=new Thread(this);
	}
	public void start()
	{
		b1=new Button("OK");

		add(b1);

		setSize(400,400);
		setVisible(true);

		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object ob=ae.getSource();

		if (ob==b1)
		{
			t.start();
		}
	}
	public void run()
	{
		try
		{
			while (true)
			{
				b1.setVisible(true);
				t.sleep(100);

				b1.setVisible(false);
				t.sleep(100);

			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

