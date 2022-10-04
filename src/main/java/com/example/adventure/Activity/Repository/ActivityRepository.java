package com.example.adventure.Activity.Repository;

import com.example.adventure.Activity.Model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    Activity findByName(String name);


}
