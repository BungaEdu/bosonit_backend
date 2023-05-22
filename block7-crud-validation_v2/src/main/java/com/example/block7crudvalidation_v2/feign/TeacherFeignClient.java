package com.example.block7crudvalidation_v2.feign;

import com.example.block7crudvalidation_v2.dto.output.TeacherOutputDtoSimple;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8081", name = "teacherFeignClient")
public interface TeacherFeignClient {
    @GetMapping("teacher/{id}")
    TeacherOutputDtoSimple getTeacherById(@PathVariable String id);
}