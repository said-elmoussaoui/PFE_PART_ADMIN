package ma.adria.controller;

import ma.adria.entities.ColumnStructure;
import ma.adria.services.impl.ColumnStructureServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/column")
public class ColumnStructureController {
    private ColumnStructureServiceImpl columnStructureService;
    public ColumnStructureController(ColumnStructureServiceImpl columnStructureService){
        this.columnStructureService = columnStructureService;
    }
    @PostMapping("/")
    public ColumnStructure save(@RequestParam Long structure,@RequestBody ColumnStructure columnStructure){
        return columnStructureService.save(columnStructure,structure);
    }
    @GetMapping("/{id}")
    public ColumnStructure getColumnStructure(@PathVariable Long id){
        return columnStructureService.getColumn(id);
    }

    @GetMapping("/structure/{id}")
    public List<ColumnStructure> getColumnsOfStructure(@PathVariable Long id){
        return columnStructureService.getColumnByStructure(id);
    }
    @PutMapping("/{id}")
    public ColumnStructure update(@PathVariable Long id,@RequestBody ColumnStructure columnStructure){
        return columnStructureService.update(id,columnStructure);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        columnStructureService.delete(id);
    }
}
