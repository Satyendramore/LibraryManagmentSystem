package com.sada.LibraryManagement.repository;

import com.sada.LibraryManagement.Model.IssueRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepo extends JpaRepository<IssueRecord, Integer> {

}
