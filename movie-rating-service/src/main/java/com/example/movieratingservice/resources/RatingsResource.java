package com.example.movieratingservice.resources;

import java.util.Arrays;
import java.util.List;

import com.example.movieratingservice.model.Rating;
import com.example.movieratingservice.model.UserRating;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingdata")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable Long userId) {
        List<Rating> ratings = Arrays.asList(
            new Rating("1", 5),
            new Rating("2", 4),
            new Rating("3", 2)
        );
         UserRating userRating = new UserRating();
         userRating.setUserRating(ratings);
         return userRating;
    }
}
