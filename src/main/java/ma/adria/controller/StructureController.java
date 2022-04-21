package ma.adria.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.adria.entities.Structure;
import ma.adria.services.impl.StructureServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/structure")
@Api("gestion des structure")
public class StructureController {
    private StructureServiceImpl structureService;

    public StructureController(StructureServiceImpl structureService){
       this.structureService = structureService;
    }

    @PostMapping("/")
    @ApiOperation("save structure")
    public Structure save(@RequestBody Structure structure,@RequestParam Long batch){
        return structureService.save(structure,batch);
    }
    @GetMapping("/")
    @ApiOperation("get all structures")
    public Page<Structure> getAll(@RequestParam(name = "page", defaultValue = "0")int page,
                                  @RequestParam(name = "size", defaultValue = "6") int size){
        return structureService.getAllStructures(PageRequest.of(page, size));
    }
    @PutMapping("/{id}")
    @ApiOperation("update structure")
    public Structure update(@PathVariable Long id,@RequestBody Structure structure){
        return structureService.update(id,structure);
    }
    @GetMapping("/{id}")
    @ApiOperation("get structure by id")
    public Structure getStructure(@PathVariable Long id){
        return structureService.getStructure(id);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("delete structure")
    public void delete(@PathVariable Long id){
        structureService.delete(id);
    }
    @GetMapping("/batch/{id}")
    @ApiOperation("get structure by batch id")
    public Page<Structure> getStructuresOfBatch(@PathVariable Long id,
                                                @RequestParam(name = "page", defaultValue = "0")int page,
                                                @RequestParam(name = "size", defaultValue = "6") int size){
        return structureService.getStructuresByBatch(id, PageRequest.of(page, size));
    }
    @GetMapping("/batch/{batchCode}/codeBank/")
    @ApiOperation("get structure by code bank")
    public Page<Structure> getBatchByTypeProcess(@RequestParam(name = "page", defaultValue = "0")int page,
                                                 @RequestParam(name = "size", defaultValue = "6") int size,
                                                 @PathVariable Long batchCode,
                                                 @RequestParam(name = "codeBank", defaultValue = "")String codeBank){
        return structureService.getByCodeBank(batchCode,codeBank, PageRequest.of(page, size));
    }
}
