package com.ami.ec.channel.common;

import net.sf.jftp.net.BasicConnection;
import net.sf.jftp.net.ConnectionHandler;
import net.sf.jftp.net.ConnectionListener;
import net.sf.jftp.net.FtpConnection;

import org.apache.log4j.Logger;

public class FtpUpload implements ConnectionListener {
	static Logger logger = Logger.getLogger(FtpUpload.class);
	private boolean isThere = false;

	private ConnectionHandler handler = new ConnectionHandler();

	private String host;
	private int port = 21;
	private String user;
	private String passwd;

	public FtpUpload(String host, String user, String passwd) {
		this.host = host;
		this.user = user;
		this.passwd = passwd;
	}

	public FtpUpload(String host, int port, String user, String passwd) {
		this.host = host;
		this.port = port;
		this.user = user;
		this.passwd = passwd;
	}

	public int upload(String dir, String file) {
		int r = 0;
		try {
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

			// make dirs
			String path = "";
			String[] paths = dir.split("/");
			for (int i = 0; i < paths.length; i++) {
				path += "/" + paths[i];
				if (!con.chdir(path)) {
					con.mkdir(path);
				}
			}
			con.chdir(dir);
			r = con.upload(file);
			con.abort();
			con.disconnect();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return r;
	}

	public static void main(String argv[]) {
		if (argv.length == 3) {
			FtpUpload f = new FtpUpload(argv[0], argv[2], argv[1]);
		} else {
			FtpUpload g = new FtpUpload("210.73.194.11", 2121, "administrator", "ec&Asp4win");
			int r = g.upload("/", "C:/test.xml");
			System.out.println(r);
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
