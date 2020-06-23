import java.net.*;
class A
{
	public static void main(String args[])throws UnknownHostException
	{
		InetAddress inet1=InetAddress.getByName("www.google.co.in");
		System.out.println(inet1.getHostAddress());

		InetAddress inet2[]=InetAddress.getAllByName("www.yahoo.com");
		for(int i=0;i<inet2.length;i++)
			System.out.println(inet2[i].getHostAddress());

		InetAddress inet=InetAddress.getLocalHost();
		System.out.println(inet.getHostAddress());
		System.out.println(inet.getHostName());
		System.out.println(inet.toString());
		byte b[]=inet.getAddress();
		for(byte n:b)
			System.out.print((n&255)  +"\t");

		byte b1[]={(byte)192,(byte)168,0,104};
		InetAddress inet3=InetAddress.getByAddress(b1);
		System.out.println("\n"+inet3.toString());

	}
}
