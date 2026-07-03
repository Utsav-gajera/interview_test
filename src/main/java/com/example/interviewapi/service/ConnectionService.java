package com.example.interviewapi.service;

import java.time.LocalDateTime;

import javax.management.RuntimeErrorException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.interviewapi.dto.connreq;
import com.example.interviewapi.dto.req;
import com.example.interviewapi.dto.res;
import com.example.interviewapi.entity.Connection;
import com.example.interviewapi.entity.User;
import com.example.interviewapi.entity.connres;
import com.example.interviewapi.repository.ConnectionRepository;
import com.example.interviewapi.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConnectionService {
    
    private final ConnectionRepository connectionRepository;
        private final ModelMapper modelMapper;
                private final UserRepository userRepository;



    public connres sendreq(connreq conn, Long from_id) {
        connres res = new connres();
        res.setFrom_id(from_id);
        res.setTo_id(conn.to_id());
        Connection connection = modelMapper.map(res, Connection.class); 
        connection.setAction("PENDING");

        User user = userRepository.findById(from_id).orElseThrow();

        if(conn.to_id() == from_id){
            throw new RuntimeException("A user cannot connect with themselves");
        }

        if(connection.getAction().equals("ACCEPT")){
            throw new RuntimeException("These users are already connected");
        }
        

        connectionRepository.save(connection);      
        res.setId(connection.getId()); 
        return res;
    }


    public res resReq(req request,Long from_id) {

        Connection conn = connectionRepository.findById(request.conn_id()).orElseThrow();
        
        if(conn.getTo_id() != from_id){
            throw new RuntimeException("Only the receiver of the connection request can respond to it");
        }
        

        res resp = new res();
        resp.setConn(request.conn_id());
        resp.setStatus(request.action());

        resp.setA_time(LocalDateTime.now());
        resp.setC_time(LocalDateTime.now());
        resp.setFrom_id(conn.getTo_id());
        resp.setTo_id(conn.getFrom_id());

        conn.setAction(request.action());

        connectionRepository.save(conn);

        return resp;

    }

}
