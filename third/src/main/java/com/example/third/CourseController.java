package com.example.third;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;
    
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }
    
    @GetMapping("/{courseID}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long courseID) {
        Optional<Course> course = courseRepository.findById(courseID);
        return course.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    
    @PutMapping("/{courseID}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long courseID, @RequestBody Course updatedCourse) {
        Optional<Course> existingCourse = courseRepository.findById(courseID);
        if (existingCourse.isPresent()) {
            updatedCourse.setCourseID(courseID);
            return ResponseEntity.ok(courseRepository.save(updatedCourse));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{courseID}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseID) {
        courseRepository.deleteById(courseID);
        return ResponseEntity.noContent().build();
    }
}
