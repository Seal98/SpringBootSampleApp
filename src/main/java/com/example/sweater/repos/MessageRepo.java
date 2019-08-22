package com.example.sweater.repos;

import com.example.sweater.domain.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {

    public List<Message> findByTag(String tag);

    @Query("select m from Message m inner join User u on m.author = u.id")
    List<Message> fetchEmpDeptDataRightJoin();

}
