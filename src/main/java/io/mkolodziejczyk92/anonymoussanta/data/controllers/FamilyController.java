package io.mkolodziejczyk92.anonymoussanta.data.controllers;


import io.mkolodziejczyk92.anonymoussanta.data.model.FamilyDto;
import io.mkolodziejczyk92.anonymoussanta.data.service.FamilyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/family")
public class FamilyController {
    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }
//
//    @PostMapping
//    public void createFamily(@RequestBody FamilyDto familyDto) {
//        FamilyDto savedFamily = familyService.saveFamily(familyDto);
//    }
//
//    @GetMapping
//    public List<FamilyDto> getAllFamilies() {
//        return FamilyService.getAllFamilies();
//    }
//
//    @PutMapping("/{id}")
//    public void updateFamilyById(@RequestBody FamilyDto familyDto, @PathVariable Long id) {
//        familyService.updateFamilyById(id, familyDto);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteFamilyById(@PathVariable Long id) {
//        familyService.deleteFamily(id);
//    }
}
