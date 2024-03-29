package ma.adria.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.adria.entities.ColumnStructure;
import ma.adria.enums.ColumnType;
import ma.adria.services.impl.ColumnStructureServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/column")
@Api("gestion des colonnes")
public class ColumnStructureController {
    private ColumnStructureServiceImpl columnStructureService;
    public ColumnStructureController(ColumnStructureServiceImpl columnStructureService){
        this.columnStructureService = columnStructureService;
    }
    @PostMapping("/")
    @ApiOperation("save column in structure")
    public ColumnStructure save(@RequestParam Long structure,@RequestBody ColumnStructure columnStructure){
        return columnStructureService.save(columnStructure,structure);
    }
    @GetMapping("/{id}")
    @ApiOperation("get column of a structure")
    public ColumnStructure getColumnStructure(@PathVariable Long id){
        return columnStructureService.getColumn(id);
    }

    @GetMapping("/structure/{id}")
    @ApiOperation("get columns of a structure")
    public Page<ColumnStructure> getColumnsOfStructure(@PathVariable Long id,
                                                       @RequestParam(name = "page", defaultValue = "0")int page,
                                                       @RequestParam(name = "size", defaultValue = "6") int size){
        return columnStructureService.getColumnByStructure(id, PageRequest.of(page, size));
    }
    @PutMapping("/{id}")
    @ApiOperation("update column in structure")
    public ColumnStructure update(@PathVariable Long id,@RequestBody ColumnStructure columnStructure){
        return columnStructureService.update(id,columnStructure);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("delete column in structure")
    public void delete(@PathVariable Long id){
        columnStructureService.delete(id);
    }

    @GetMapping("structure/{structureCode}/search")
    @ApiOperation("get columns by name LIKE , type and mandatory")
    public Page<ColumnStructure> search(@RequestParam(name = "page", defaultValue = "0")int page,
                              @RequestParam(name = "size", defaultValue = "6") int size,
                              @PathVariable Long structureCode,
                              @RequestParam(name = "keyword", defaultValue = "")String keywordName,
                              @RequestParam(name="type",defaultValue = "") ColumnType typeColumn,
                              @RequestParam(name="mandatory",defaultValue = "true") boolean isMandatory
    ){
        return columnStructureService.search(page,size,structureCode,keywordName,typeColumn,isMandatory);
    }

}
