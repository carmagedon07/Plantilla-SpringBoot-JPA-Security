package com.api.page.Repository.NorthWind;

import com.api.page.Entities.NorthWind.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<CategoriesEntity,Long> {


}
