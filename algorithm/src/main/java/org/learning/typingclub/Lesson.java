package org.learning.typingclub;

import lombok.Data;

import java.util.List;

@Data
public class Lesson {

    private Integer id;

    private Boolean is_game;

    private Integer score;

    private Activity activity;

    @Data
    public static final class Activity {
        private Integer goal_wpm;
        private Integer min_accuracy;
        private Integer min_wpm;
    }

}
