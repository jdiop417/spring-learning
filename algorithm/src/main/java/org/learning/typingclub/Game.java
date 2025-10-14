package org.learning.typingclub;

import lombok.Data;

@Data
public class Game {

/*
* {
			"accuracy": 100,
			"attempt_count": 4,
			"id": 1761749396,
			"lesson_id": 221,
			"msecs": 171000,
			"perfect_score": true,
			"resource_uri": "/api/v1.1/lessongame/1761749396/",
			"score": 3000,
			"stars": 5,
			"wpm": 45
		}
* */

    private Integer accuracy;
    private Integer attempt_count;
    private Integer id;
    private Integer lesson_id;
    private Integer msecs;
    private boolean perfect_score;
    private String resource_uri;
    private String score;
    private String stars;
    private Integer wpm;
}
