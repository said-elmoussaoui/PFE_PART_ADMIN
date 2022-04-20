package ma.adria.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.adria.entities.Batch;
import ma.adria.enums.TypeBatch;
import ma.adria.enums.TypeProcess;
import ma.adria.services.impl.BatchServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batch")
@Api("gestion des batchs")
public class BatchController {

    private BatchServiceImpl batchService;

    public BatchController(BatchServiceImpl batchService){
        this.batchService = batchService;
    }

    @PostMapping("/")
    @ApiOperation("save batch")
    public Batch save(@RequestBody Batch batch){
        return batchService.save(batch);
    }
    @GetMapping("/")
    @ApiOperation("get all batchs")
    public List<Batch> getAll(){
        return batchService.getAllBatchs();
    }
    @PutMapping("/{id}")
    @ApiOperation("update batch")
    public Batch update(@PathVariable Long id,@RequestBody Batch batch){
        return batchService.update(id,batch);
    }
    @GetMapping("/{id}")
    @ApiOperation("get batch by id")
    public Batch getBatch(@PathVariable Long id){
        return batchService.getBatch(id);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("delete batch")
    public void delete(@PathVariable Long id){
        batchService.delete(id);
    }
    @GetMapping("/name/")
    @ApiOperation("get batch by name LIKE")
    public Page<Batch> getBatchByName(@RequestParam(name = "page", defaultValue = "0")int page,
                                      @RequestParam(name = "size", defaultValue = "6") int size,
                                      @RequestParam(name = "keyword", defaultValue = "")String keyword){
        return batchService.getByNameContains(keyword, PageRequest.of(page, size));
    }
    @GetMapping("/typeBatch/")
    @ApiOperation("get batch by type batch")
    public Page<Batch> getBatchByTypeBatch(@RequestParam(name = "page", defaultValue = "0")int page,
                                      @RequestParam(name = "size", defaultValue = "6") int size,
                                      @RequestParam(name = "typeBatch", defaultValue = "")TypeBatch typeBatch){
        return batchService.getByTypeBatch(typeBatch, PageRequest.of(page, size));
    }
    @GetMapping("/typeProcess/")
    @ApiOperation("get batch by type process")
    public Page<Batch> getBatchsByTypeProcess(@RequestParam(name = "page", defaultValue = "0")int page,
                                           @RequestParam(name = "size", defaultValue = "6") int size,
                                           @RequestParam(name = "typeProcess", defaultValue = "")TypeProcess typeProcess){
        return batchService.getByTypeProcess(typeProcess, PageRequest.of(page, size));
    }

}
