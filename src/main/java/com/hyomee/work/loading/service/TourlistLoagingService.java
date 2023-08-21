package com.hyomee.work.loading.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hyomee.core.customException.BizException;
import com.hyomee.work.workEcService.doc.TourListDoc;
import com.hyomee.work.workEcService.dto.TourListEcDTO;
import com.hyomee.work.workEcService.mapper.EcMapper;
import com.hyomee.work.workEcService.repository.TourListDocRepository;
import com.hyomee.work.workService.dto.TourlistDTO;
import com.hyomee.work.workService.entity.TourlistEntity;
import com.hyomee.work.workService.repository.TourlistRepository;
import com.hyomee.work.workService.repository.WorkMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TourlistLoagingService {

  @Value("${tourlistDir}")
  private String tourlistDir;

  private final TourlistRepository tourlistRepository;
  private final TourListDocRepository tourListDOCRepository;
  private final Gson gson;

  public void loadingTourlist(@NonNull String filename) {

    Reader reader = fileLoad(filename);

    List<TourlistDTO> tourlistDTOs =  gson.fromJson(reader,
            new TypeToken<List<TourlistDTO>>(){}.getType() );

    List<TourlistEntity> tourlistEntities = WorkMapper.INSTANCE.toTourlistEntitys(tourlistDTOs);

    tourlistRepository.saveAll(tourlistEntities);

  }

  public void loadingEcTourlist(@NonNull String filename) {

    Reader reader = fileLoad(filename);

    List<TourListEcDTO> tourlistEcDTOs =  gson.fromJson(reader,
            new TypeToken<List<TourListEcDTO>>(){}.getType() );

    List<TourListDoc> tourListDocs = EcMapper.INSTANCE.toTourListDOCs(tourlistEcDTOs);
    int i = 0;
    for (TourListDoc tourListDoc : tourListDocs) {
      tourListDOCRepository.save (tourListDoc);
      i += 1;
      if (i > 10 ) break;
    }


  }

  private Reader fileLoad(String filename) {
    Reader reader = null;
    try {
      reader = new FileReader( this.tourlistDir + filename + ".json");
    } catch (FileNotFoundException e) {
      throw new BizException(filename + " 파일이 없습니다.");
    }
    return reader;
  }


}
