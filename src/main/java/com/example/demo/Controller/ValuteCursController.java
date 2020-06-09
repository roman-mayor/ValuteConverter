package com.example.demo.Controller;

import com.example.demo.Entity.ConvertHistoryEntity;
import com.example.demo.Entity.ValuteCursEntity;
import com.example.demo.Repository.ConvertHistoryRepository;
import com.example.demo.Repository.ValuteCursRepository;
import com.example.demo.Service.ValuteCursService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@EnableScheduling
public class ValuteCursController {


    private ValuteCursRepository valuteCursRepository;
    private ValuteCursService valuteCursService;
    private ConvertHistoryRepository convertHistoryRepository;


    public ValuteCursController(ValuteCursRepository valuteCursRepository, ValuteCursService valuteCursService, ConvertHistoryRepository convertHistoryRepository) {
        this.valuteCursRepository = valuteCursRepository;
        this.valuteCursService = valuteCursService;
        this.convertHistoryRepository =convertHistoryRepository;
    }


    @GetMapping("/g")
    public void getAll() throws Exception {
        valuteCursService.saveAll();
    }


    @GetMapping("/charcode")
    public Double convertValute(@RequestParam(required = false, defaultValue = "") Integer quantity, @RequestParam(required = false, defaultValue = "") String char_code) throws Exception {
        List<ValuteCursEntity> listcharCodes = valuteCursRepository.findEntities();
        double result;
        String line = null;
        for (ValuteCursEntity valuteCursEntity : listcharCodes) {
            if (char_code.equals(valuteCursEntity.getChar_code())) {
                String x = valuteCursEntity.getValue().replaceAll(",",".");
                result = Double.valueOf(x) * quantity;
                line = String.format("%(.2f", result);
                line = line.replaceAll(",",".");
                List<ConvertHistoryEntity>historyEntities = new ArrayList<>();
                String  fromValute = valuteCursEntity.getChar_code();
                historyEntities.add(new ConvertHistoryEntity(fromValute, "RUB", quantity, Double.valueOf(line)));
                convertHistoryRepository.saveAll(historyEntities);
            }
        }
        return Double.valueOf(line);
    }
}


