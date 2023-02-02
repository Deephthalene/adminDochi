package com.vue.dochiAdmin.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class S3Service {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    public String bucket;

    public String upload(MultipartFile multipartFile, String dirName) throws IOException{
    	// s3같은경우는 file 을 올리수있는거고 , 웹같은경우는 백으로 넘겨줄때 multipartfile 로 넘겨줘가지구
    	// multipartfile 을 file로 바꿔주는거야 
    	// 이해감? ㅇㅇ 여기는 이거 읽어보긴했어 ㅇㅇ 그래서 봐꿔준다음에 
    	// 릐턴 파일 업로드
        File uploadFile = convert(multipartFile);
        return upload(uploadFile, dirName); // <- 그럼 다시 이친구가 경로를 다시 리턴해주면
    }
    // S3로 파일 업로드하기
    private String upload(File uploadFile, String dirName) {
    	// 그래서 일로와
    	// 나머지는 그렇게 어려울게없어
        String fileName = dirName;  // S3에 저장된 파일 이름
        String uploadImageUrl = putS3(uploadFile, fileName); // s3로 업로드 <-이게 핵심인데
        removeNewFile(uploadFile);
        return uploadImageUrl;
    }

    // S3로 업로드
    private String putS3(File uploadFile, String fileName) {
    	//이거는 이해를 안해도되는게 s3에서 만들어준 api 기떄문에 
    	// 파일업로드하실라면 파라미터 지켜서 넣으면 알아서 올라가요~ 같은 느낌이라 이해할 필요가없어
    	// 그래서 결국
		amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile).withCannedAcl(CannedAccessControlList.PublicRead)); // <-- 이친구가 파일업로드를 알아서 해주고
        return amazonS3Client.getUrl(bucket, fileName).toString(); // <-- 이 친구가 업로드 된 파일의 경로를 리턴해줍니다
    }

    // 로컬에 저장된 이미지 지우기
    private void removeNewFile(File targetFile) {
        if (targetFile.delete()) {
            log.info("File delete success");
            return;
        }
        log.info("File delete fail");
    }

    private File convert(MultipartFile file) throws IOException{
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
    
    
}