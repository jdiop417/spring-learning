package org.learning.typingclub;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;

import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Data
public class UnPerfectGame extends Game {
    private Integer goal_wpm;
    private Integer min_accuracy;
    private Integer min_wpm;

    // gap=goal_wpm*4-wpm
    private Integer gap;


    public static void main(String[] args) throws Exception {
        // extract
        List<Lesson> lessons = new Gson().fromJson(new FileReader("algorithm/src/main/java/org/learning/typingclub/Lessions.json"), new TypeToken<List<Lesson>>() {
        }.getType());

        List<Game> games = new Gson().fromJson(new FileReader("algorithm/src/main/java/org/learning/typingclub/Games.json"), new TypeToken<List<Game>>() {
        }.getType());

        // transfer
        // map<id,activity>
        Map<Integer, Lesson.Activity> activities = lessons.stream()
                .filter(lesson -> !lesson.getIs_game() && lesson.getActivity() != null && lesson.getActivity().getGoal_wpm() != null)
                .collect(Collectors.toMap(Lesson::getId, Lesson::getActivity));
        List<UnPerfectGame> unPerfectGames = games.stream()
                .filter(game -> !game.isPerfect_score() && game.getWpm() != 0)
                .map(game -> {
                    Lesson.Activity activity = activities.get(game.getLesson_id());
                    if (activity == null) {
                        return null;
                    }
                    UnPerfectGame retVal = new UnPerfectGame();
                    retVal.setLesson_id(game.getLesson_id());
                    retVal.setWpm(game.getWpm());
                    retVal.setGoal_wpm(activity.getGoal_wpm());
                    retVal.setMin_wpm(activity.getMin_wpm());
                    retVal.setGap(activity.getMin_wpm() * 2 - game.getWpm());
                    retVal.setAttempt_count(game.getAttempt_count() == null ? 0 : game.getAttempt_count());
                    return retVal;
                })
                .filter(Objects::nonNull)
                .sorted(comparing(UnPerfectGame::getGap).thenComparing(comparing(UnPerfectGame::getGoal_wpm).reversed()).thenComparing(comparing(UnPerfectGame::getAttempt_count).reversed()))
                .collect(Collectors.toList());

        // load
        System.out.println();
        System.out.println(new Gson().toJson(unPerfectGames));
        System.out.println();
    }


}
