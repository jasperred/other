package test;

import java.util.HashMap;
import java.util.Map;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
  
  
public class SOAPClient  
{ /**
	  * 测试方法
	  * @return
	  * @throws Exception
	  */
	 public static String callManifest() throws Exception {
	  System.out.println("0");
	  Service service = new Service();

	  Call call = (Call) service.createCall();
	  System.out.println("1");
	  call.setTargetEndpointAddress(new java.net.URL("http://localhost/adidas_official_ws/OfficialWebservice")); 
	  call.setOperationName(new javax.xml.namespace.QName("http://ws.channel.ec.ami.com/", "conditionOrder"));
	  System.out.println("2");
	  //call.addParameter("param", org.apache.axis.Constants.SOAP_ARRAY,javax.xml.rpc.ParameterMode.IN);
	  call.addParameter("wsKey", org.apache.axis.Constants.SOAP_STRING, javax.xml.rpc.ParameterMode.IN);
	  call.addParameter("userNo", org.apache.axis.Constants.SOAP_STRING, javax.xml.rpc.ParameterMode.IN);
	  call.setReturnType(org.apache.axis.Constants.XSD_STRING);
	  System.out.println("3");
	  Object obj=call.invoke(new Object[]{"Adidas_ami","adidas@#$8912!@ad"});
	  return obj.toString();
	 }
	 public static void main(String[] args) throws Exception {
	  System.out.println("::: call php webservice :::");
	  String str = callManifest();

	  String result=new String(str.getBytes("iso-8859-1"),"GBK");
	  System.out.println(result);
	 }
	 }
