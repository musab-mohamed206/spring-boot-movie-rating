package com.example.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import com.example.moviecatalogservice.model.CatalogItem;
import com.example.moviecatalogservice.model.Movie;
import com.example.moviecatalogservice.model.UserRating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable Long userId) {
        //Movie movie = restTemplate.getForObject("http://localhost:8082/movie/1", Movie.class);

        //WebClient.builder builder = WebClient.builder();


    //get all rated movie IDs
       UserRating ratings = restTemplate.getForObject("http://movie-rating-service/ratingdata/users/" + userId, UserRating.class);

        return ratings.getUserRating().stream().map(rating-> {
            
            //for each movie ID , call movie info service and get details
            //restTemplate
            Movie movie = restTemplate.getForObject("http://movie-info-service/movie/" + rating.getMovieId(), Movie.class);

            /*
            webClient
            Movie movie = webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/movie/" + rating.getMovieId())
                .retrieve()
                .bodyToMono(Movie.class)
                .block();
            */
            // put them all together
            return new CatalogItem(movie.getName(), "desc", rating.getReating());
        })
         .collect(Collectors.toList());
    }
}
