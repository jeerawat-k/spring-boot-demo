package com.demo.service;

import com.demo.domain.President;
import com.demo.repository.PresidentJDBCRepository;
import com.demo.repository.PresidentRepository;
import com.demo.util.ConnectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@Service
public class PresidentServiceImpl implements  PresidentService {
    @Autowired
    PresidentJDBCRepository presidentJDBCRepository;
    @Autowired
    ConnectionUtil connectionUtil;
    @Autowired
    PresidentRepository presidentRepository;

    @Override
    public List<President> findPresidentByPresName(String presName) {
        Connection conn = null;
        PreparedStatement pstm = null;
        Long number = null;
        List<President> presidents =new ArrayList<>();
        try{
            conn = connectionUtil.getOracleConnection();
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT PRES_ID, PRES_NAME, BIRTH_YR, YRS_SERV, \n");
            sql.append(" DEATH_AGE ,PARTY,STATE_BORN ");
            sql.append(" FROM PRESIDENT  ");
            sql.append(" WHERE PRES_NAME LIKE ?  ");
            if (conn == null) {
                throw new RuntimeException("Can't connect DB");
            }
            pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1,"%"+presName+"%");
            ResultSet rs = pstm.executeQuery();
            Long id = 0l;
            if(rs.next()){
              President pd = new President();
              pd.setPresId(rs.getLong(1));
              pd.setPresName(rs.getString(2));
              pd.setBirthYr(rs.getLong(3));
              pd.setYrsServ(rs.getLong(4));
              pd.setDeatgAge(rs.getLong(5));
              pd.setParty(rs.getString(6));
              pd.setStateBorn(rs.getString(6));
              presidents.add(pd);
            }

            return presidents;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<President> findAll() {
        try{
            return presidentRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public President insert(President president) {
        try {
            return presidentRepository.save(president);
        }catch (Exception e){
            e.printStackTrace();
            throw new  RuntimeException(e.getMessage());
        }
    }

    @Override
    public void insertByJsonObject(String json) {
        President president = new President();
        try {
            JSONObject jsonObject = new JSONObject(json);

            String prasName = jsonObject.getString("presName");
            Long birthYr = jsonObject.getLong("birthYr");
            Long yrsServ = jsonObject.getLong("yrsServ");
            Long deatgAge = jsonObject.getLong("deatgAge");
            String party = jsonObject.getString("party");
            String stateBorn = jsonObject.getString("stateBorn");

            president.setPresName(prasName);
            president.setBirthYr(birthYr);
            president.setYrsServ(yrsServ);
            president.setDeatgAge(deatgAge);
            president.setParty(party);
            president.setStateBorn(stateBorn);
            presidentRepository.save(president);
        }catch (Exception e){
            e.printStackTrace();
            throw new  RuntimeException(e.getMessage());
        }
    }


    @Override
    public President update(President president) {
        try{
                President presidentOld = presidentRepository.getOne(president.getPresId());
                presidentOld.setParty(president.getParty());
                presidentOld.setStateBorn(president.getStateBorn());
                presidentOld.setDeatgAge(president.getDeatgAge());
                presidentOld.setYrsServ(president.getYrsServ());
                presidentOld.setPresName(president.getPresName());
                presidentOld.setBirthYr(president.getBirthYr());
               return   presidentRepository.saveAndFlush(presidentOld);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void delete(Long presId) {
        try{
            presidentRepository.deleteById(presId);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }



    @Override
    public List<Map<String,Object>> findPresidentByListMap(String presName) {
        Connection conn = null;
        PreparedStatement pstm = null;
        Long number = null;
        List<President> presidents =new ArrayList<>();

        List<Map<String,Object>> resultList = new ArrayList<>();
        Map<String,Object> resultMap = new HashMap<>();
        try{
            conn = connectionUtil.getOracleConnection();
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT PRES_ID, PRES_NAME, BIRTH_YR, YRS_SERV, \n");
            sql.append(" DEATH_AGE ,PARTY,STATE_BORN ");
            sql.append(" FROM PRESIDENT ");
            sql.append(" WHERE PRES_NAME LIKE ? ");
            if (conn == null) {
                throw new RuntimeException("Can't connect DB");
            }
            pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1,"%"+presName+"%");
            ResultSet rs = pstm.executeQuery();
            Long id = 0l;

            while (rs.next()){
                resultMap = new HashMap<>();
                resultMap.put("PRES_ID",(Long) rs.getLong(1));
                resultMap.put("PRESS_NAME",rs.getString(2));
                resultMap.put("BIRTH_YR",(Long) rs.getLong(3));
                resultMap.put("YRS_SERV",(Long) rs.getLong(4));
                resultMap.put("DEATH_AGE",(Long) rs.getLong(5));
                resultMap.put("PRATY",rs.getString(6));
                resultMap.put("STATE_BORN",rs.getString(7));
                resultList.add(resultMap);
            }
            return resultList;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
