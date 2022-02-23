import java.util.*;

public class Hobbies {

    private final HashMap<String, String[]> hobbies = new HashMap<String, String[]>();

    public void add(String hobbyist, String... hobbies) {
        this.hobbies.put(hobbyist, hobbies);
    }

    public List<String> findAllHobbyists(String hobby) {
        List<String> stringList = new ArrayList<>();

        Set<Map.Entry<String, String[]>> entries = hobbies.entrySet();
        List keys = new ArrayList(hobbies.keySet());
        for (int i = 0; i < keys.size(); i++) {
            for (int i1 = 0; i1 < hobbies.get(keys.get(i)).length; i1++) {
                hobbies.get(keys.get(i));
                if (hobbies.get(keys.get(i))[i1].equals(hobby))
                    stringList.add((String) keys.get(i));
            }


        }
        return stringList;
    }

    public static void main(String[] args) {
        Hobbies hobbies = new Hobbies();
        hobbies.add("Steve", "Fashion", "Piano", "Reading");
        hobbies.add("Patty", "Drama", "Magic", "Pets");
        hobbies.add("Chad", "Puzzles", "Pets", "Yoga");

        System.out.println(Arrays.toString(hobbies.findAllHobbyists("Yoga").toArray()));
    }
}