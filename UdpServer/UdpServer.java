import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class UdpServer {
	public static void main(String[] args) {
		
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(10000);
			byte[] bs = new byte[1024];
			DatagramPacket dp = new DatagramPacket(bs,bs.length);
			System.out.println("UDP�����Ѿ�����......");
			ds.receive(dp);
			InetAddress inetAddress = ds.getInetAddress();
			byte[] data= dp.getData();
			int length = dp.getLength();
			String str = new String(data,0,length);
			System.out.println(inetAddress.getHostAddress()+"���͵������ǣ�"+str);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ds != null) {
				ds.close();
			}
		}
	}
}