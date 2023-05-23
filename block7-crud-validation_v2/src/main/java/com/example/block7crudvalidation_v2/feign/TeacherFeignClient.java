package com.example.block7crudvalidation_v2.feign;

import com.example.block7crudvalidation_v2.dto.output.TeacherOutputDtoSimple;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localhost:8081/teacher", name = "teacherFeignClient")
public interface TeacherFeignClient {
    @GetMapping("/{id}")
    TeacherOutputDtoSimple getTeacherByIdSimple(int id);
}