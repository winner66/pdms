package com.chk.pdms.common.utils;

import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

public class FileUtil {

	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
		File targetFile = new File(filePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(filePath + fileName);
		out.write(file);
		out.flush();
		out.close();
	}

	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static String renameToUUID(String fileName) {
		return UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
	}

	//1.jpg->1.snowFlake.jpp
	public static String renameUploadFile(String fileName){
		return SnowflakeIdWorker.nextID() + "__" + fileName;
	}

	//1.snowFlake.jpp->1.jpg
	public static String unRenameUploadFile(String fileName){
		if (StringUtils.isBlank(fileName)){
			return null;
		}
		if (StringUtils.contains(fileName, "/")) {
			fileName = StringUtils.substringAfterLast(fileName, "/");
		}
		if (StringUtils.split(fileName, "__").length >= 2) {
			return StringUtils.substringAfter(fileName, "__");
		}else{
			return fileName;
		}
	}

	@SneakyThrows
	public static String transferTo(MultipartFile multipartFile, String filePath, String fileDir) {
		if (multipartFile != null && !multipartFile.isEmpty()) {
			String path = filePath + "/" + fileDir;
			String fileName = FileUtil.renameUploadFile(multipartFile.getOriginalFilename());
			File dir = new File(path);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File file = new File(path + "/" + fileName).getAbsoluteFile();
			multipartFile.transferTo(file);
			return "/files/" + fileDir + "/" + fileName;
		}
		return null;
	}


	public static void main(String[] args) {
		System.out.println(renameUploadFile("1.jpg"));
		System.out.println(renameUploadFile("1.2.jpg"));
		System.out.println(renameUploadFile("12jpg"));

		System.out.println(unRenameUploadFile(renameUploadFile("1.jpg")));
		System.out.println(unRenameUploadFile(renameUploadFile("1.2.jpg")));
		System.out.println(unRenameUploadFile(renameUploadFile("12jpg")));
		System.out.println(unRenameUploadFile(renameUploadFile("12jpg")));

		System.out.println(unRenameUploadFile("1.jpg"));
		System.out.println(unRenameUploadFile("1.2.jpg"));
		System.out.println(unRenameUploadFile("/12jpg"));
		System.out.println(unRenameUploadFile("c/12jpg"));
		System.out.println(unRenameUploadFile("1/b/12jpg"));
	}
}
