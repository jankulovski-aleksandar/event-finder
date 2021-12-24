package com.eventsfinder.event.repository;

import com.eventsfinder.event.domain.enumerations.Category;
import com.eventsfinder.event.domain.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    List<Event> findAllByCategory(Category category);

    //@Query("select * from Event where location.country like country or location.city like city or location.address like address")
    //List<Event> findAllByLocation(@Param("country") String country,@Param("city") String city,@Param("address") String address);

    @Query("select e from Event e where e.location.country like :country")
    List<Event> findAllByCountry(@Param("country") String country);

    @Query("select e from Event e where e.location.city like :city")
    List<Event> findAllByCity(@Param("city") String city);

    @Query("select e from Event e where e.location.address like :address")
    List<Event> findAllByAddress(@Param("address") String address);

}