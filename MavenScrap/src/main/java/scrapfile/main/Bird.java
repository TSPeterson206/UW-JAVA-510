package scrapfile.main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author toby
 *
 */
public class Bird extends Animal implements PetInterface {

    private ArrayList<String> activityLog = new ArrayList<String>();

    public void makeNoise() {
        // TODO Auto-generated method stub
        System.out.println("Tweet! Im a bird!");
    }

    public Bird(List log) {
        System.out.println(log);
        log.forEach(System.out::println);
    }

    public List<String> getLogForAll() {
        return super.getLog();
    };
}
