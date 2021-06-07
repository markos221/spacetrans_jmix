package com.company.spacetrans.app;

import com.company.spacetrans.entity.Planet;
import com.opencsv.bean.CsvToBeanBuilder;
import io.jmix.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.company.spacetrans.service.CsvUploadService;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

@Component(CsvUploadController.NAME)
@RestControllerEndpoint(id = "test-api")
public class CsvUploadController implements CsvUploadService {

    @Autowired
    DataManager dataManager;

    @Autowired
    protected AccessManager accessManager;

    @Override
    public void uploadCsv(Reader reader) {

        List<PlanetCsvDto> planetCsvList = new ArrayList<>();

        planetCsvList = new CsvToBeanBuilder(reader).withSeparator(',')
                .withType(PlanetCsvDto.class)
                .build()
                .parse();


        for (PlanetCsvDto planetCsv: planetCsvList) {
            FluentValueLoader<Planet> planetOldList = dataManager
                    .loadValue("select s from planet s where s.name = :name", Planet.class)
                    .parameter("name", planetCsv.getName());
            if (planetOldList.list().size() == 0) {
                Planet planetNew = dataManager.create(Planet.class);
                SaveContext saveContext = new SaveContext();
                planetNew.setName(planetCsv.getName());
                planetNew.setOrbitalPeriod(planetCsv.getOrbitalPeriod());
                planetNew.setSemiMajorAxis(planetCsv.getSemiMajorAxis());
                planetNew.setRotationPeriod(planetCsv.getRotationPeriod());
                saveContext.saving(planetNew);
                //dataManager.create(planetNew.getClass());
                dataManager.save(saveContext);
            } else {
                Planet planetOld = planetOldList.one();

                if (!planetOld.equals(null)) {
                    planetOld.setName(planetCsv.getName());
                    planetOld.setOrbitalPeriod(planetCsv.getOrbitalPeriod());
                    planetOld.setSemiMajorAxis(planetCsv.getSemiMajorAxis());
                    planetOld.setRotationPeriod(planetCsv.getRotationPeriod());
                    dataManager.save(planetOld);
                } else {
                    Planet planetNew = dataManager.create(Planet.class);
                    SaveContext saveContext = new SaveContext();
                    planetNew.setName(planetCsv.getName());
                    planetNew.setOrbitalPeriod(planetCsv.getOrbitalPeriod());
                    planetNew.setSemiMajorAxis(planetCsv.getSemiMajorAxis());
                    planetNew.setRotationPeriod(planetCsv.getRotationPeriod());
                    saveContext.saving(planetNew);
                    //dataManager.create(planetNew.getClass());
                    dataManager.save(saveContext);
                }
            }
        }
    }
    /*protected void checkFileUploadPermission() {
        RestFileUploadContext uploadContext = new RestFileUploadContext();
        accessManager.applyRegisteredConstraints(uploadContext);
        if (uploadContext.isPermitted()) {
            throw new RestAPIException("File upload failed", "File upload is not permitted", HttpStatus.FORBIDDEN);
        }
    }

    protected void checkCsvFilePermission() {
        UploadCsvFileContext uploadContext = new UploadCsvFileContext();
        accessManager.applyRegisteredConstraints(uploadContext);
        if (!uploadContext.isPermitted()) {
            throw new RestAPIException("Csv File upload failed" + uploadContext.isPermitted(), "Csv File upload is not permitted" + uploadContext.isPermitted(), HttpStatus.FORBIDDEN);
        }
    }*/

    @PostMapping("/uploadCsv")
    @ResponseBody
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        //checkCsvFilePermission();
        Reader reader = new InputStreamReader(file.getInputStream());
        uploadCsv(reader);
        return new ResponseEntity<>("REST end point", HttpStatus.OK);
    }
}