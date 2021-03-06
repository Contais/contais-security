package com.contais.web.controller;

import com.contais.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.web.controller
 * @date 2018/9/18
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${file.upload.folder}")
    private String folder;

    @PostMapping
    public FileInfo upload(MultipartFile file) throws Exception {

        System.out.println("file.getName : " + file.getName());
        System.out.println("file.getOriginalFilename : " + file.getOriginalFilename());
        System.out.println("file.getSize : " + file.getSize());

        File localFile = new File(folder, System.currentTimeMillis() + ".txt");

        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){



        try ( InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
              ServletOutputStream outputStream = response.getOutputStream();) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=text.txt");

            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();

        } catch (Exception e) {
            System.out.println("IO异常.....");
        }
    }
}
