import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**Every day the GFT team publishes the ranking of each
 * player (one player can be published several times a day)
 *
 * You need to build a method that is able to get the 3 best players
 * for a given date. Each player has to aggregate its ranking marks
 * in the same date to deduce who is the best
 *
 * the NFR requirement is that the method that gets the 3 best players
 * per date has a time complexity of O(1) (the minimum one)
 */

public class Rankings {

    /********************** class vars  ****************************/

    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");

    private final String May01st = "2022-05-01";
    private final String May02nd = "2022-05-02";
    private final String May03rd = "2022-05-03";
    private final String May04th = "2022-05-04";

    private final String David = "David";
    private final String Jeff = "Jeff";
    private final String Kim = "Kim";
    private final String Peter = "Peter";

    /********************** input data  ****************************/
    private List<Score> buildData() throws Exception{
        List<Score> scores = new ArrayList<>();
        scores.add(new Score(May01st,David,456));
        scores.add(new Score(May01st,Jeff,512));
        scores.add(new Score(May01st,Jeff,605));
        scores.add(new Score(May01st,Kim,256));
        scores.add(new Score(May01st,Kim,331));
        scores.add(new Score(May01st,Kim,610));
        scores.add(new Score(May01st,Peter,100));

        scores.add(new Score(May02nd,David,560));

        scores.add(new Score(May03rd,David,222));

        scores.add(new Score(May04th,David,456));
        scores.add(new Score(May04th,David,676));
        scores.add(new Score(May04th,Jeff,192));
        scores.add(new Score(May04th,Jeff,653));
        scores.add(new Score(May04th,Kim,525));
        scores.add(new Score(May04th,Kim,599));

        return scores;

    }



    @Test
    public void testBest3Scorers() throws Exception{

        ingestData(buildData());

        //2022-05-01
        final List<Score> bestMay01st = best3TopPlayersByDate(string2date(May01st));
        assert bestMay01st != null && bestMay01st.size()==3;
        assert isSameScore(bestMay01st.get(0), May01st, Kim, 1197);
        assert isSameScore(bestMay01st.get(1), May01st, Jeff, 1117);
        assert isSameScore(bestMay01st.get(2), May01st, David, 456);


        //2022-05-02
        final List<Score> bestMay02nd = best3TopPlayersByDate(string2date(May02nd));
        assert bestMay02nd != null && bestMay02nd.size()==1;
        assert isSameScore(bestMay02nd.get(0), May02nd, David, 560);

        //2022-05-03
        final List<Score> bestMay03rd = best3TopPlayersByDate(string2date(May03rd));
        assert bestMay03rd != null && bestMay03rd.size()==1;
        assert isSameScore(bestMay03rd.get(0), May03rd, David, 222);

        //2022-05-04
        final List<Score> bestMay04th = best3TopPlayersByDate(string2date(May04th));
        assert bestMay04th != null && bestMay04th.size()==3;
        assert isSameScore(bestMay04th.get(0), May04th, David, 1132);
        assert isSameScore(bestMay04th.get(1), May04th, Kim, 1124);
        assert isSameScore(bestMay04th.get(2), May04th, Jeff, 845);

    }


    /************************ model  *******************************/
    private class Score {
        Date date;
        String player;
        Integer ranking;
        Score( String _dateStr, String _player, Integer _score ) throws Exception {
            date = string2date(_dateStr);
            player= _player;
            ranking = _score;
        }

        @Override
        public String toString(){
            return date2String(this.date) + " - " + this.player + "-" + this.ranking;
        }


    }

    /**************** utility methods *******************************/
    private boolean isSameScore(Score source, String expectedDate, String expectedName, int expectedScore){
        return source != null && date2String(source.date).equals(expectedDate) && source.player.equals(expectedName) && source.ranking.equals(expectedScore);
    }
    private Date string2date(String dateString) throws ParseException{
        return ft.parse(dateString);
    }
    private String date2String(Date date){
        return ft.format(date);
    }




    /*********************** to be done BY THE CANDIDATE SOLUTION ******************************/

    Map<Date,List<Score>> orderedScoresByDate = new HashMap<>();

    private void ingestData(List<Score> scores){
        //TODO
        for(Score score : scores){
            if(orderedScoresByDate.get(score.date) == null){
                orderedScoresByDate.put(score.date, new ArrayList());
                orderedScoresByDate.get(score.date).add(score);
            }else{
                Score scoreToUpdate = findScoreByDateAndPlayerName(orderedScoresByDate.get(score.date), score.date, score.player);
                if(scoreToUpdate != null){
                    scoreToUpdate.ranking += score.ranking;
                }else{
                    orderedScoresByDate.get(score.date).add(score);
                }
            }

            orderListByScore(orderedScoresByDate.get(score.date));

        }//for

        //this is to get constant time when accessing
        orderedScoresByDate.keySet().forEach(date -> orderedScoresByDate.put(date,sliceLists(orderedScoresByDate.get(date),3)));

    }

    private void orderListByScore(List<Score> scores){

        Collections.sort(scores, new Comparator<Score>(){
            public int compare(Score o1, Score o2) {
                // compare two instance of `Score` and return `int` as result.
                return o2.ranking.compareTo(o1.ranking);
            }
        });
    }

    private List<Score> best3TopPlayersByDate(Date date) {
        //TODO
        //if we have made the slicing on the ingest, this method is not necessary
        /*int finalSize = orderedScoresByDate.get(date).size() >2 ? 3 : orderedScoresByDate.get(date).size();
        return orderedScoresByDate.get(date) != null ? orderedScoresByDate.get(date).subList(0,finalSize)  : Collections.EMPTY_LIST;*/
        return orderedScoresByDate.get(date);
    }

    private List<Score> sliceLists(List<Score> scores, int maxSize) {
        //TODO
        if(scores != null && !scores.isEmpty()){
            int finalSize = scores.size() >maxSize-1 ? maxSize : scores.size();
            return scores.subList(0,finalSize)  ;
        }
        return Collections.EMPTY_LIST;
    }

    private Score findScoreByDateAndPlayerName(List<Score> scores, Date date, String playerName){
        if(scores != null && !scores.isEmpty()){
            return scores.stream().filter(s->s.player.equals(playerName) && s.date.equals(date)).findFirst().orElse(null);
        }
        return null;
    }

    /*********************** to be done BY THE CANDIDATE SOLUTION ******************************/




}

