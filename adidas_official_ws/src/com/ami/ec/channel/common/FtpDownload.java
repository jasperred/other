package com.ami.ec.channel.common;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import net.sf.jftp.config.Settings;
import net.sf.jftp.net.BasicConnection;
import net.sf.jftp.net.ConnectionHandler;
import net.sf.jftp.net.ConnectionListener;
import net.sf.jftp.net.FtpConnection;

public class FtpDownload implements ConnectionListener {
	// is the connection established?
	private boolean isThere = false;

	public static long time = 0;

	// connection pool, not necessary but you should take a look at this class
	// if you want to use multiple event based ftp transfers.
	private ConnectionHandler handler = new ConnectionHandler();

	private String host;
	private int port = 21;
	private String user;
	private String passwd;

	public FtpDownload(String host, int port, String user, String passwd) {
		this.host = host;
		this.port = port;
		this.user = user;
		this.passwd = passwd;
	}

	// creates a FtpConnection and downloads a file
	public byte[] downloadToBinary(String file) {
		// the ftp client default is very small, you may want to increase this
		Settings.bufferSize = 16384;

		long current = System.currentTimeMillis();
		// System.out.println("1) "+(System.currentTimeMillis()-current)+"ms.");

		// create a FtpConnection - note that it does *not* connect instantly
		FtpConnection con = new FtpConnection(host);

		// set updatelistener, interface methods are below
		con.addConnectionListener(this);

		// set handler
		con.setConnectionHandler(handler);

		// connect and login. this is from where connectionFailed() may be
		// called for example
		con.login(user, passwd);

		// login calls connectionInitialized() below which sets isThere to true
		while (!isThere) {
			try {
				Thread.sleep(10);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		// get download input stream
		byte[] bytes = null;
		try {
			InputStream is = con.getDownloadInputStream(file);
			ByteArrayOutputStream bais = new ByteArrayOutputStream();
			int bit = 0;
			while ((bit = is.read()) != -1) {
				bais.write(bit);
			}
			bytes = bais.toByteArray();
		} catch (Exception e) {
		}
		time = (System.currentTimeMillis() - current);

		System.out.println("Download took " + time + "ms.");

		return bytes;
	}

	// download welcome.msg from sourceforge or any other given file
	public static void main(String argv[]) {
		FtpDownload f = new FtpDownload("192.168.1.10", 2009, "test", "test");
		byte[] bs = f.downloadToBinary("/aaa.jpg");
	}

	// ------------------ needed by ConnectionListener interface
	// -----------------

	// called if the remote directory has changed
	public void updateRemoteDirectory(BasicConnection con) {
		System.out.println("new path is: " + con.getPWD());
	}

	// called if a connection has been established
	public void connectionInitialized(BasicConnection con) {
		isThere = true;
	}

	// called every few kb by DataConnection during the trnsfer (interval can be
	// changed in Settings)
	public void updateProgress(String file, String type, long bytes) {
	}

	// called if connection fails
	public void connectionFailed(BasicConnection con, String why) {
		System.out.println("connection failed!");
	}

	// up- or download has finished
	public void actionFinished(BasicConnection con) {
	}
}
