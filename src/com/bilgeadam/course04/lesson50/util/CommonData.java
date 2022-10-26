package com.bilgeadam.course04.lesson50.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CommonData {
	private static final CommonData instance = new CommonData();
	private Connection conn;
	private Properties props;
	private String propertiesFile;
	private Logger logger;
	
	private CommonData() {
		super();
	}

	public static CommonData getInstance() {
//		if (DatabaseConnection.instance == null) {
//			DatabaseConnection.instance = new DatabaseConnection();
//		}
		return CommonData.instance;
	}
	
	public Connection getConnection() {
		if (this.conn == null) {
			try {
				this.conn = DriverManager.getConnection(this.getUrl());
			} catch (SQLException e) {
				System.err.println("Cannot connet to database <<<" + e.getMessage() + ">>>");
				System.exit(1234);
			} 
		}
		return this.conn;
	}
	
	private String getUrl() {
		this.props = this.getProperties();
		// jdbc:postgres://localhost:5432/northwind?user=postgres&password=root
		//"jdbc:postgresql://localhost:5432/northwind?user=postgres&password=root";
		//String url = "jdbc:" + this.props.getProperty("db.driver")+"://";  // String'ler immutable'dır.

		StringBuilder sb = new StringBuilder("jdbc:");
		sb.append(this.props.getProperty("db.driver")).append("://")
		  .append(this.props.getProperty("db.server")).append(":")	
		  .append(this.props.getProperty("db.port")).append("/")	
		  .append(this.props.getProperty("db.name")).append("?user=")
		  .append(this.props.getProperty("db.user.name")).append("&password=")
		  .append(this.props.getProperty("db.user.password"));

		return sb.toString();
	}

	private Properties getProperties() {
		if (this.props == null) {
			if (this.propertiesFile == null) {
				System.err.println("Dosya tanımlı değil");
				System.exit(404);
			}
			try (InputStream is = new FileInputStream(this.propertiesFile)) {
				this.props = new Properties();
				this.props.load(is);
			} catch (Exception e) {
				System.err.println("Dosya okunamadı");
				System.exit(303);
			}
		}
		return this.props;
	}

	public void setPropertiesFile(String propertiesFile) {
		this.propertiesFile = propertiesFile;
	}
	
	private Logger getLogger() {
		if (this.logger == null) {
			this.logger = Logger.getLogger("My beautifull Logger");
			for (Handler handler : logger.getHandlers()) {
				handler.setLevel(Level.SEVERE);
			}
			try {
				String logFileName = this.getProperties().getProperty("logger.fileName");
				FileHandler logFileHandler = new FileHandler(logFileName, false);
				logFileHandler.setFormatter(new SimpleFormatter());
				logFileHandler.setLevel(Level.ALL);
				logger.addHandler(logFileHandler);
			}
			catch (Exception e) {
				System.err.println("Logger yaratılamadı: " + e.getMessage());
				System.exit(1234);
			}
			logger.log(Level.INFO, "Logger yaratıldı");
		}
		return this.logger;
	}
	
	public void basic (String message) {
		System.out.println(message);
	}
	
	public void info (String message) {
		this.getLogger().info("\t---> " + message);
	}
	
	public void warning (String message) {
		this.getLogger().warning("\t---> " + message);
	}
	
	public void error (String message) {
		this.getLogger().severe("\t---> " + message);
	}
}
