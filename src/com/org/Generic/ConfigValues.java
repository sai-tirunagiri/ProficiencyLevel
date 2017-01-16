package com.org.Generic;

import java.sql.Connection;


public class ConfigValues {
		
		private Connection connection;
		
		String ConfigValue;
		
		public String getConfigValue() {
			
			return ConfigValue;
		}
		public void setConfigValue(String configValue) {
			ConfigValue = configValue;
		}
		public Connection getConnection() {
			return connection;
		}
		public void setConnection(Connection connection) {
			this.connection = connection;
		}
		
		}
		
		
		
