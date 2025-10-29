package com.sada.LibraryManagement.repository;

import com.sada.LibraryManagement.Model.Bookdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Bookdetails, String> {
}
