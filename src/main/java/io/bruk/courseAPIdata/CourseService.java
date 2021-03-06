package io.bruk.courseAPIdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicid) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicid).forEach(courses::add);
        return courses;
    }

    public Optional<Course> getCourse(String id) {

        return courseRepository.findById(id);
    }

    public void addCourse(Course course) {
        //topics.add(topic);
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }


}
