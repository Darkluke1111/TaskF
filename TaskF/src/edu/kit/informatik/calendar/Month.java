
package edu.kit.informatik.calendar;

/**
 * Represents a month of a year.
 * 
 * @author  Tobias Bachert
 * @version 1.00, 2016/10/26
 */
public enum Month {
    /**
     * Represents the first month of the year, 31 days.
     */
    JANUARY,
    /**
     * Represents the second month of the year, 29 days in a leap year, 28 otherwise.
     */
    FEBRUARY,
    /**
     * Represents the third month of the year, 31 days.
     */
    MARCH,
    /**
     * Represents the fourth month of the year, 30 days.
     */
    APRIL,
    /**
     * Represents the fifth month of the year, 31 days.
     */
    MAY,
    /**
     * Represents the sixth month of the year, 30 days.
     */
    JUNE,
    /**
     * Represents the seventh month of the year, 31 days.
     */
    JULY,
    /**
     * Represents the eight month of the year, 31 days.
     */
    AUGUST,
    /**
     * Represents the ninth month of the year, 30 days.
     */
    SEPTEMBER,
    /**
     * Represents the tenth month of the year, 31 days.
     */
    OCTOBER,
    /**
     * Represents the eleventh month of the year, 30 days.
     */
    NOVEMBER,
    /**
     * Represents the twelfth and last month of the year, 31 days.
     */
    DECEMBER;
	
    private static final Month[] MONTHS = values();
    
    /**
     * Returns the month with the specified index.
     * 
     * <p>The specified index has to be between the {@linkplain #toIndex() index} of  {@linkplain #JANUARY} and
     * {@linkplain #DECEMBER} (inclusive).
     * 
     * @param  index the index
     * @return the month
     * @throws IllegalArgumentException if {@code index} is not the index of a month
     */
    public static Month ofIndex(
            final int index) {
        ////
        if (index < 1 || index > MONTHS.length)
            throw new IllegalArgumentException("Bad index " + index);
        return MONTHS[index - 1];
    }
    
    /**
     * Returns the index of the month.
     * 
     * <p>The months are continuously indexed, starting at {@code 1}.
     * 
     * @return the index
     */
    public int toIndex() {
        ////
        return ordinal() + 1;
    }
}
