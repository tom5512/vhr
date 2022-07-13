package com.qingqiao.vhr.controller.system.basic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingqiao.vhr.bean.Menu;
import com.qingqiao.vhr.bean.Position;
import com.qingqiao.vhr.service.PositionService;
import com.qingqiao.vhr.utils.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/system/basic")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping("/pos")
    public String getAllPosition() throws JsonProcessingException {
        List<Position> list=positionService.getAllPosition();
        return new ObjectMapper().writeValueAsString(list);
    }
    @PostMapping("/pos")
    public ResponseBean insertPosition(@RequestBody Position position){
        if(positionService.insertPosition(position)==1){
            return ResponseBean.ok("添加成功!");
        }
        return ResponseBean.error("添加失败!");
    }
    @PutMapping("/pos")
    public ResponseBean updatePosition(@RequestBody Position position){
        if(positionService.updatePosition(position)==1){
            return ResponseBean.ok("修改成功!");
        }
        return ResponseBean.error("修改失败!");
    }

    @DeleteMapping("/pos/{id}")
    public ResponseBean deletePosition(@PathVariable Integer id){
        if(positionService.deletePosition(id)==1){
            return ResponseBean.ok("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }

    @DeleteMapping("/pos/many/{ids}")
    public ResponseBean deletePositionMany(@PathVariable Integer[] ids){
        if(positionService.deletePositionByIDS(ids) == ids.length){
            return ResponseBean.ok("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }

}
