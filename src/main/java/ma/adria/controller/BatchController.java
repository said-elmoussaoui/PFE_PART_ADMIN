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
    public Page<Batch> getAll(@RequestParam(name = "page", defaultValue = "0")int page,
                              @RequestParam(name = "size", defaultValue = "6") int size){
        return batchService.getAllBatchs(PageRequest.of(page, size));
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
    @GetMapping("/search")
    @ApiOperation("get batchs by name LIKE , type and process")
    public Page<Batch> search(@RequestParam(name = "page", defaultValue = "0")int page,
                                      @RequestParam(name = "size", defaultValue = "6") int size,
                                      @RequestParam(name = "keyword", defaultValue = "")String keyword,
                                      @RequestParam(name="type",defaultValue = "") TypeBatch type,
                                      @RequestParam(name="process",defaultValue = "") TypeProcess process
                                      ){
        return batchService.search(page,size,keyword,type,process);
    }

}
