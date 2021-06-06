package com.company.spacetrans.service;


import org.springframework.stereotype.Service;

import java.io.Reader;

@Service
public interface CsvUploadService {
    String NAME = "CsvUploadService";

    void uploadCsv(Reader reader);
}
