package test;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ami.ec.channel.task.OfficialTask;

public class Test {
	static Logger logger = Logger.getLogger(Test.class);

	private OfficialTask officialTask;
	
	
	public OfficialTask getOfficialTask() {
		return officialTask;
	}


	public void setOfficialTask(OfficialTask officialTask) {
		this.officialTask = officialTask;
	}


	public void testArticleMasterCsv()
	{
		Map param = new HashMap();
		param.put("StoreId", 8100902L);
		param.put("FtpUser", "administrator");
		param.put("FtpPassword", "ec&Asp4win");
		param.put("FtpHost", "210.73.194.11");
		param.put("FtpPort", "2121");
		param.put("FtpPath", "/");
		Map m = officialTask.exportArticleMasterCsv(param);
		logger.info("测试阿迪官网ArticleMaster导出");
		logger.info(m.get("Message"));
	}
	
	public void testPriceSync()
	{
		Map param = new HashMap();
		param.put("StoreId", 8100902L);
		Map m = officialTask.uploadPrice(param);
		logger.info("测试阿迪官网Price");
		logger.info(m.get("Message"));
	}
	
	public void testStockSync()
	{
		Map param = new HashMap();
		param.put("StoreId", 8100902L);
		Map m = officialTask.uploadInventory(param);
		logger.info("测试阿迪官网Inventory");
		logger.info(m.get("Message"));
	}
	
	public void testDeliverResult()
	{
		Map param = new HashMap();
		param.put("StoreId", 8100902L);
		Map m = officialTask.uploadDeliverResult(param);
		logger.info("测试阿迪官网DeliverResult");
		logger.info(m.get("Message"));
	}
	
	public void testReturnResult()
	{
		Map param = new HashMap();
		param.put("StoreId", 8100902L);
		Map m = officialTask.uploadReturnResult(param);
		logger.info("测试阿迪官网ReturnResult");
		logger.info(m.get("Message"));
	}
}
