package com.hyomee.work.loading.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hyomee.core.customException.BizException;
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
  private final Gson gson;

  public void loadingTourlist(@NonNull String filename) {

    Reader reader = fileLoad(filename);
    List<TourlistDTO> tourlistDTOs =  gson.fromJson(reader,
            new TypeToken<List<TourlistDTO>>(){}.getType() );
    List<TourlistEntity> tourlistEntities = WorkMapper.INSTANCE.toTourlistEntitys(tourlistDTOs);
    tourlistRepository.saveAll(tourlistEntities);

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
