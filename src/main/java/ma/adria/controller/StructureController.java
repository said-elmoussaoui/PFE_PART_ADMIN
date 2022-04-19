package ma.adria.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.adria.entities.Structure;
import ma.adria.services.impl.StructureServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Structure> getAll(){
        return structureService.getAllStructures();
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
    public List<Structure> getStructuresOfBatch(@PathVariable Long id){
        return structureService.getStructuresByBatch(id);
    }
}
