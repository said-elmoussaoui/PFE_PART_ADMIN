package ma.adria.controller;


import ma.adria.entities.Batch;
import ma.adria.services.impl.BatchServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batch")
public class BatchController {

    private BatchServiceImpl batchService;

    public BatchController(BatchServiceImpl batchService){
        this.batchService = batchService;
    }

    @PostMapping("/")
    public Batch save(@RequestBody Batch batch){
        return batchService.save(batch);
    }
    @GetMapping("/")
    public List<Batch> getAll(){
        return batchService.getAllBatchs();
    }
    @PutMapping("/{id}")
    public Batch update(@PathVariable Long id,@RequestBody Batch batch){
        return batchService.update(id,batch);
    }
    @GetMapping("/{id}")
    public Batch getBatch(@PathVariable Long id){
        return batchService.getBatch(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        batchService.delete(id);
    }

}
