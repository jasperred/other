import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * Copyright &reg; 2010 Shanghai Magme Co. Ltd.
 * All right reserved.
 */

/**
 * 该程序尚未达到应用要求
 * @author jacky_zhou
 * @date 2011-7-20
 * @version $id$
 */
public class AdjustJSCSSVersion {  

    private static Logger log = Logger.getLogger(AdjustJSCSSVersion.class);
    
    public static String APP_PATH="D:\\web server\\apache-tomcat-6.0.20\\webapps\\ricoh";
    
    public static Map<String,String> map=new HashMap<String,String>();
    
    public static Map<String,String> map1=new HashMap<String,String>();
    
    public static Map<String,String> map2=new HashMap<String,String>();
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub 
        log.info("程序开始运行");
        log.info("步骤一:检查是否存在同名的JS或者CSS文件");
        check(new File(APP_PATH));
//        if(map2.isEmpty()){
//            log.info("检查通过,不存在同名的JS或者CSS文件,可以往下运行");
//        }else{
//            log.info("检查不通过,存在以下同名的JS或者CSS文件:");
//            for(String key:map2.keySet()){
//                //log.info(key);
//                System.out.println(key);
//            }
//            log.info("程序退出");
//            return ;
//        }
        SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmm");
        String version=sf.format(new Date());
        log.info("自动生成此次发布的版本号:"+version);
        renameJSCSS(new File(APP_PATH),version);
        for(String key:map.keySet()){
        	log.info(key+"->"+map.get(key));
        }

        adjustJSCSSVersion(new File(APP_PATH));
    }
    
    /**
     * 检查是否存在同名的文件
     * @param f
     */
    public static void check(File f){
        if(!f.exists()){
            return;
        }else{
            if(f.isFile()){
                if(f.getName().toLowerCase().endsWith(".css")||f.getName().toLowerCase().endsWith(".js")){
                   if(f.getAbsolutePath().contains("\\lib\\")
            		||f.getAbsolutePath().contains("\\js\\common\\")){
                	   //System.out.println(f.getName()+","+f.getAbsolutePath());
                        if(map1.containsKey(f.getName())){
                            map2.put(f.getAbsolutePath(), f.getName());
                            map2.put(map1.get(f.getName()), f.getName());
                        }else{
                            map1.put(f.getName(), f.getAbsolutePath());
                        }
                    }
                }
            }else{
                File[] fs=f.listFiles();
                for(File file:fs){
                    check(file);
                }
            }
        }
    }
    
    public static void adjustJSCSSVersion(File f){
        if(!f.exists()){
            return;
        }else{
            //System.out.println(f.getAbsolutePath());
            if(f.isFile()){
                if(f.getName().toLowerCase().endsWith(".html")
                        ||f.getName().toLowerCase().endsWith(".htm")
                        ||f.getName().toLowerCase().endsWith(".jsp")
                        ||f.getName().toLowerCase().endsWith(".css")
                        ||f.getName().toLowerCase().endsWith(".ftl")){
                    try {
                        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(f),"utf-8"));
                        PrintWriter pw=new PrintWriter(f.getAbsolutePath()+".temp");
                        String line=null;
                        do{
                            line=br.readLine();
                            if(line!=null){
                                Set<String> keys=map.keySet();
                                for(String key:keys){
                                    if(line.contains(key)&&!line.contains("extjs")&&!line.contains("admin_js")){
                                        line=line.replaceAll(key, map.get(key));
                                    }
                                }
                                pw.println(line);
                            }
                        }while(line!=null);
                        br.close();
                        pw.close();
                        mv(f.getAbsolutePath()+".temp",f.getAbsolutePath());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }else{
                File[] fs=f.listFiles();
                for(File file:fs){
                    adjustJSCSSVersion(file);
                }
            }
        }
    }
    /**
     * 给JS和CSS文件加上版本号
     */
    public static void renameJSCSS(File f,String version){
        if(!f.exists()){
            return;
        }else{
            if(f.isFile()){
                if(f.getName().toLowerCase().endsWith(".css")||f.getName().toLowerCase().endsWith(".js")){
                    if(f.getAbsolutePath().contains("\\lib\\")||f.getAbsolutePath().contains("\\js\\common\\")){
                        String oldfilename=f.getName();
                        int index=oldfilename.lastIndexOf(".");
                        String newfilename=oldfilename.substring(0,index)+"."+version+oldfilename.substring(index);
                        if(!map.containsValue(oldfilename)){
                            if(cp(f.getParentFile().getAbsolutePath()+File.separator+oldfilename,f.getParentFile().getAbsolutePath()+File.separator+newfilename)){
                                map.put(oldfilename, newfilename);
                            }
                        }
                    }
                }
            }else{
                File[] fs=f.listFiles();
                for(File file:fs){
                    renameJSCSS(file,version);
                }
            }
        }
    }
    
    public static boolean mv(String src,String dest){
        File sf=new File(src);
        if(!sf.exists()){
            return false;
        }else{
            if(sf.isFile()){
                try {
                    FileInputStream fis=new FileInputStream(sf);
                    FileOutputStream fos=new FileOutputStream(dest);
                    byte[] bs=new byte[10240];
                    int cnt=0;
                    do{
                        cnt=fis.read(bs);
                        if(cnt>0){
                            fos.write(bs, 0, cnt);
                        }
                    }while(cnt>0);
                    fis.close();
                    fos.close();
                    sf.deleteOnExit();
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }else{
                return false;
            }
        }
    }
    
    public static boolean cp(String src,String dest){
        File sf=new File(src);
        if(!sf.exists()){
            return false;
        }else{
            if(sf.isFile()){
                try {
                    FileInputStream fis=new FileInputStream(sf);
                    FileOutputStream fos=new FileOutputStream(dest);
                    byte[] bs=new byte[10240];
                    int cnt=0;
                    do{
                        cnt=fis.read(bs);
                        if(cnt>0){
                            fos.write(bs, 0, cnt);
                        }
                    }while(cnt>0);
                    fis.close();
                    fos.close();
                    sf.deleteOnExit();
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }else{
                return false;
            }
        }
    }
    
    

}
