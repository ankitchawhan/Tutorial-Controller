package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class tutorialController {
    private int id;

    private String title;
    private String title1;
    private String description1;
    private String published1;

    private String title2;
    private String description2;
    private String published2;

    private int id3;
    private String title3;
    private String description3;
    private String published3;

    private String description;

    private boolean published;

    public tutorialController(){

    }

    public tutorialController(String title, String description, boolean published){
        this.title=title;
        this.description=description;
        this.published=published;

    }

}

