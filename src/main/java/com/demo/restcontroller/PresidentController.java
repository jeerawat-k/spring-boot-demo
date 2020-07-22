package com.demo.restcontroller;

import com.demo.domain.President;
import com.demo.service.PresidentService;
import com.google.gson.Gson;
import flexjson.JSONDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import flexjson.JSONSerializer;

import java.util.List;
import java.util.Map;

@RestController
public class PresidentController {

    @Autowired
    PresidentService presidentService;

    @RequestMapping("/find=ByPresName")
    public List<President> find(@RequestParam(value = "presName",required = true) String presName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            List<President> result = presidentService.findPresidentByPresName(presName);
            return  result;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getCause());
        }
    }


    @RequestMapping("/findAll")
    public List<President> findAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            List<President> result = presidentService.findAll();
            return  result;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getCause());
        }
    }
    @RequestMapping(value = "/save" ,method = RequestMethod.POST,produces = "text/html;charset=utf-8",headers = "Accept=application/json")
    public ResponseEntity<String> save(@RequestBody String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=utf-8");
        try {
            President president =new JSONDeserializer<President>().use(null, President.class).deserialize(json);
            return new ResponseEntity<String>(new JSONSerializer()
                    .deepSerialize(presidentService.insert(president)), headers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("save fail", headers, HttpStatus.FOUND);
        }
    }
    @RequestMapping(value = "/update" ,method = RequestMethod.POST,produces = "text/html;charset=utf-8",headers = "Accept=application/json")
    public ResponseEntity<String> update(@RequestBody String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=utf-8");
        try {
            President president =new JSONDeserializer<President>().use(null, President.class).deserialize(json);
            return new ResponseEntity<String>(new JSONSerializer()
                    .deepSerialize(presidentService.update(president)), headers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("update fail", headers, HttpStatus.FOUND);
        }
    }



    @RequestMapping(value = "/delete",method = RequestMethod.POST,headers = "Accept=application/json",produces = "text/html;charset=utf-8")
    public ResponseEntity<String> delete(@RequestBody String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {

            List<String> result = new Gson().fromJson( id, List.class );
//            President president =new JSONDeserializer<President>().use(null, President.class).deserialize(json);

//            presidentService.delete(president.getPresId());
            return new ResponseEntity<String>(new JSONSerializer()
                    .deepSerialize("success"), headers, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getCause());
        }
    }


    @RequestMapping("/find=ByPresIdByListMap")
    public List<Map<String,Object>> ByPresIdByListMap(@RequestParam(value = "presName",required = true) String presName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            List<Map<String,Object>> result = presidentService.findPresidentByListMap(presName);
            return  result;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getCause());
        }
    }


    @RequestMapping(value = "/saveByJsonObject" ,method = RequestMethod.POST,produces = "text/html;charset=utf-8",headers = "Accept=application/json")
    public ResponseEntity<String> saveByJsonObject(@RequestBody String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=utf-8");
        try {
            presidentService.insertByJsonObject(json);
            headers.add("statusValidate","0");
            return new ResponseEntity<String>(new JSONSerializer().deepSerialize("success"), headers, HttpStatus.CREATED);
        } catch (Exception e) {
            headers.add("statusValidate","-1");
            return new ResponseEntity<String>("save fail", headers, HttpStatus.FOUND);
        }
    }
}
