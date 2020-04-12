package academy;

import java.time.DayOfWeek;
import java.util.List;

public interface PeakAndDocumentMgr {

    /**
     * Method that tells if a given document can go outside on a specific
     * day according to its last digit
     * @param document
     * @param desiredDay
     * @return
     */
    boolean canIGoOut( String document, DayOfWeek desiredDay );

    /**
     * Method that retrieves the digits allowed to go outside a given day
     * @param desiredDay
     * @return
     */
    List<Integer> getDigitsByDay(DayOfWeek desiredDay );

    /**
     * Method that retrieves the Days of the week configured for a Given digit
     * @param digit
     * @return
     */
    List<DayOfWeek> getDaysPerDigit( Integer digit );

    /**
     * Method that retrieves the days in which a given document is allowed
     * @param document
     * @return
     */
    List<DayOfWeek> getDaysPerDocument( String document );
}
