package com.contais.dto;

import lombok.Data;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.dto
 * @date 2018/9/18
 */
@Data
public class FileInfo {

    private String path;

    public FileInfo() {
    }

    public FileInfo(String path) {

        this.path = path;
    }



}
