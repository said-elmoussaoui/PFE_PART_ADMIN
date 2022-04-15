package ma.adria.controller;

import ma.adria.entities.Structure;
import ma.adria.services.impl.StructureServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/structure")
public class StructureController {
    private StructureServiceImpl structureService;

    public StructureController(StructureServiceImpl structureService){
       this.structureService = structureService;
    }

    @PostMapping("/")
    public Structure save(@RequestBody Structure structure,@RequestParam Long batch){
        return structureService.save(structure,batch);
    }
    @GetMapping("/")
    public List<Structure> getAll(){
        return structureService.getAllStructures();
    }
    @PutMapping("/{id}")
    public Structure update(@PathVariable Long id,@RequestBody Structure structure){
        return structureService.update(id,structure);
    }
    @GetMapping("/{id}")
    public Structure getStructure(@PathVariable Long id){
        return structureService.getStructure(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        structureService.delete(id);
    }
    @GetMapping("/batch/{id}")
    public List<Structure> getStructuresOfBatch(@PathVariable Long id){
        return structureService.getStructuresByBatch(id);
    }
}
