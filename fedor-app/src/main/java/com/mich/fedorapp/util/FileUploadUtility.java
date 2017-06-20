package com.mich.fedorapp.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	private static final String ABS_PATH = "/home/magi/git/fedorApp/fedor-app/src/main/webapp/assets/images/";
	private static String REAL_PATH = "";

	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);

	public static void uploadFile(HttpServletRequest request, MultipartFile file, String imgUrl) {

		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");

		logger.info(REAL_PATH);
		logger.info(ABS_PATH);

		if (!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs();
		}
		if (!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();
		}
		try {
			file.transferTo(new File(REAL_PATH + imgUrl + ".jpg"));
			file.transferTo(new File(ABS_PATH + imgUrl + ".jpg"));

		} catch (IOException e) {

		}
	}
}