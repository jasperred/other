package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import junit.framework.TestCase;
import Magento.Mage_Api_Model_Server_V2_HandlerBindingStub;
import Magento.Mage_Api_Model_Server_V2_HandlerPortType;
import Magento.MagentoService;
import Magento.MagentoServiceLocator;

import com.ami.ec.channel.util.WebConfigProperties;
import com.ami.ec.channel.ws.OfficialXmlAnalyze;

public class MagentoTest extends TestCase {
	
	public void testMagento()
	{
		long l = System.currentTimeMillis();
		MagentoService ms = new MagentoServiceLocator();
		System.out.println(ms.getMage_Api_Model_Server_V2_HandlerPortAddress());
		try {
			Mage_Api_Model_Server_V2_HandlerPortType ma = ms.getMage_Api_Model_Server_V2_HandlerPort(new URL(WebConfigProperties.getProperties("official.ws.url")));
			Mage_Api_Model_Server_V2_HandlerBindingStub stub = (Mage_Api_Model_Server_V2_HandlerBindingStub)ma;
			stub.setTimeout(1800000);
			//ma.startSession();
			File f = new File("D:\\a.xml");
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String tempString = null;
			StringBuffer content = new StringBuffer();
			while ((tempString = reader.readLine()) != null) {
				content.append(tempString);
            }
			OfficialXmlAnalyze oxa = new OfficialXmlAnalyze();
			System.out.println(content.toString());
			String login = ma.login("Adidas_ami", "adidas@#$8912!@ad");
			String sss = ma.bysoftDeliverResultInfo(login, "");
			ma.endSession(login);
			System.out.println("login:"+sss);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("time:"+(System.currentTimeMillis()-l));
	}

}
