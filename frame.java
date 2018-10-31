import java.awt.*;
class MyFrame extends Frame
{
	public static void main(String args[])
	{
		MyFrame f=new MyFrame();
		//or
		//Frame f=new MyFrame();
		//or
		//Frame f=new Frame(); // no need to extends

		Button b1=new Button("Ok");
		Font f1=new Font(Font.SERIF,Font.BOLD+Font.ITALIC,40);
		b1.setFont(f1);
		f.add(b1);

		f.setTitle("First Frame");

		f.setSize(200,300);
		f.setLocation(50,50);
		//or
		//f.setBounds(50,50,200,300);
		//or
		/*Point p=new Point(50,50);
		Dimension d=new Dimension(200,300);
		Rectangle r=new Rectangle(p,d);
		f.setBounds(r);*/

//Dimension d2=f.getSize();
//S.o.p(d2.width+","+d2.height);

		//f.setResizable(false);
		//f.setUndecorated(true);
		f.setBackground(Color.cyan);
		f.setForeground(Color.red);
		f.setVisible(true);
		//or
		//f.show(); //deprecated
	}
}



