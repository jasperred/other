package com.ami.ec.channel.common;
import net.sf.jftp.config.Settings;
import net.sf.jftp.net.ConnectionHandler;
import net.sf.jftp.net.ConnectionListener;
import net.sf.jftp.net.FtpConnection;
import net.sf.jftp.net.BasicConnection;
import net.sf.jftp.net.wrappers.SftpConnection;

import java.util.HashMap;

import com.sshtools.j2ssh.configuration.SshConnectionProperties;

public class JftpUtil implements ConnectionListener {

    private boolean isThere = false;

    private ConnectionHandler handler = new ConnectionHandler();

    private HashMap connectPool = new HashMap();
    
    //private Settings setting = new Settings();

    public BasicConnection initConnection(String serverType, String host, int port, String user, String passwd) {
        //setting.setProperty("jftp.disableLog", true);//设置Log功能关闭，关闭控制台msg
        if(serverType.equalsIgnoreCase("ftp")){//建立ftp链接
            FtpConnection con = new FtpConnection(host, port, "/");
            con.addConnectionListener(this);
            con.setConnectionHandler(handler);
            con.login(user, passwd);
            
            while (!isThere) {
                try {
                    Thread.sleep(10);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (isThere) {
                return con;
            } else {
                return null;
            }
        }else{//建立sftp连接
            SftpConnection sftp_con = null;
            SshConnectionProperties pro = new SshConnectionProperties();
            pro.setHost(host);
            pro.setPort(port);
            sftp_con = new SftpConnection(pro);
            sftp_con.addConnectionListener(this);
            if(sftp_con.login(user, passwd)){
                return sftp_con;
            }else{
                return null;
            }

        }
        
    }

    @SuppressWarnings("unchecked")
    public BasicConnection getConnection(String serverType, String host, int port, String user, String passwd){
        if (this.connectPool.isEmpty()) {
            BasicConnection tmp = this.initConnection(serverType, host, port, user, passwd);
                if(tmp == null || !tmp.isConnected()){
                    return null;
                }else{
                    this.connectPool.put(host, tmp);
                    return tmp;
                }
        } else {
            BasicConnection connection = (BasicConnection) this.connectPool.get(host);
            if (connection != null) {
                return connection;
            } else {
                BasicConnection tmp = this.initConnection(serverType, host, port, user, passwd);
                if(tmp == null || !tmp.isConnected()){
                    return null;
                }else{
                    return tmp;
                }
            }
        }
    }

    public boolean ftpUpload(BasicConnection con, String dir, String file) {
        
        if(con == null){
            return false;
        }else{
            //make dirs
            String path = "";
            String[] paths = dir.split("/");
            for (int i = 0; i < paths.length; i++) {
                path += "/" + paths[i];
                if (!con.chdir(path)) {
                    con.mkdir(path);
                }
            }
            con.chdir(dir);
            con.upload(file);
            return true;
        }
    }
    
    public boolean sftpUpload(BasicConnection con, String destination, String source, String file) {
        
        if(con == null){
            return false;
        }else{
            //make dirs
            String path = "";
            String[] paths = destination.split("/");
            for (int i = 0; i < paths.length; i++) {
                path += "/" + paths[i];
                if (!con.chdir(path)) {
                    con.mkdir(path);
                }
            }
            con.chdir(destination);
            con.setLocalPath(source);
            con.upload(file);
            return true;
        }
    }

    public void release() throws Exception {
        try {
            if(connectPool!=null && !connectPool.isEmpty()){
                Object[]obj = connectPool.values().toArray();
                for(int i=0;i<obj.length;i++){
                    BasicConnection connect = (BasicConnection)obj[i];                    
                    if(connect != null && connect.isConnected()){
                        connect.disconnect();
                    }
                }
                connectPool.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String argv[]) {

        JftpUtil g = new JftpUtil();
        BasicConnection conn;
        conn = g.getConnection("ftp", "210.22.126.220", 21, "JWKFTP", "jwkftp");
        
        // g.ftpUpload(conn, "/home/lin.ye", "e:/tmp/test1.txt");
        g.sftpUpload(conn, "/", "d:/", "ec-log.html");

        try {
            g.release();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void updateRemoteDirectory(BasicConnection con) {
        System.out.println("new path is: " + con.getPWD());
    }

    public void connectionInitialized(BasicConnection con) {
        isThere = true;
    }

    public void updateProgress(String file, String type, long bytes) {
    }

    public void connectionFailed(BasicConnection con, String why) {
        System.out.println("connection failed!");
    }

    public void actionFinished(BasicConnection con) {
    }

}

