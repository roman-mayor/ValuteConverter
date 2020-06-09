package com.example.demo.Service;

import com.example.demo.Entity.ValuteCursEntity;
import com.example.demo.Repository.ValuteCursRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ValuteCursService {

    private XmlParser xmlParser;
    private ValuteCursRepository valuteCursRepository;


    public ValuteCursService(ValuteCursRepository valuteCursRepository, XmlParser xmlParser) {
        this.valuteCursRepository = valuteCursRepository;
        this.xmlParser = xmlParser;
    }


    @Transactional
    @Scheduled(cron = "0 8 * * * *")
    public void saveAll() throws Exception {

        List<ValuteCursEntity> list = xmlParser.getValuteCursEntity();
        if (!list.isEmpty()) {
            valuteCursRepository.deleteAll();
            valuteCursRepository.saveAll(list);
        } else {
            valuteCursRepository.saveAll(list);
        }
    }
}
