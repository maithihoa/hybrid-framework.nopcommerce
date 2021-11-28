package javaBasic;

import org.apache.commons.exec.OS;

public class SystemProperties {
	static String projectPath = System.getProperty("user.dir");
	static String osName = System.getProperty("os.name");
	static String fileName = "pyramid.png";
	static String filePath;
	
	public static void main(String[] args) {
		filePath = projectPath + getDirSlash("UploadFiles") + fileName;
		System.out.println(filePath);
	}
	
	public static String getDirSlash(String folderName) {
		if (osName.toLowerCase().startsWith("window")) {
			folderName = "\\" + folderName + "\\";
			
		} else if(osName.toLowerCase().startsWith("mac")){
				folderName = "/" + folderName + "/";
		}
	return folderName;
}
}
