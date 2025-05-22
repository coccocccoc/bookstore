package com.example.demo.book.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.util.StringUtils;

@Component
public class FileUtil {

	// 파일 저장 경로
	@Value("${filepath}")
	String filepath;

	// 업로드된 파일을 저장하는 메소드
	public String fileUpload(MultipartFile file) {
		
		// 전달받은 파일이 없으면 메소드 종료
		if(file.isEmpty()) {
			return null;
		}
		
		// 파일명 꺼내기
		String name = StringUtils.cleanPath(file.getOriginalFilename());
		
		// 파일 전체 경로
		// 기본경로 + 구분자 + 파일명
		Path path = Paths.get(filepath + File.separator + name);
		
		try {
			// 파일 저장
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 저장한 파일의 이름을 반환
		return file.getOriginalFilename();
	}
	
}
