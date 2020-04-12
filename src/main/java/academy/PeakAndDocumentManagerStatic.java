package academy;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PeakAndDocumentManagerStatic implements PeakAndDocumentMgr {

    private static HashMap<DayOfWeek, List<Integer>> rules;

    public PeakAndDocumentManagerStatic(){
        System.out.println("INITIALIZING THE PEAK AND PLATE MANAGER");
        rules = new HashMap<>();

        rules.put( DayOfWeek.MONDAY, Arrays.asList(1,2,3));
        rules.put( DayOfWeek.TUESDAY, Arrays.asList(4,5,6));
        rules.put( DayOfWeek.WEDNESDAY, Arrays.asList(7,8,9));
        rules.put( DayOfWeek.THURSDAY, Arrays.asList(0,1,2));
        rules.put( DayOfWeek.FRIDAY, Arrays.asList(3,4,5));
        rules.put( DayOfWeek.SATURDAY, Arrays.asList(6,7,8));
        rules.put( DayOfWeek.SUNDAY, Arrays.asList(9,0));
    }

    @Override
    public boolean canIGoOut(String document, DayOfWeek desiredDay) {
        String lastDigit = document.substring( document.length()-1 );

        System.out.println("Last digit "+lastDigit);

        int number = Integer.parseInt( lastDigit );

        return rules.get( desiredDay ).contains( number );
    }

    @Override
    public List<Integer> getDigitsByDay(DayOfWeek desiredDay) {
        List<Integer> digits = rules.get( desiredDay );
        return digits;
    }

    @Override
    public List<DayOfWeek> getDaysPerDigit(Integer digit) {
        return rules.entrySet().stream()
                .filter( day -> day.getValue().contains( digit ))
                .map( map -> map.getKey() )
                .sorted()
                .collect( Collectors.toList());
    }

    @Override
    public List<DayOfWeek> getDaysPerDocument( String document ){
        String lastDigit = document.substring( document.length()-1 );
        int digit = Integer.parseInt( lastDigit );
        return rules.entrySet().stream()
                .filter( day -> day.getValue().contains( digit ))
                .map( map -> map.getKey() )
                .sorted()
                .collect( Collectors.toList());
    }
}
